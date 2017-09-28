package site.imis.wx.model.user;

import java.time.LocalDate;

/**
 * Created by kevin无道 on 2017/8/19.
 */
public class UserBirthInfoPush extends UserBase {

    private LocalDate birthday;
    private String birthType;
    private String address;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBirthType() {
        return birthType;
    }

    public void setBirthType(String birthType) {
        this.birthType = birthType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}