package com.test.demo.Domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Columns:
//reno int AI PK 
//rewriter varchar(45) 
//rememo varchar(45) 
//redate date 
//bno int 
//del int

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {

	private int reno;
	private String id;
	private String rememo;
	private Date redate;
	private int bno;
	private int del;
}
