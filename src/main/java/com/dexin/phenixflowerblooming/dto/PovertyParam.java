package com.dexin.phenixflowerblooming.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dexin.phenixflowerblooming.entity.Poverty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


import java.util.Optional;

@Data
public class PovertyParam {
    private String town;
    private Integer status;
    private String name;
    private Integer pageNum = 0;
    private Integer pageSize = 10;

    public QueryWrapper<Poverty> queryMapper() {

        QueryWrapper<Poverty> query = new QueryWrapper<>();

        if (StringUtils.isNotEmpty(name))
            query.like("name", name);

        if (StringUtils.isNotEmpty(town))
            query.like("town", town);

        Optional.ofNullable(status).ifPresent(s -> query.eq("status", s));

        return query;
    }

    public IPage<Poverty> page() {
        return new Page<>(pageNum, pageSize);
    }

}
