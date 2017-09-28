package site.imis.wx.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import site.imis.wx.common.consts.WxConsts;

import java.util.Arrays;

/**
 *  微信校验工具类
 * Created by kevin无道 on 2017/8/21.
 */
public class WxCheckUtil {

    /**
     * 根据微信开发者文档，实现签名验证
     * @param signature 微信后台传过来的签名数据
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return
     */
    public static boolean checkWxSignature(String signature, String timestamp, String nonce) {
        //将参数组装成数组，便于后续操作
        String[] arr = new String[]{WxConsts.TOKEN, timestamp, nonce};

        //对参数进行排序
        Arrays.sort(arr);

        //生成字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i]);
        }

        //SHA1加密
        String hexStr = DigestUtils.sha1Hex(buffer.toString());

        return hexStr.equals(signature);
    }
}