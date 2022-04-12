package com.tanhua.server.config;

import com.tanhua.server.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: social-demo
 * @description: WebMvc配置类
 * @author: YzChen
 * @create: 2022-04-12 15:51
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(getWhiteList());
    }

    /**
     *  白名单
     * @return
     */
    private List<String> getWhiteList(){
        List<String> whiteList = new ArrayList<>();
        whiteList.add("/user/login");
        whiteList.add("/user/loginVerification");
        return whiteList;
    }
}
