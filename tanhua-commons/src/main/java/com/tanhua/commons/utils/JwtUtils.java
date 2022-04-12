package com.tanhua.commons.utils;

import cn.hutool.http.server.HttpServerRequest;
import com.tanhua.model.bo.UserInfoBO;
import com.tanhua.model.exception.BizException;
import com.tanhua.model.vo.ErrorResult;
import io.jsonwebtoken.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // TOKEN的有效期30天
    private static final int TOKEN_TIME_OUT = 3_600 * 24 * 30;

    // 加密KEY
    private static final String TOKEN_SECRET = "cyz";


    // 生成Token
    public static String getToken(Map params){
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET.getBytes(StandardCharsets.UTF_8)) //加密方式
                .setExpiration(DateUtil.getExpire()) //过期时间戳
                .addClaims(params)
                .compact();
    }


    /**
     * 获取Token中的claims信息
     */
    public static UserInfoBO getClaims(String token) {
        Claims body =Jwts.parser()
                .setSigningKey(TOKEN_SECRET.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token).getBody();
        Integer id = (Integer) body.get("id");
        return new UserInfoBO(id.longValue(), body.get("mobile").toString(), body.getExpiration());
    }


    /**
     * 是否有效 true-有效，false-失效
     */
    public static boolean verifyToken(String token) {

        if(StringUtils.isEmpty(token)) {
            return false;
        }

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            return false;
        }

		return true;
    }

}
