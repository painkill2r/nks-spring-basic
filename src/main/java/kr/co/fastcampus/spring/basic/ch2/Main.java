package kr.co.fastcampus.spring.basic.ch2;

import kr.co.fastcampus.spring.basic.controller.HelloController;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        //HelloController helloController = new HelloController();
        //helloController.main2(); //HelloController#main2()가 private이라서 외부 호출 불가

        /**
         * Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
         * java.lang.reflect 패키지를 제공
         */
        //HelloController 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
        Class helloControllerClass = Class.forName("kr.co.fastcampus.spring.basic.controller.HelloController");
        HelloController helloController = (HelloController) helloControllerClass.newInstance(); //Class 객체가 가진 정보로 객체 생성
        Method main2 = helloControllerClass.getDeclaredMethod("main2"); //HelloController#main2() 메소드 정보
        main2.setAccessible(true); //private인 HelloController#main2() 메소드를 호출 가능하게 한다.

        main2.invoke(helloController); //helloController.main2()와 동일
    }
}
