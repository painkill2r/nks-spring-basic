package kr.co.fastcampus.spring.basic.ch2.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * 컨트롤러 어드바이스보다 먼저 동작함.
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex) {
        LOGGER.info("ExceptionController#catcher()");
        return "error/error";
    }

    /**
     * 컨트롤러 어드바이스보다 먼저 동작함.
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
    @ExceptionHandler({NullPointerException.class, ClassCastException.class})
    public String catcher2(Exception ex) {
        LOGGER.info("ExceptionController#catcher2()");
        return "error/error";
    }

    /**
     * 컨트롤러 어드바이스보다 먼저 동작함.
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 200 -> 400
    @ExceptionHandler(FileNotFoundException.class)
    public String catcher3(Exception ex) {
        LOGGER.info("ExceptionController#catcher3()");
        return "error/error";
    }

    @RequestMapping("/ex")
    public String main() throws Exception {
        throw new Exception("예외가 발생했습니다.");
    }

    @RequestMapping("/ex2")
    public String main2() throws Exception {
        throw new NullPointerException("예외가 발생했습니다.");
    }

    @RequestMapping("/ex3")
    public String main3() throws Exception {
        throw new FileNotFoundException("예외가 발생했습니다.");
    }
}
