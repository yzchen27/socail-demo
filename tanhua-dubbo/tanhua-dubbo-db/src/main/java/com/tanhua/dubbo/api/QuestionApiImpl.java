package com.tanhua.dubbo.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanhua.dubbo.mappers.QuestionMapper;
import com.tanhua.model.domain.Question;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @program: social-demo
 * @description: 问题设置实现类
 * @author: YzChen
 * @create: 2022-04-13 14:00
 **/
@DubboService
@Slf4j
public class QuestionApiImpl implements QuestionApi{

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void setStrangeContent(Long id, String content) {
        Question question = questionMapper.selectOne(new QueryWrapper<Question>().lambda().eq(Question::getUserId, id));
        if (Objects.isNull(question)){
            Question newQuestion = new Question();
            newQuestion.setUserId(id);
            newQuestion.setTxt(content);
            questionMapper.insert(newQuestion);
        }else {
            question.setTxt(content);
            questionMapper.updateById(question);
        }
    }
}
