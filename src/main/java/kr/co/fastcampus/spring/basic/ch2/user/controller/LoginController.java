package kr.co.fastcampus.spring.basic.ch2.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "user/login/loginForm";
    }

    @PostMapping("/login")
    public String login(String id,
                        String pwd,
                        String rememberId) throws Exception {
        //1. id와 pwd를 확인
        if (!loginCheck(id, pwd)) {
            //id와 pwd가 일치하지 않으면 loginForm으로 이동
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "UTF-8");

            return "redirect:/login/login?msg=" + msg;
        }

        //id와 pwd가 일치하면 홈으로 이동
        return "redirect:/";
    }

    private boolean loginCheck(String id, String pwd) {
        return "admin".equals(id) && "1234".equals(pwd);
    }
}
