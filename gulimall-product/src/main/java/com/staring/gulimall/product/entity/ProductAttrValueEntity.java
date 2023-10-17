package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spuå±žæ€§å€¼
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * å•†å“id
	 */
	private Long spuId;
	/**
	 * å±žæ€§id
	 */
	private Long attrId;
	/**
	 * å±žæ€§å
	 */
	private String attrName;
	/**
	 * å±žæ€§å€¼
	 */
	private String attrValue;
	/**
	 * é¡ºåº
	 */
	private Integer attrSort;
	/**
	 * å¿«é€Ÿå±•ç¤ºã€æ˜¯å¦å±•ç¤ºåœ¨ä»‹ç»ä¸Šï¼›0-å¦ 1-æ˜¯ã€‘
	 */
	private Integer quickShow;

}
