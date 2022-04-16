package kr.co.fastcampus.spring.basic.ch2.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

//@ControllerAdvice("kr.co.fastcampus.spring.basic2") // 컨트롤러 어드바이스를 적용시킬 패키지를 설정할 수 있음.
@ControllerAdvice
public class GlobalCatcher {

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error/error";
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error/error";
    }
}
