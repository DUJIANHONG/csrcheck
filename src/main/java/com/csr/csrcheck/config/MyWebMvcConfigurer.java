package com.csr.csrcheck.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/12/5 9:58
 * @version:
 * @modified By:
 */
public class MyWebMvcConfigurer {

    /**
     * 资源映射路径
     */
    @Configuration
    public class MyWebAppConfigurer implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:D:/temp-rainy/");
        }
    }
}
