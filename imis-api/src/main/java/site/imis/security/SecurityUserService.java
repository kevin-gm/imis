package site.imis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import site.imis.model.entity.user.User;
import site.imis.service.user.UserService;

/**
 * 自定义
 * Created by kevin无道 on 2017/10/14.
 */
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if(user == null) {
            //TODO
            throw new RuntimeException("can not find the user");
        }
        return new SecurityUser(user);
    }
}