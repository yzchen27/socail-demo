package com.tanhua.dubbo.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tanhua.dubbo.mappers.BlackListMapper;
import com.tanhua.model.bo.PageResult;
import com.tanhua.model.domain.BlackList;
import com.tanhua.model.vo.BlackListVO;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: social-demo
 * @description:
 * @author: YzChen
 * @create: 2022-04-13 14:51
 **/
@DubboService
public class BlackListApiImpl implements BlackListApi {

    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public PageResult findBlackListByUserId(Long userId, int page, int size) {
        Page<BlackListVO> bl = new Page<>(page, size);
        IPage<BlackListVO> res = blackListMapper.pageBlackListByUserId(bl, userId);
        return new PageResult(page, size, res.getTotal(), res.getRecords());
    }

    @Override
    public void deleteByUserId(Long uid, Long id) {
        blackListMapper.delete(new QueryWrapper<BlackList>().lambda()
                .eq(BlackList::getBlackUserId, uid)
                .eq(BlackList::getUserId, id));
    }
}
