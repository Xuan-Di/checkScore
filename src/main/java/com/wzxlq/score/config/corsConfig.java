package com.wzxlq.score.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 王照轩
 * 解决跨域问题
 * @date 2020/3/3 - 23:00
 */

@Configuration
public class corsConfig extends WebMvcConfigurerAdapter {
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS)
                .maxAge(3600);
    }
}

