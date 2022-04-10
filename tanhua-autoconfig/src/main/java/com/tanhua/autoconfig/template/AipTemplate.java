package com.tanhua.autoconfig.template;

import com.baidu.aip.face.AipFace;
import com.tanhua.autoconfig.properties.FaceDetectProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @program: social-demo
 * @description: 人脸识别
 * @author: YzChen
 * @create: 2022-04-10 14:58
 **/
@Data
@Slf4j
public class AipTemplate {

    private AipFace apiFace;

    public AipTemplate(AipFace apiFace){
        this.apiFace = apiFace;
    }

    /**
     *  百度人脸检测
     * @param imgUrl
     */
    public void detect(String imgUrl){
        /**
         *  说明文档 https://cloud.baidu.com/doc/FACE/s/8k37c1rqz
         */
        String imageType = "URL";
        HashMap<String, String> options = new HashMap<>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        JSONObject detectRes = apiFace.detect(imgUrl, imageType, options);

        log.info("人脸识别结果为:->{}", detectRes.toString());
    }

}
