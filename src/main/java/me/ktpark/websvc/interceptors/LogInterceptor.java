package me.ktpark.websvc.interceptors;

import me.ktpark.websvc.utils.RequestUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @Autowired
    private RequestUtility requestUtility;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("인터셉터 preHandle 이벤트가 발생하였습니다.");
        requestUtility.printRequestLog(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("인터셉터 postHandle 이벤트가 발생하였습니다.");
        requestUtility.printResponseLog(response);
        requestUtility.printModelAndView(modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("인터셉터 afterCompletion 이벤트가 발생하였습니다. Exception : {}", ex);
    }
}
