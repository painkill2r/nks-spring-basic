package kr.co.fastcampus.spring.basic.ch2.user.controller;

import kr.co.fastcampus.spring.basic.ch2.user.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    //@GetMapping("/add")
    public String register() {
        return "user/register/registerForm";
    }

    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(User user, Model model) throws Exception {
        if (!isValid(user)) {
            String msg = URLEncoder.encode("아이디를 잘못 입력하셨습니다.", "UTF-8");

            model.addAttribute("msg", msg);

            return "forward:/user/register/add";
            //return "redirect:/register/add";
            //return "redirect:/register/add?msg=" + msg; //URL 재작성(Rewriting)
        }

        return "user/register/registerInfo";
    }

    private boolean isValid(User user) {
        return false;
    }
}
