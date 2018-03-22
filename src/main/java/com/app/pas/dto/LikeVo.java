package com.app.pas.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Like")
@Data
public class LikeVo implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 6995026591187859255L;
private int likeCount;


 
 
}
