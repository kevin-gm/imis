package site.imis.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  自定义字符串工具类，一般是其他工具类没有或者没有找到的
 * Created by kevin无道 on 2017/8/23.
 */
public class StringUUtil {

    private final static String UNDER_LINE_PATTERN_STR = "_(\\w)";
    private final static Pattern UNDER_LINE_PATTERN = Pattern.compile(UNDER_LINE_PATTERN_STR);

    /**
     * 将字符串的首字母大写
     * @param str
     * @return
     */
    public static String upperFistLetter(String str) {
        char[] ch = str.toCharArray();
        if(ch[0] >='a' && ch[0] <='z') {
            ch[0] = (char)(ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 下划线转驼峰
     * @param lineStr
     * @return
     */
    public static String underlineToCamel(String lineStr) {
        if(lineStr == null || "".equals(lineStr)) {
            throw new NullPointerException("待转换字符串不能为空");
        }
        //先全部转成小写
        lineStr = lineStr.toLowerCase();
        Matcher matcher = UNDER_LINE_PATTERN.matcher(lineStr);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        underlineToCamel("view_clIck");
    }
}