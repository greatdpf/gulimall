package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * skuä¿¡æ¯
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
@Data
@TableName("pms_sku_info")
public class SkuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * skuId
	 */
	@TableId
	private Long skuId;
	/**
	 * spuId
	 */
	private Long spuId;
	/**
	 * skuåç§°
	 */
	private String skuName;
	/**
	 * skuä»‹ç»æè¿°
	 */
	private String skuDesc;
	/**
	 * æ‰€å±žåˆ†ç±»id
	 */
	private Long catalogId;
	/**
	 * å“ç‰Œid
	 */
	private Long brandId;
	/**
	 * é»˜è®¤å›¾ç‰‡
	 */
	private String skuDefaultImg;
	/**
	 * æ ‡é¢˜
	 */
	private String skuTitle;
	/**
	 * å‰¯æ ‡é¢˜
	 */
	private String skuSubtitle;
	/**
	 * ä»·æ ¼
	 */
	private BigDecimal price;
	/**
	 * é”€é‡
	 */
	private Long saleCount;

}
