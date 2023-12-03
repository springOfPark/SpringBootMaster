package me.ktpark.websvc.filters;

import me.ktpark.websvc.base.extension.ServiceManager;
import me.ktpark.websvc.utils.RequestUtility;
import me.ktpark.websvc.utils.SessionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {

    static final Logger log = LoggerFactory.getLogger(CustomFilter.class);

    @Autowired
    private RequestUtility requestUtility;

    @Autowired
    private ServiceManager serviceManager;

    @Autowired
    private SessionUtility sessionUtility;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("커스텀 필터 : init 이벤트가 발생하였습니다.");
        // filterConfig.getInitParameterNames().asIterator().forEachRemaining(System.out::println);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("커스텀 필터 : doFilter 이벤트가 발생하였습니다.");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // HttpSession session = httpServletRequest.getSession();
        // sessionUtility.printSessionInfo(session);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("커스텀 필터 : DESTROY 이벤트가 발생하였습니다.");
    }
}
