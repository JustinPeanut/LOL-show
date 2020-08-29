package com.peanut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Peanut
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("get/home/page").setViewName("home-page");
        registry.addViewController("/to/login/page").setViewName("login-page");
        registry.addViewController("to/member/home/page").setViewName("member-home");
        registry.addViewController("to/update/member/info/page").setViewName("member-info-update");
        registry.addViewController("to/member/plan/page").setViewName("member-plan");
        registry.addViewController("to/pay/faild").setViewName("pay-failed");
    }
}
