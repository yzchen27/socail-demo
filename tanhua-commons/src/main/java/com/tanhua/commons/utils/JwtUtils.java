package com.tanhua.commons.utils;

import com.tanhua.model.bo.UserInfoBO;
import io.jsonwebtoken.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // TOKEN的有效期1小时（S）
    private static final int TOKEN_TIME_OUT = 3_600;

    // 加密KEY
    private static final String TOKEN_SECRET = "cyz";


    // 生成Token
    public static String getToken(Map params){
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET) //加密方式
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000)) //过期时间戳
                .addClaims(params)
                .compact();
    }


    /**
     * 获取Token中的claims信息
     */
    public static UserInfoBO getClaims(String token) {
        Claims body = null;
        try {
            body = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException |SignatureException e){
            throw new SignatureException("token 异常:" + e.getMessage());
        }
        return new UserInfoBO(Long.parseLong((String) body.get("id")), body.get("mobile").toString(), body.getExpiration());
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
