package com.dexin.phenixflowerblooming.service.impl;

import com.dexin.phenixflowerblooming.dto.PovertyParam;
import com.dexin.phenixflowerblooming.entity.Poverty;
import com.dexin.phenixflowerblooming.mapper.PovertyMapper;
import com.dexin.phenixflowerblooming.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PovertyServiceImpl {

    @Autowired
    private PovertyMapper povertyMapper;

    public Result<List<Poverty>> getList(PovertyParam param) {
        return povertyMapper.selectByExample(param.fetchExample());
    }
}
