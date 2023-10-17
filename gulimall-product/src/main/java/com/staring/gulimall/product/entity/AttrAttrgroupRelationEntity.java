package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * å±žæ€§&å±žæ€§åˆ†ç»„å…³è”
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
@Data
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * å±žæ€§id
	 */
	private Long attrId;
	/**
	 * å±žæ€§åˆ†ç»„id
	 */
	private Long attrGroupId;
	/**
	 * å±žæ€§ç»„å†…æŽ’åº
	 */
	private Integer attrSort;

}
