package com.staring.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:20:12
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

