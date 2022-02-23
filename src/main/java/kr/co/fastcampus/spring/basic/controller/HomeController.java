package kr.co.fastcampus.spring.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    /**
     * Index
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Hello");

        LOGGER.info("Welcome home! The client locale is {}.", locale);

        return "index";
    }
}
