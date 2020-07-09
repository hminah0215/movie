package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WishListVo {
	private int w_no;
	private String w_date;
	private String user_id;
	private int m_no;
}
