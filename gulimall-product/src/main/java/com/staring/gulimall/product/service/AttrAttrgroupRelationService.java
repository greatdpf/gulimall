package com.staring.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * å±žæ€§&å±žæ€§åˆ†ç»„å…³è”
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

