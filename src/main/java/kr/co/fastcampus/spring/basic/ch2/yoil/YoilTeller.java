package kr.co.fastcampus.spring.basic.ch2.yoil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {

    private static final Logger LOGGER = LoggerFactory.getLogger(YoilTeller.class);

    /**
     * URL Query String의 값을 통해 요일을 구하고 브라우저에 출력하는 메소드
     * Ex) http://localhost:8080/getYoil?year=2022&month=2&day=26
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.입력
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        //2. 작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1: 일요일 ~ 7: 토요일
        char yoil = " 일월화수목금토".charAt(dayOfWeek);

        //3. 출력
        LOGGER.info("{}년 {}월 {}일은 {}요일입니다.", new String[]{year, month, day, "" + yoil});

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter(); //response 객체에서 브라우저로의 출력 스트림을 얻는다.
        out.println(year + "년 " + month + "월 " + day + "일은 " + yoil + "요일입니다.");
        out.close();
    }
}
