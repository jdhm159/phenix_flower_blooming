package com.dexin.phenixflowerblooming.controller;

import com.dexin.phenixflowerblooming.dto.PovertyParam;
import com.dexin.phenixflowerblooming.entity.Poverty;
import com.dexin.phenixflowerblooming.service.PovertyService;
import com.dexin.phenixflowerblooming.util.PageBean;
import com.dexin.phenixflowerblooming.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/poorHouseholds")
public class PovertyController {

    @Autowired
    private PovertyService povertyService;

    @GetMapping
    public Result<PageBean<Poverty>> getList(@ModelAttribute PovertyParam param) {
        return Result.success(povertyService.getList(param));
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody Poverty poverty) {
        return Result.success("ok");
    }

}
