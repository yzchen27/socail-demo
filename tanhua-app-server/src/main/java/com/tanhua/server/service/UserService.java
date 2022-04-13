package com.tanhua.server.service;

import com.tanhua.autoconfig.template.SmsTemplate;
import com.tanhua.commons.utils.JwtUtils;
import com.tanhua.dubbo.api.UserApi;
import com.tanhua.dubbo.api.UserInfoApi;
import com.tanhua.dubbo.api.UserSettingsApi;
import com.tanhua.model.bo.UserInfoBO;
import com.tanhua.model.domain.User;
import com.tanhua.model.domain.UserInfo;
import com.tanhua.model.vo.GeneralSettingsVO;
import com.tanhua.model.vo.UserInfoVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private SmsTemplate template;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @DubboReference(version = "1.0.0")
    private UserApi userApi;

    @DubboReference
    private UserInfoApi userInfoApi;

    @DubboReference
    private UserSettingsApi userSettingsApi;


    /**
     * 发送短信验证码
     *
     * @param phone
     */
    public void sendMsg(String phone) {
        //1、随机生成6位数字  RandomStringUtils.randomNumeric(6);
        String code = "123456";
        //2、调用template对象，发送手机短信 TODO 暂时放开验证码
//        template.sendSms(phone, code);
        //3、将验证码存入到redis
        redisTemplate.opsForValue().set("CHECK_CODE_" + phone, code, Duration.ofMinutes(5));
    }


    /**
     * 验证登录
     *
     * @param phone
     * @param code
     */
    public Map loginVerification(String phone, String code) {
        //1、从redis中获取下发的验证码
        String redisCode = redisTemplate.opsForValue().get("CHECK_CODE_" + phone);
        //2、对验证码进行校验（验证码是否存在，是否和输入的验证码一致）
        if(StringUtils.isEmpty(redisCode) || !redisCode.equals(code)) {
            //验证码无效
            throw new RuntimeException("验证码错误");
        }
        //3、删除redis中的验证码
        redisTemplate.delete("CHECK_CODE_" + phone);
        //4、通过手机号码查询用户
        User user = userApi.findByMobile(phone);
        boolean isNew = false;
        //5、如果用户不存在，创建用户保存到数据库中
        if (user == null) {
            user = new User();
            user.setMobile(phone);
            user.setPassword(DigestUtils.md5Hex("123456"));
            Long userId = userApi.save(user);
            user.setId(userId);
            isNew = true;
        }
        //6、通过JWT生成token(存入id和手机号码)
        Map tokenMap = new HashMap();
        tokenMap.put("id", user.getId());
        tokenMap.put("mobile", phone);
        String token = JwtUtils.getToken(tokenMap);
        //7、构造返回值
        Map retMap = new HashMap();
        retMap.put("token", token);
        retMap.put("isNew", isNew);

        return retMap;
    }

    public User getUserByMobile(String mobile) {
        return userApi.findByMobile(mobile);
    }

    /**
     *  初始化信息
     * @param userInfoVO
     * @param userInfoBO
     */
    public void loginRegInfo(UserInfoVO userInfoVO, UserInfoBO userInfoBO) {
        userInfoApi.save(userInfoVO, userInfoBO);
    }

    /**
     *  根据id查询用户信息
     * @param userInfoBO
     * @param userID
     * @return
     */
    public UserInfoVO findUserInfoById(UserInfoBO userInfoBO, Long userID) {
        if (!Objects.isNull(userID)){
            return userInfoApi.findUserInfoById(userID);
        }
        return userInfoApi.findUserInfoById(userInfoBO.getId());
    }

    /**
     *  更新用户信息
     * @param userInfo
     */
    public void updateUserInfo(UserInfo userInfo) {
        userInfoApi.updateUserInfo(userInfo);
    }

    /**
     *  根据用户查询通用设置信息
     * @param id
     * @return
     */
    public GeneralSettingsVO findUserGeneralSettingsByUserId(Long id){
        return userSettingsApi.findUserGeneralSettingsByUserId(id);
    }
}
