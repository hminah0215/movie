package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {
	private String user_id;
	private String pwd;
	private String name;
	private int age;
	private String addr;
	private String email;
	private String role;
}
