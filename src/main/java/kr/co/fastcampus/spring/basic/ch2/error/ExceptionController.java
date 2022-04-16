package kr.co.fastcampus.spring.basic.ch2.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    /**
     * 컨트롤러 어드바이스보다 먼저 동작함.
     *
     * @param ex
     * @param model
     * @return
     */
    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error/error";
    }

    /**
     * 컨트롤러 어드바이스보다 먼저 동작함.
     *
     * @param ex
     * @param model
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model model) {
        model.addAttribute("ex", ex);
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
