package site.imis.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.imis.model.entity.user.User;
import site.imis.repository.user.UserRepository;
import site.imis.service.user.UserService;

/**
 * Created by kevin无道 on 2017/10/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}