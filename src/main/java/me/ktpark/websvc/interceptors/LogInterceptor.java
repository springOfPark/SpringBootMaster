package me.ktpark.websvc.interceptors;

import me.ktpark.websvc.utils.RequestUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LogInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @Autowired
    RequestUtility requestUtility;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestUtility.printRequestLog(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        requestUtility.printResponseLog(response);
        requestUtility.printModelAndView(modelAndView);
        System.out.println(modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(ex);

    }
}
