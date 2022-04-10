package com.tanhua.autoconfig.properties;

import com.baidu.aip.face.AipFace;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @program: social-demo
 * @description: 百度人脸监测api
 * @author: YzChen
 * @create: 2022-04-10 14:54
 **/

@Data
@ConfigurationProperties(prefix = "tanhua.aip")
public class FaceDetectProperties {

    private String appId;

    private String apiKey;

    private String  secretKey;


    @Bean
    public AipFace aipFace(){
        AipFace client = new AipFace(appId, apiKey, secretKey);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }

}
