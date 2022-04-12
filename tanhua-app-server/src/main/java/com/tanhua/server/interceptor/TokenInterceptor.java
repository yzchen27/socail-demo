package com.tanhua.server.interceptor;

import cn.hutool.http.HttpStatus;
import com.tanhua.commons.utils.JwtUtils;
import com.tanhua.model.bo.UserInfoBO;
import com.tanhua.server.config.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: social-demo
 * @description: HttpRequest拦截器
 * @author: YzChen
 * @create: 2022-04-12 15:48
 **/
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        // 解析token信息
        UserInfoBO claims = null;
        try {
            claims = JwtUtils.getClaims(authorization);
        }catch (Exception e){
            log.error("拦截器异常:{}", e.getMessage());
            response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
            return false;
        }
        UserHolder.set(claims);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       UserHolder.remove();
    }
}
