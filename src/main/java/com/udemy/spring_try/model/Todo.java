package com.udemy.spring_try.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Todo {
	
	private String id;
	private String title;
	private String status;
	private String details;
	private String createdAt;
	private String updatedAt;
	
	@JsonIgnore
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	public Todo(String id, String title, String status, String details) {
		this.id = id;
		this.title = title;
		this.status = status;
		this.details = details;
		this.createdAt = dtformat.format(LocalDateTime.now());
		this.updatedAt = dtformat.format(LocalDateTime.now());
	}
    
}	

