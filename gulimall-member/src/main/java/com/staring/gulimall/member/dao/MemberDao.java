package com.staring.gulimall.member.dao;

import com.staring.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:33:05
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
