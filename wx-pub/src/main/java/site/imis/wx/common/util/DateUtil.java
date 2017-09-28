package site.imis.wx.common.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by kevin无道 on 2017/8/19.
 */
public class DateUtil {

    private final static String DATE_SEPERATOR = "-";

    /**
     * 获取日期的月天值
     * @param days 当前日期的前后多少天<br/>
     *             0代表当天，正数代表当前之后的天数，负数代表当天之前的天数<br/>
     *             周、月份、年请换算成天
     * @param seperator 分隔符，未对整型数字做处理，请使用分隔符。当前默认只能使用默认的分隔符
     * @return 日期的月天格式。比如：1-8、9-18
     */
    private static String getMonthDay(int days, String seperator) {
        //首先获取当前日期
        LocalDate date = LocalDate.now();
        return getMonthDay(date, days, seperator);
    }

    /**
     * 获取日期的月天值
     * @param days 当前日期的前后多少天<br/>
     *             0代表当天，正数代表当前之后的天数，负数代表当天之前的天数<br/>
     *             周、月份、年请换算成天
     * @return 日期的月天格式(使用默认的分隔符)。比如：1-8、9-18
     */
    public static String getMonthDay(int days) {
        return getMonthDay(days, DATE_SEPERATOR);
    }

    public static String getMonthDay(LocalDate date, int days, String seperator) {
        //当前默认只能使用默认分隔符
        seperator = DATE_SEPERATOR;
        //对当前日期进行加减
        LocalDate goalDate = getLocalDate(date, days);
        //获取月份和天
        int month = goalDate.getMonthValue();
        int day = goalDate.getDayOfMonth();
        //格式化返回
        return month + seperator + day;
    }

    public static String getMonthDay(LocalDate date, int days) {
        return getMonthDay(date, days, DATE_SEPERATOR);
    }

    public static LocalDate getLocalDate(int days) {
        return getLocalDate(LocalDate.now(), days);
    }

    public static LocalDate getLocalDate(LocalDate date, int days) {
        return date.plus(days, ChronoUnit.DAYS);
    }

    /**
     * 计算两个日期之间的间隔天数<br/>
     * @param begin 开始日期
     * @param end 结束日期
     * @return 间隔天数的绝对值，也就是实际可以不考虑时间先后
     */
    public static long getDiffDays(LocalDate begin, LocalDate end) {
        long diff = Math.abs(end.toEpochDay() - begin.toEpochDay());
        return diff;
    }

    public static void main(String[] args) {
        String md = getMonthDay(7);
        System.out.println(md);
        System.out.println(0x04bd8);
    }
}
