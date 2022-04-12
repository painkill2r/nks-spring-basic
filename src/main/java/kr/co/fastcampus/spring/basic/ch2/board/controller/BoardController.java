package kr.co.fastcampus.spring.basic.ch2.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("list")
    public String list(HttpServletRequest request) {
        if (!loginCheck(request)) { //로그인을 안했으면 로그인 화면으로 이동
            return "redirect:/login/login?toURL=" + request.getRequestURL();
        }

        return "board/boardList"; //로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean loginCheck(HttpServletRequest request) {
        //1. 세션을 얻어서
        HttpSession session = request.getSession();

        //2. 세션에 id가 있는지 확인
        return session.getAttribute("id") != null;
    }
}
