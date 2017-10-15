package site.imis.model.entity.user;

import lombok.Data;

/**
 * Created by kevin无道 on 2017/10/15.
 */
//@Data
public class Role {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}