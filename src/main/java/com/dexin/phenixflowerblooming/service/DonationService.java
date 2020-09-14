package com.dexin.phenixflowerblooming.service;

import com.dexin.phenixflowerblooming.entity.Donation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 2017101044 林浚颖
 * @since 2020-09-13
 */
public interface DonationService extends IService<Donation> {
    boolean donate(Donation donation);
}
