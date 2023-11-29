package me.ktpark.websvc.base.controller.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class BaseControllerTemplate {

    private final Logger LOGGER = LoggerFactory.getLogger(BaseControllerTemplate.class);

    protected void printRequestInfo(HttpServletRequest req) {

        System.out.println("========================================================================================================");
        req.getHeaderNames().asIterator().forEachRemaining((header) -> LOGGER.info("Header {} ==> [{}]", header, req.getHeader(header)));

        Enumeration<String> parameterNames = req.getParameterNames();
        parameterNames.asIterator().forEachRemaining((paramKey) -> {

            for (String parameterValue : req.getParameterValues(paramKey)) {
                LOGGER.info("Parameter Value {} ==> [{}]", paramKey, parameterValue);
            }

        });
        System.out.println("========================================================================================================");

    }

}
