package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spuä¿¡æ¯
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:57
 */
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * å•†å“id
	 */
	@TableId
	private Long id;
	/**
	 * å•†å“åç§°
	 */
	private String spuName;
	/**
	 * å•†å“æè¿°
	 */
	private String spuDescription;
	/**
	 * æ‰€å±žåˆ†ç±»id
	 */
	private Long catalogId;
	/**
	 * å“ç‰Œid
	 */
	private Long brandId;
	/**
	 * 
	 */
	private BigDecimal weight;
	/**
	 * ä¸Šæž¶çŠ¶æ€[0 - ä¸‹æž¶ï¼Œ1 - ä¸Šæž¶]
	 */
	private Integer publishStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
