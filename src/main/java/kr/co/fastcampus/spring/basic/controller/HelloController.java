package kr.co.fastcampus.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //1. 프로그램 등록
public class HelloController {

    //2. URL과 main()을 연결
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void main() {
        System.out.println("Hello");
    }
}
