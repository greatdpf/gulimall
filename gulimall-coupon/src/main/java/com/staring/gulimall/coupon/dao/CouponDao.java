package com.staring.gulimall.coupon.dao;

import com.staring.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:20:12
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
