package site.imis.wx.qo.user;

/**
 *  用户生日信息查询对象
 * Created by kevin无道 on 2017/8/20.
 */
public class BirthDateQO {

    /**
     * 查询开始日期
     */
    private String beginMonthday;
    /**
     * 查询结束日期
     */
    private String endMonthday;

    public BirthDateQO() {}

    public BirthDateQO(String beginMonthday, String endMonthday) {
        this.beginMonthday = beginMonthday;
        this.endMonthday = endMonthday;
    }

    public String getBeginMonthday() {
        return beginMonthday;
    }

    public void setBeginMonthday(String beginMonthday) {
        this.beginMonthday = beginMonthday;
    }

    public String getEndMonthday() {
        return endMonthday;
    }

    public void setEndMonthday(String endMonthday) {
        this.endMonthday = endMonthday;
    }
}