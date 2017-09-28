package site.imis.wx.common.util;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  与微信有关的消息工具类
 * Created by kevin无道 on 2017/8/22.
 */
public class WxMessageUtil {

    public static Map<String, String> xmlToMap(HttpServletRequest request) throws DocumentException, IOException {
        Map<String, String> map = new HashMap<String, String>();

        SAXReader reader = new SAXReader();

        InputStream in = request.getInputStream();

        Document doc = reader.read(in);
        Element root = doc.getRootElement();
        List<Element> eles = root.elements();

        for(Element ele : eles) {
            map.put(ele.getName(), ele.getText());
        }

        in.close();

        return map;
    }

    public static String textMessageToXml(Object beanObj) {
        XStream stream = new XStream();
        return stream.toXML(beanObj);
    }
}