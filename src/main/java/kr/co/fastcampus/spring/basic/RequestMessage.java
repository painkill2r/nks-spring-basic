package kr.co.fastcampus.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * 요청 헤더 및 메시지 전체 조회
 */
@Controller
public class RequestMessage {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestMessage.class);

    @RequestMapping("/requestMessage")
    public void main(HttpServletRequest request) throws Exception {

        //1. Request Line
        String requestLine = request.getMethod(); //GET 또는 POST
        requestLine += " " + request.getRequestURI(); //ch2/requestMessage
        String queryString = request.getQueryString(); //year=2021&month=10&day=1
        requestLine += queryString == null ? "" : "?" + queryString;
        requestLine += " " + request.getProtocol(); //HTTP/1.1

        LOGGER.info("{}", requestLine);

        //2. Request Headers
        Enumeration<String> e = request.getHeaderNames();

        while (e.hasMoreElements()) {
            String name = e.nextElement();

            LOGGER.info("{}: {}", new String[]{name, request.getHeader(name)});
        }

        //3. Request Body - POST일 때만 해당, GET은 Body가 없음(CONTENT_LENGTH=0)
        final int CONTENT_LENGTH = request.getContentLength();

        if (CONTENT_LENGTH > 0) {
            byte[] content = new byte[CONTENT_LENGTH];

            InputStream in = request.getInputStream();
            in.read(content, 0, CONTENT_LENGTH);

            LOGGER.info(new String(content, "UTF-8")); //year=2021&month=10&day=1
        }
    }
}

