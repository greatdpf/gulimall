package com.staring.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.staring.gulimall.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staring.gulimall.member.entity.MemberEntity;
import com.staring.gulimall.member.service.MemberService;
import com.staring.common.utils.PageUtils;
import com.staring.common.utils.R;

import javax.annotation.Resource;


/**
 * 会员
 *
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 22:33:05
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Resource
    CouponFeignService couponFeignService;

    @RequestMapping("/coupon")
    public R test() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("dpf");
        R r = couponFeignService.menmberCoupon();
        Object coupon = r.get("coupon");
        return R.ok().put("member", memberEntity).put("coupons", coupon);

    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
