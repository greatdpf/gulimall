package com.staring.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spuä¿¡æ¯
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:57
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

