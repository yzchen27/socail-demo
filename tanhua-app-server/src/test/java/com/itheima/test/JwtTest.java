package com.itheima.test;

import com.tanhua.commons.utils.DateUtil;
import com.tanhua.commons.utils.JwtUtils;
import com.tanhua.model.bo.UserInfoBO;
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
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJtb2JpbGUiOiIxODEyMDg1ODY3MCIsImlkIjoiMTAwMCIsImV4cCI6MTY0OTgxNTU5N30.CpAvpISS3z-qv4Bt4EYgJVl74j9u_tfcA1CMGL7EJl1CwlyMAW_FkrVfjifOCVGRthCOK7saFrxK0X4LEWXMzA";
        UserInfoBO userInfoBO = JwtUtils.getClaims(token);
        System.out.println(userInfoBO);
    }
}
