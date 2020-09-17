package com.dexin.phenixflowerblooming.controller;

import cn.hutool.core.lang.Assert;
import com.dexin.phenixflowerblooming.constant.IdentityConst;
import com.dexin.phenixflowerblooming.entity.Donation;
import com.dexin.phenixflowerblooming.service.DonationService;
import com.dexin.phenixflowerblooming.util.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 2017101044 林浚颖
 * @since 2020-09-13
 */
@RestController
@Api(tags = "捐献记录/爱心公示管理")
public class DonationController {

    @Autowired
    DonationService donationService;

    @PostMapping("/api/donate")
    @ApiOperation("进行捐款")
    @Transactional
    @RequiresAuthentication
    public String donate(@RequestBody @Validated Donation donation) {
        Assert.isTrue(ShiroUtil.getProfile().getIsAdministrator() == IdentityConst.IS_ADMINISTATOR, "没有权限进行操作");
        boolean result = donationService.donate(donation);
        // 懒得封装Result了，接口不多
        if (result) {
            return "{" +
                "\"error_code\":" + 0 +
                ", \"status\":\"" + 1 + "\"" +
                '}';

        } else {
            return "{" +
                "\"error_code\":" + 0 +
                ", \"status\":\"" + 0 + "\"" +
                '}';
        }
    }
}
