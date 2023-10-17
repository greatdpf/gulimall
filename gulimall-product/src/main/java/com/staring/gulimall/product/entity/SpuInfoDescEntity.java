package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spuä¿¡æ¯ä»‹ç»
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:57
 */
@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * å•†å“id
	 */
	@TableId
	private Long spuId;
	/**
	 * å•†å“ä»‹ç»
	 */
	private String decript;

}
