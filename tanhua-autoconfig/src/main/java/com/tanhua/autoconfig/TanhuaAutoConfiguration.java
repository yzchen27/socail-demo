package com.tanhua.autoconfig;


import com.baidu.aip.face.AipFace;
import com.tanhua.autoconfig.properties.FaceDetectProperties;
import com.tanhua.autoconfig.properties.SmsProperties;
import com.tanhua.autoconfig.template.AipTemplate;
import com.tanhua.autoconfig.template.SmsTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties({
        SmsProperties.class,
        FaceDetectProperties.class
})
public class TanhuaAutoConfiguration {

    @Bean
    public SmsTemplate smsTemplate(SmsProperties properties) {
        return new SmsTemplate(properties);
    }

    @Bean
    public AipTemplate aipTemplate(AipFace aipFace){
        return new AipTemplate(aipFace);
    }

}
