package com.staring.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * å±žæ€§åˆ†ç»„
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

