package kr.co.fastcampus.spring.basic.ch2.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400
class MyException extends RuntimeException {
    MyException(String msg) {
        super(msg);
    }

    public MyException() {
        this("");
    }
}

@Controller
public class ExceptionController2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController2.class);

    @RequestMapping("/ex4")
    public String main() throws Exception {
        throw new MyException("예외가 발생했습니다.");
    }

    @RequestMapping("/ex5")
    public String main2() throws Exception {
        throw new SQLException("예외가 발생했습니다.");
    }
}
