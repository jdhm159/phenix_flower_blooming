package com.dexin.phenixflowerblooming.service.impl;

import com.dexin.phenixflowerblooming.dto.PovertyParam;
import com.dexin.phenixflowerblooming.entity.Poverty;
import com.dexin.phenixflowerblooming.mapper.PovertyMapper;
import com.dexin.phenixflowerblooming.service.PovertyService;
import com.dexin.phenixflowerblooming.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PovertyServiceImpl implements PovertyService {

    @Autowired
    private PovertyMapper povertyMapper;

    @Override
    public PageBean<Poverty> getList(PovertyParam param) {
        return PageBean.of(povertyMapper.selectPage(param.page(), param.queryMapper()));
    }

    @Override
    public int create(Poverty poverty) {
        return povertyMapper.insert(poverty);
    }
}
