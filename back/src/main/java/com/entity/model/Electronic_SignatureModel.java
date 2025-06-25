package com.entity.model;

import com.entity.Electronic_SignatureEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 电子签名
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public class Electronic_SignatureModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 内容
	 */
	
	private String content;
		
	/**
	 * 电子签名
	 */
	
	private String electronic_signature;
		
	/**
	 * 签订日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date sign_date;
		
	/**
	 * 有效期
	 */
	
	private String validity_period;
		
	/**
	 * 账号
	 */
	
	private String employer_account;
		
	/**
	 * 姓名
	 */
	
	private String employer_name;
		
	/**
	 * 手机
	 */
	
	private String phone;
		
	/**
	 * 雇员账号
	 */
	
	private String employee_account;
		
	/**
	 * 雇员姓名
	 */
	
	private String employee_name;
		
	/**
	 * 联系电话
	 */
	
	private String contact_phone;
				
	
	/**
	 * 设置：内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：电子签名
	 */
	 
	public void setElectronic_Signature(String electronic_signature) {
		this.electronic_signature = electronic_signature;
	}
	
	/**
	 * 获取：电子签名
	 */
	public String getElectronic_Signature() {
		return electronic_signature;
	}
				
	
	/**
	 * 设置：签订日期
	 */
	 
	public void setSign_Date(Date sign_date) {
		this.sign_date = sign_date;
	}
	
	/**
	 * 获取：签订日期
	 */
	public Date getSign_Date() {
		return sign_date;
	}
				
	
	/**
	 * 设置：有效期
	 */
	 
	public void setValidity_Period(String validity_period) {
		this.validity_period = validity_period;
	}
	
	/**
	 * 获取：有效期
	 */
	public String getValidity_Period() {
		return validity_period;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setEmployer_Account(String employer_account) {
		this.employer_account = employer_account;
	}
	
	/**
	 * 获取：账号
	 */
	public String getEmployer_Account() {
		return employer_account;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setEmployer_Name(String employer_name) {
		this.employer_name = employer_name;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getEmployer_Name() {
		return employer_name;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 获取：手机
	 */
	public String getPhone() {
		return phone;
	}
				
	
	/**
	 * 设置：雇员账号
	 */
	 
	public void setEmployee_Account(String employee_account) {
		this.employee_account = employee_account;
	}
	
	/**
	 * 获取：雇员账号
	 */
	public String getEmployee_Account() {
		return employee_account;
	}
				
	
	/**
	 * 设置：雇员姓名
	 */
	 
	public void setEmployee_Name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	/**
	 * 获取：雇员姓名
	 */
	public String getEmployee_Name() {
		return employee_name;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setContact_Phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getContact_Phone() {
		return contact_phone;
	}
			
}
