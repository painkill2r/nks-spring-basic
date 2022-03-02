package kr.co.fastcampus.spring.basic.ch2.yoil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {

    /**
     * URL Query String의 값을 통해 요일을 구하고 브라우저에 출력하는 메소드
     * Ex) http://localhost:8080/getYoilMVC?year=2022&month=2&day=26
     *
     * @param year
     * @param month
     * @param day
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/getYoilMVC")
    public String main(int year, int month, int day, Model model) throws IOException {
        if (!isVaild(year, month, day)) {
            return "yoil/yoilError";
        }

        char yoil = getYoil(year, month, day);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        return "yoil/yoil";
    }

    private boolean isVaild(int year, int month, int day) {
        return true;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1: 일요일 ~ 7: 토요일

        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
