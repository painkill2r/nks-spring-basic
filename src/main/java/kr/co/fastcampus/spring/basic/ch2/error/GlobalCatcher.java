package kr.co.fastcampus.spring.basic.ch2.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

//@ControllerAdvice("kr.co.fastcampus.spring.basic2") // 컨트롤러 어드바이스를 적용시킬 패키지를 설정할 수 있음.
@ControllerAdvice
public class GlobalCatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalCatcher.class);

    /**
     * @param ex
     * @return
     */
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex) {
        LOGGER.info("GlobalCatcher#catcher()");
        return "error/error";
    }

    /**
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
    @ExceptionHandler({NullPointerException.class, ClassCastException.class})
    public String catcher2(Exception ex) {
        LOGGER.info("GlobalCatcher#catcher2()");
        return "error/error";
    }

    /**
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 200 -> 400
    @ExceptionHandler(FileNotFoundException.class)
    public String catcher3(Exception ex) {
        LOGGER.info("GlobalCatcher#catcher3()");
        return "error/error";
    }
}
