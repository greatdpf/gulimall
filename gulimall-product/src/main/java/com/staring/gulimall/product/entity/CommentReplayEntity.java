package com.staring.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * å•†å“è¯„ä»·å›žå¤å…³ç³»
 * 
 * @author staring
 * @email staring@gmail.com
 * @date 2023-10-18 00:15:58
 */
@Data
@TableName("pms_comment_replay")
public class CommentReplayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * è¯„è®ºid
	 */
	private Long commentId;
	/**
	 * å›žå¤id
	 */
	private Long replyId;

}
