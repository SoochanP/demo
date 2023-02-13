package com.test.demo.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String id;
	private String regdate;
	private int readcnt;
	private String etc;
	private int del;

	
}
