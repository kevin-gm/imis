package site.imis.repository.user;

import org.springframework.stereotype.Repository;
import site.imis.model.entity.user.User;

/**
 * Created by kevin无道 on 2017/10/14.
 */
@Repository
public interface UserRepository {

    User findByUserName(String userName);
}