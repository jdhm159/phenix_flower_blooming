package com.dexin.phenixflowerblooming.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;


@Data
@AllArgsConstructor
public class PageBean<T> {
    private Long pageNum;
    private Long pageSize;
    private Long total;
    private Collection<T> data;

    public static <R> PageBean<R> of(IPage<R> page) {
        return new PageBean<R>(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords());
    }
}
