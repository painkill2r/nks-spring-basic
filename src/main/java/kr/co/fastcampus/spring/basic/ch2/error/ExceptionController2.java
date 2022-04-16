package kr.co.fastcampus.spring.basic.ch2.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class ExceptionController2 {

    @RequestMapping("/ex4")
    public String main() throws Exception {
        throw new IllegalArgumentException("예외가 발생했습니다.");
    }

    @RequestMapping("/ex5")
    public String main2() throws Exception {
        throw new SQLException("예외가 발생했습니다.");
    }
}
