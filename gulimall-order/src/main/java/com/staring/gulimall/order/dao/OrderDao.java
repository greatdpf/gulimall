package com.staring.gulimall.order.dao;

import com.staring.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:45:09
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
