package site.imis.web.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/birthday")
public class BirthdayController {

    public void list() {
        Principal principal = (Principal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = principal.getName();
    }

    public void add(String birthType, String birthday, String relateUserName) {

    }
}