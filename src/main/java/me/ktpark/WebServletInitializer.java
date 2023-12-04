package me.ktpark;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author KTPARK
 * @apiNote 애플리케이션 War 패키징 (톰캣 등 서블릿 엔진에 배포 시 SpringBootServletInitializer 사용됨)
 */
public class WebServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(Application.class);
    }

}
