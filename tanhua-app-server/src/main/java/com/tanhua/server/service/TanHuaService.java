package com.tanhua.server.service;

import com.tanhua.dubbo.api.RecommendUserApi;
import com.tanhua.dubbo.api.UserInfoApi;
import com.tanhua.model.bo.PageResult;
import com.tanhua.model.domain.UserInfo;
import com.tanhua.model.dto.RecommendUserDTO;
import com.tanhua.model.mongo.RecommendUser;
import com.tanhua.model.vo.RecommendUserVO;
import com.tanhua.model.vo.TodayBest;
import com.tanhua.server.config.UserHolder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: social-demo
 * @description:
 * @author: YzChen
 * @create: 2022-04-14 10:19
 **/
@Service
public class TanHuaService {

    @DubboReference
    private RecommendUserApi recommendUserApi;

    @DubboReference
    private UserInfoApi userInfoApi;

    public TodayBest todayBest(){
        Long id = UserHolder.getId();
        UserInfo userInfo = userInfoApi.findUserInfoByUserId(id);
        RecommendUser recommendUser = recommendUserApi.queryWithMaxScore(id);
        return TodayBest.init(userInfo, recommendUser);
    }

    public PageResult recommendation(RecommendUserDTO recommendUserDTO) {
        Long id = UserHolder.getId();
        List<RecommendUser> recommendUsers = recommendUserApi.queryRecommendUserList(id, recommendUserDTO);
        PageResult pageResult = new PageResult();
        if ( recommendUsers.size() > 0){
            List<Long> collect = recommendUsers.stream().map(RecommendUser::getUserId).collect(Collectors.toList());
            Map<Long, RecommendUser> recommendUserMap = recommendUsers.stream().collect(Collectors.toMap(RecommendUser::getUserId, Function.identity()));
            // 获取推荐列表, TODO 筛选过滤条件 分页功能完善
            List<UserInfo> userInfos = userInfoApi.batchSelectByUserIdList(collect);
            List<RecommendUserVO> res = userInfos.stream().map(ui -> {
                RecommendUserVO recommendUserVO = new RecommendUserVO();
                recommendUserVO.setAge(ui.getAge())
                        .setAvatar(ui.getAvatar())
                        .setFateValue(recommendUserMap.get(ui.getId()).getScore().intValue())
                        .setId(ui.getId())
                        .setTag(ui.getTags().split(","))
                        .setGender(ui.getGender());
                return recommendUserVO;
            }).sorted((p1, p2) -> p2.getFateValue() - p1.getFateValue()).collect(Collectors.toList());
            pageResult.setPage(recommendUserDTO.getPage());
            pageResult.setPageSize(recommendUserDTO.getPagesize());
            pageResult.setItems(res);
        }

        return pageResult;
    }
}
