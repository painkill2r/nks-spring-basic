package kr.co.fastcampus.spring.basic.ch2.yoil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class YoilTellerWebDataBinderMVC {

    /**
     * 예외 처리 핸들러
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex) {
        return "yoil/yoilError"; ///WEB-INF/views/yoil/yoilError.jsp
    }

    /**
     * http://localhost:8080/getYoilWebDataBinderMVC?year=2022&month=3&day=28
     *
     * @param date
     * @param model
     * @return
     */
    @RequestMapping("/getYoilWebDataBinderMVC")
    public String main(@ModelAttribute MyDate date, Model model) {
        //1. 유효성 검사
        if (!isValid(date)) {
            return "yoil/yoilError"; ///WEB-INF/views/yoil/yoilError.jsp
        }

        //2. 처리
        char yoil = getYoil(date);

        //3. Model에 작업 결과 저장
        model.addAttribute("myDate", date);
        model.addAttribute("yoil", yoil);

        //4. 작업 결과를 보 여줄 View의 이름을 반환
        return "yoil/yoil"; ///WEB-INF/views/yoil/yoil.jsp
    }

    private char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }

    private char getYoil(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        return " 일월화수목금토".charAt(calendar.get(Calendar.DAY_OF_WEEK));
    }


    private boolean isValid(MyDate date) {
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }

    private boolean isValid(int year, int month, int day) {
        if (year == -1 || month == -1 || day == -1) {
            return false;
        }

        return (1 <= month && month <= 12) && (1 <= day && day <= 31); //간단히 체크
    }
}
