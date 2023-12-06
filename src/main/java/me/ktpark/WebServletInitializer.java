package me.ktpark;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author KTPARK
 * @apiNote 애플리케이션 War 패키징 (톰캣 등 서블릿 엔진에 배포 시 SpringBootServletInitializer 사용됨)
 * 스프링 부트 프로젝트 생성 시 WAR 패키징 선택하면 아래와 같은 소스는 자동으로 생성된다.
 */
public class WebServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(Application.class);
    }

}
