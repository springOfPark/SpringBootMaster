package me.ktpark.websvc.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ktpark.websvc.utils.RequestUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @Autowired
    private RequestUtility requestUtility;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("인터셉터 preHandle 이벤트가 발생하였습니다.");

        System.out.println(objectMapper);

        requestUtility.printRequestLog(request);

        // String paramValue = request.getParameter("paramValue");
        // System.out.println("Request Parameter ==> paramValue : " + paramValue);

        // ServletInputStream inputStream = request.getInputStream();
        // System.out.println(inputStream);

        // String bodyJson = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // System.out.println(bodyJson);

        /* JSON 으로 넘어오는 경우를 대비해서 INPUT STREAM을 사용했으나 필터 또는 인터셉터에서 사용하면 컨트롤러에서 읽어 올 수 없어서 에러가 발생한다.
        if (inputStream != null) {
            byte[] bytes = inputStream.readAllBytes();
            if (bytes.length > 0) {
                Map<String, Object> hashMap = objectMapper.readValue(bytes, HashMap.class);
                System.out.println(hashMap);
            }
        }
         */

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
