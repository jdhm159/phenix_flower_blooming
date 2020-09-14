package com.dexin.phenixflowerblooming.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dexin.phenixflowerblooming.entity.Donation;
import com.dexin.phenixflowerblooming.mapper.DonationMapper;
import com.dexin.phenixflowerblooming.service.DonationService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 2017101044 林浚颖
 * @since 2020-09-13
 */
@Service
public class DonationServiceImpl extends ServiceImpl<DonationMapper, Donation> implements DonationService {

    @Override
    public boolean donate(Donation donation) {
        donation.setGmtCreate(LocalDateTime.now());
        donation.setAdminId(0);
        return save(donation);
    }
}
