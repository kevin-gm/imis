package site.imis.commons.utils;

/**
 * 反射工具类
 * Created by kevin无道 on 2017/8/27.
 */
public class ReflectUtil {

    public static Object genInstance(String className) {
        Class<?> cls = null;
        try {
            cls = Class.forName(className);
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}