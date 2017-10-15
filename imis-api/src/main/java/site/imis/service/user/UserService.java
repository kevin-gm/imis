package site.imis.service.user;

import org.springframework.stereotype.Service;
import site.imis.model.entity.user.User;

/**
 * Created by kevin无道 on 2017/10/15.
 */
public interface UserService {

    User findByUserName(String userName);
}