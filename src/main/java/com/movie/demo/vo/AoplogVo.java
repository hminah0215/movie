package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AoplogVo {
	private int log_no;
	private String log_url;
	private String log_ip;
	private String log_time;
	private String user_id;
}
