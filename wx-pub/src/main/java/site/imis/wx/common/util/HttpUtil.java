package site.imis.wx.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  Http请求工具类，使用httpClient实现<br/>
 *  目前编码统一为UTF-8
 * Created by kevin无道 on 2017/8/24.
 */
public class HttpUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    private final static String DEFAULT_HTTP_ENCODING = "UTF-8";

    /**
     * HttpClient连接SSL
     */
    /*public void ssl() {
        CloseableHttpClient httpclient = null;
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream instream = new FileInputStream(new File("d:\\tomcat.keystore"));
            try {
                // 加载keyStore d:\\tomcat.keystore
                trustStore.load(instream, "123456".toCharArray());
            } catch (CertificateException e) {
                e.printStackTrace();
            } finally {
                try {
                    instream.close();
                } catch (Exception ignore) {
                }
            }
            // 相信自己的CA和所有自签名的证书
            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
            // 只允许使用TLSv1协议
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            // 创建http请求(get方式)
            HttpGet httpget = new HttpGet("https://localhost:8443/myDemo/Ajax/serivceJ.action");
            System.out.println("executing request" + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    System.out.println(EntityUtils.toString(entity));
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    /**
     * 发送POST请求
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    public static JSONObject post(String url, Map<String, String> params, String strParam) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);

        UrlEncodedFormEntity uefEntity;
        try {
            if(params != null && !params.isEmpty()) {
                // 创建参数队列
                List<NameValuePair> formparams = formatParams(params);
                uefEntity = new UrlEncodedFormEntity(formparams, DEFAULT_HTTP_ENCODING);
                httppost.setEntity(uefEntity);
            } else if(!StringUtils.isEmpty(strParam)) {
                httppost.setEntity(new StringEntity(strParam,"UTF-8"));
            }
            LOGGER.info("请求的URL为：" + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity, DEFAULT_HTTP_ENCODING);
                    LOGGER.info("POST请求返回的结果为：" + result);
                    return JSON.parseObject(result);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * GET请求，Get请求的参数应该拼接在url上
     * @param url 请求地址
     */
    public static JSONObject get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            LOGGER.info("请求的URL为：" + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                LOGGER.info("请求响应状态为：" + response.getStatusLine());
                if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        String result = EntityUtils.toString(entity, DEFAULT_HTTP_ENCODING);
                        LOGGER.info("GET请求返回的结果为：" + result);
                        return JSON.parseObject(result);
                    }
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上传文件
     */
    public static void upload(String url, String localFilePath, String serverFieldName) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);

            FileBody bin = new FileBody(new File(localFilePath));

            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart(serverFieldName, bin).build();

            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                LOGGER.info("文件上传返回状态：" + response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    LOGGER.info("Upload请求返回的结果为：" + EntityUtils.toString(resEntity, DEFAULT_HTTP_ENCODING));
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 格式化参数集合Map为Http请求认识的参数对象
     * @param params 外部参数Map
     * @return
     */
    private static List<NameValuePair> formatParams(Map<String, String> params) {
        List<NameValuePair> vps = new ArrayList<NameValuePair>(params.size());
        for (Map.Entry<String, String> et : params.entrySet()) {
            vps.add(new BasicNameValuePair(et.getKey(), et.getValue()));
        }
        return vps;
    }

    public static void main(String[] args) {
        /*Map<String, String> map = new HashMap<String, String>();
        map.put("p1", "li");
        map.put("p12", "kevin");
        post("http://localhost:8080/test/v1", map);*/

        get("http://localhost:8080/test/v1?p1=hahah");
    }
}