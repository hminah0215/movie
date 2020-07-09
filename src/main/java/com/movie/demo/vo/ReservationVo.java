package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationVo {
	private int rs_no;
	private String rs_time;
	private String screenning_start;
	private int branch_no;
	private int screen_no;
	private int seats_choose;
	private String seats_no;
	private String user_id;
	private int m_no;
}
