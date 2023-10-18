package com.staring.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.coupon.entity.CategoryBoundsEntity;

import java.util.Map;

/**
 * 商品分类积分设置
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:20:12
 */
public interface CategoryBoundsService extends IService<CategoryBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

