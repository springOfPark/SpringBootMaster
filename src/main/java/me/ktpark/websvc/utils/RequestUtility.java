package me.ktpark.websvc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@Component
public class RequestUtility {

    private final Logger log = LoggerFactory.getLogger(RequestUtility.class);

    public void printRequestLog(HttpServletRequest req) {

        log.info("[REQUEST] HTTP 서블릿 맵핑 : {}", req.getHttpServletMapping());
        log.info("[REQUEST] REQUEST_URI : {}", req.getRequestURI());
        log.info("[REQUEST] REQUEST_AUTH_TYPE : {}", req.getAuthType());
        log.info("[REQUEST] REQUEST_PATH_TRANSLATED : {}", req.getPathTranslated());
        log.info("[REQUEST] REQUEST_PATH_INFO : {}", req.getPathInfo());
        HttpSession session = req.getSession();
        log.info("[REQUEST] REQUEST_SESSION : {}", session);

        long creationTime = session.getCreationTime();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(creationTime), ZoneId.of("Asia/Seoul"));
        log.info("[REQUEST] REQUEST_SESSION_CREATE_TIME : {}", localDateTime);
        log.info("[REQUEST] REQUEST_SESSION_ID : {}", session.getId());

        req.getHeaderNames().asIterator().forEachRemaining((headerKey) -> {
            if (!headerKey.startsWith("sec-")) {
                log.info("[REQUEST] Header {} : {}", headerKey, req.getHeader(headerKey));
            }
        });

        log.info("======================================================================================");
        req.getParameterNames().asIterator().forEachRemaining((paramKey) -> {
            log.info("[REQUEST] Parameter {} : {}", paramKey, req.getParameter(paramKey));
        });

        req.getParameterMap().forEach((paramKey, paramValues) -> {
            log.info("[REQUEST] ParameterMap {} : ", paramKey);
            Arrays.stream(paramValues).forEach((val) -> log.info(" ==> {}", val));
        });
        log.info("======================================================================================");

    }


    public void printResponseLog(HttpServletResponse res) {

        res.getHeaderNames().forEach((headerKey) -> {
            log.info("[RESPONSE] Header {} : {}", headerKey, res.getHeader(headerKey));
        });

        log.info("[RESPONSE] STATUS : {}", String.valueOf(res.getStatus()));
        log.info("[RESPONSE] CONTENT TYPE : {}", res.getContentType());
        log.info("[RESPONSE] CONTENT CLASS : {}", res.getClass());
    }

    public void printModelAndView(ModelAndView modelAndView) {

        // log.info("[MODEL AND VIEW] {} : ", );

        if (modelAndView != null) {
            System.out.println(modelAndView.getModel());
            System.out.println(modelAndView.getView());
            System.out.println(modelAndView.getViewName());
            System.out.println(modelAndView.getModelMap());
            System.out.println(modelAndView.getStatus());
        }

    }
}
