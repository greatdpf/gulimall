package com.staring.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staring.common.utils.PageUtils;
import com.staring.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:33:05
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

