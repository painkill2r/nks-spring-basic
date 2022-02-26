package kr.co.fastcampus.spring.basic.ch2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 요청 헤더 목록 조회
 */
@Controller
public class RequestHeader {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHeader.class);

    @RequestMapping("/requestHeader")
    public void main(HttpServletRequest request) {
        Enumeration<String> e = request.getHeaderNames();

        while (e.hasMoreElements()) {
            String name = e.nextElement();

            LOGGER.info("{}: {}", new String[]{name, request.getHeader(name)});
        }
    }
}
