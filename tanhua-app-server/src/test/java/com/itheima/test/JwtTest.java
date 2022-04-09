package com.itheima.test;

import com.tanhua.commons.utils.DateUtil;
import io.jsonwebtoken.*;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testCreateToken() {
        //1.生成token
        Map<String, Object> info = new HashMap<>();
        info.put("id", "1000");
        info.put("mobile", "18120858670");
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, "cyz".getBytes(StandardCharsets.UTF_8)) // 指定算法、jwt的secret
                .setClaims(info)
                .setExpiration(DateUtil.getExpire())
                .compact();
        System.out.println(token);
    }

    //解析token

    /**
     * SignatureException : token不合法
     * ExpiredJwtException：token已过期
     */
    @Test
    public void testParseToken() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJtb2JpbGUiOiIxODEyMDg1ODY3MCIsImlkIjoiMTAwMCIsImV4cCI6MTY0OTU5Mzk4OX0.NymbP6_3fyFF3tOWzEDKCZ4Cn1uESomLKIvMR5mV4U-TzdwTDaEnViL46mjXcDQFgYVaFM_Q06hMzf54fNI4Bw";
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("cyz".getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
            Object id = claims.get("id");
            Object mobile = claims.get("mobile");
            System.out.println(id + "--" + mobile);
        }catch (ExpiredJwtException e) {
            System.out.println("token已过期");
        }catch (SignatureException e) {
            System.out.println("token不合法");
        }

    }
}
