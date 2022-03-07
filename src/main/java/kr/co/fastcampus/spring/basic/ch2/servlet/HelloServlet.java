package kr.co.fastcampus.spring.basic.ch2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    /**
     * 서블릿이 초기화 될 때 자동 호출되는 메소드
     * - 서블릿의 초기화 작업 담당
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("[HelloServlet] init() is called.");
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 입력
        //2. 처리
        //3. 출력
        System.out.println("[HelloServlet] service() is called.");
    }

    /**
     * 서블릿이 메모리에서 제거될 때  서블릿 컨테이너에 의해서 자동으로 호출되는 메소드
     * - 뒷 처리 담당
     */
    @Override
    public void destroy() {
        System.out.println("[HelloServlet] destory() is called.");
    }
}
