package com.dexin.phenixflowerblooming.controller;


import com.dexin.phenixflowerblooming.entity.Donation;
import com.dexin.phenixflowerblooming.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
public class DonationController {

    @Autowired
    DonationService donationService;

    @PostMapping("/api/donate")
    @Transactional
    public String donate(@RequestBody @Validated Donation donation) {
        boolean result = donationService.donate(donation);
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
