package me.ktpark.websvc.config.spring;

import me.ktpark.websvc.interceptors.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.*;

import java.awt.image.RGBImageFilter;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;

    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("configureDefaultServletHandling");
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .excludePathPatterns("/resources/**")
                .excludePathPatterns("/webjars/**")
        ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
        ;
    }



}
