package com.itheima.test;

import com.tanhua.autoconfig.template.AipTemplate;
import com.tanhua.server.AppServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: social-demo
 * @description: 人脸检测测试类
 * @author: YzChen
 * @create: 2022-04-10 15:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
public class AipTest {

    @Autowired
    private AipTemplate aipTemplate;

    @Test
    public void aipTest(){
        String testUrl = "https://tanhua001.oss-cn-beijing.aliyuncs.com/2021/04/19/a3824a45-70e3-4655-8106-a1e1be009a5e.jpg";
        aipTemplate.detect(testUrl);

    }
}
