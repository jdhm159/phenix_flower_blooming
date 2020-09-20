package com.dexin.phenixflowerblooming.controller;


import cn.hutool.core.lang.Assert;
import com.dexin.phenixflowerblooming.constant.IdentityConst;
import com.dexin.phenixflowerblooming.entity.Donation;
import com.dexin.phenixflowerblooming.service.DonationService;
import com.dexin.phenixflowerblooming.util.Result;
import com.dexin.phenixflowerblooming.util.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(tags = "捐款管理")
@RequestMapping("/api")
public class DonationsController {

    @Autowired
    DonationService donationService;

    @RequiresAuthentication
    @ApiOperation("进行捐款")
    @PostMapping("/donate")
    public Result donate(@RequestBody @Validated Donation donation) {
        Assert.isTrue(ShiroUtil.getProfile().getIsAdministrator() == IdentityConst.IS_ADMINISTATOR, "没有权限进行操作");
        return Result.success(donationService.donate(donation)) ;

    }
}
