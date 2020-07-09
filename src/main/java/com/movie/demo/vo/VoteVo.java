package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteVo {
	private int v_no;
	private String v_item;
	private int vt_no;
	private String user_id;
}
