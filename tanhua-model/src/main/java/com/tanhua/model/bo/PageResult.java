package com.tanhua.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @program: social-demo
 * @description: 分页对象BO
 * @author: YzChen
 * @create: 2022-04-13 14:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {
    /**
     * 总记录数
     */
    private Integer counts = 0;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pages = 0;
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 列表
     */
    private List<?> items = Collections.emptyList();

    public PageResult(Integer page,Integer pageSize,
                      Long counts,List list) {
        this.page = page;
        this.pageSize = pageSize;
        this.items = list;
        this.counts = counts.intValue();
        this.pages = counts.intValue() % pageSize == 0 ? counts.intValue() / pageSize : counts.intValue() / pageSize + 1;
    }

}
