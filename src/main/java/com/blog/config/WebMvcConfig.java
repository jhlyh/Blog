package com.blog.config;

import com.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/adminindex").addPathPatterns("/admin")
                .addPathPatterns("/admin/types").addPathPatterns("/admin/tag");
    }

    @Bean
    public HandlerInterceptor handlerInterceptor() {
        return new LoginInterceptor();
    }
}
