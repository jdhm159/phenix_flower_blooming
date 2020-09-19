package com.dexin.phenixflowerblooming.service;

import com.dexin.phenixflowerblooming.dto.PovertyParam;
import com.dexin.phenixflowerblooming.entity.Poverty;
import com.dexin.phenixflowerblooming.util.PageBean;

public interface PovertyService {
    PageBean<Poverty> getList(PovertyParam param);

    int create(Poverty poverty);
}
