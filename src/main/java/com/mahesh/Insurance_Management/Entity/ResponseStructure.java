package com.mahesh.Insurance_Management.Entity;

import org.springframework.stereotype.Component;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
public class ResponseStructure<T> {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusCode;
	private String msg;
	private T data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	


}
