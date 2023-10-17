package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * skuå›¾ç‰‡
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * å›¾ç‰‡åœ°å€
	 */
	private String imgUrl;
	/**
	 * æŽ’åº
	 */
	private Integer imgSort;
	/**
	 * é»˜è®¤å›¾[0 - ä¸æ˜¯é»˜è®¤å›¾ï¼Œ1 - æ˜¯é»˜è®¤å›¾]
	 */
	private Integer defaultImg;

}
