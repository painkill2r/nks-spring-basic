package kr.co.fastcampus.spring.basic.ch2.dice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class TwoDice {

    /**
     * 두 개의 랜덤 숫자를 만들어서 브라우저에 주사위 이미지를 출력하는 메소드
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping("/rollDice")
    public void main(HttpServletResponse response) throws Exception {
        int idx1 = (int) (Math.random() * 6) + 1;
        int idx2 = (int) (Math.random() * 6) + 1;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\"/img/dice" + idx1 + ".jpg\">");
        out.println("<img src=\"/img/dice" + idx2 + ".jpg\">");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
