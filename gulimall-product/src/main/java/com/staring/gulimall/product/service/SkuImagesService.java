package com.staring.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * skuå›¾ç‰‡
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

