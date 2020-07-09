package com.movie.demo.vo;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vote_TopicVo {
	private int vt_no;
	private String vt_topic;
	private String vt_item1;
	private String vt_item2;
}
