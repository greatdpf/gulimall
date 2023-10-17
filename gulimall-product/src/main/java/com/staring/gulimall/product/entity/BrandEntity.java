package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * å“ç‰Œ
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * å“ç‰Œid
	 */
	@TableId
	private Long brandId;
	/**
	 * å“ç‰Œå
	 */
	private String name;
	/**
	 * å“ç‰Œlogoåœ°å€
	 */
	private String logo;
	/**
	 * ä»‹ç»
	 */
	private String descript;
	/**
	 * æ˜¾ç¤ºçŠ¶æ€[0-ä¸æ˜¾ç¤ºï¼›1-æ˜¾ç¤º]
	 */
	private Integer showStatus;
	/**
	 * æ£€ç´¢é¦–å­—æ¯
	 */
	private String firstLetter;
	/**
	 * æŽ’åº
	 */
	private Integer sort;

}
