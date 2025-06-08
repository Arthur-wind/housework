package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 电子签名
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("electronic_signature")
public class Electronic_SignatureEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Electronic_SignatureEntity() {
		
	}
	
	public Electronic_SignatureEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 项目名称
	 */
					
	private String project_name;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProject_Name(String project_name) {
		this.project_name = project_name;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProject_Name() {
		return project_name;
	}
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
