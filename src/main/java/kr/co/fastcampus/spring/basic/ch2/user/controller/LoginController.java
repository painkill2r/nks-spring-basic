package kr.co.fastcampus.spring.basic.ch2.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 로그인 Form
     *
     * @return
     */
    @GetMapping("/login")
    public String loginForm() {
        return "user/login/loginForm";
    }

    /**
     * 로그아웃
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //1. 세션을 종료
        session.invalidate();

        //2. 홈으로 이동
        return "redirect:/";
    }

    /**
     * 로그인 처리
     *
     * @param id
     * @param pwd
     * @param rememberId input[type="checkbox"]의 값(value가 없는 경우 기본 값은 "on")
     * @param toURL
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public String login(String id,
                        String pwd,
                        boolean rememberId,
                        String toURL,
                        HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        //1. id와 pwd를 확인
        if (!loginCheck(id, pwd)) {
            //id와 pwd가 일치하지 않으면 loginForm으로 이동
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "UTF-8");

            return "redirect:/login/login?msg=" + msg;
        }


        //id와 pwd가 일치하면
        //세션 객체를 얻어오기
        //세션 객체에 id를 저장
        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        if (rememberId) {
            //1. 쿠키 생성
            Cookie cookie = new Cookie("id", id);

            //2. 응답에 저장
            response.addCookie(cookie);
        } else {
            //1. 쿠키 삭제
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);

            //2. 응답에 저장
            response.addCookie(cookie);
        }

        //3. 홈으로 이동
        toURL = toURL == null || toURL.equals("") ? "/" : toURL;

        return "redirect:" + toURL;
    }

    private boolean loginCheck(String id, String pwd) {
        return "admin".equals(id) && "1234".equals(pwd);
    }
}
