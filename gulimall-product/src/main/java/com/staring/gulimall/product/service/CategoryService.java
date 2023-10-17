package com.staring.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.product.entity.CategoryEntity;

import java.util.Map;

/**
 * å•†å“ä¸‰çº§åˆ†ç±»
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

