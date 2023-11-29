package me.ktpark.websvc.base.controller.extension;

import org.apache.catalina.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class BaseControllerTemplate {

    private final Logger LOGGER = LoggerFactory.getLogger(BaseControllerTemplate.class);

    protected void printRequestInfo(HttpServletRequest req) {

        System.out.println("========================================================================================================");
        req.getHeaderNames().asIterator().forEachRemaining((headerKey) -> {
            if ("host".equals(headerKey)
                    || "content-length".equals(headerKey)
                    || "user-agent".equals(headerKey)
                    || "origin".equals(headerKey)
                    || "content-type".equals(headerKey)
                    || "accept".equals(headerKey)
                    || "referer".equals(headerKey)
                    || "cookie".equals(headerKey)) {
                LOGGER.info("Header {} ==> [{}]", headerKey, req.getHeader(headerKey));
            }
        });
        Enumeration<String> parameterNames = req.getParameterNames();
        parameterNames.asIterator().forEachRemaining((paramKey) -> {

            for (String parameterValue : req.getParameterValues(paramKey)) {
                LOGGER.info("Parameter NAME : {} ==> [{}]", paramKey, parameterValue);
            }

        });
        System.out.println("========================================================================================================");

    }

}
