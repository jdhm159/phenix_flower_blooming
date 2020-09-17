package com.dexin.phenixflowerblooming.dto;

import com.dexin.phenixflowerblooming.entity.Poverty;
import lombok.Data;
import tk.mybatis.mapper.entity.Example;

import java.util.Optional;

@Data
public class PovertyParam {
    private String town;
    private Integer status;
    private String name;

    public Example fetchExample() {
        Example example = new Example(Poverty.class);
        Example.Criteria criteria = example.createCriteria();

        Optional.ofNullable(town).ifPresent(t -> criteria.andLike("town", "%" + t + "%"));
        Optional.ofNullable(status).ifPresent(s -> criteria.andEqualTo("status", s));
        Optional.ofNullable(name).ifPresent(n -> criteria.andLike("name", "%" + n + "%"));

        return example;
    }

}
