package com.staring.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * skué”€å”®å±žæ€§&å€¼
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

