package kr.co.fastcampus.spring.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    int iv = 10; //인스턴스 변수
    static int cv = 20; //클래스(static) 변수

    //2. URL과 메소드를 연결
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void main() {
        LOGGER.info("{}", "Hello");
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    private void main2() {
        LOGGER.info("{}", "Hello");
    }

    //static 메소드 - cv만 사용가능
    public static void main3() {
        //System.out.println(iv); //Error!
        System.out.println(cv);
    }
}
