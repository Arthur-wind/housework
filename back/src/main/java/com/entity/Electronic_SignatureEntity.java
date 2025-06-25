package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * @date 2025-6-13 19:23:55
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
    @TableField("project_name")
    @JsonProperty("project_name")
	private String projectName;
	
	/**
	 * 内容
	 */
					
	private String content;
	
	/**
	 * 电子签名
	 */

	@TableField("electronic_signature")
	private String electronicSignature;
	
	/**
	 * 签订日期
	 */

	@TableField("sign_date")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
	@JsonProperty("sign_date")
	private Date signDate;
	
	/**
	 * 有效期
	 */

	@TableField("validity_period")
	private String validityPeriod;
	
	/**
	 * 账号
	 */

	@TableField("employer_account")
	@JsonProperty("employer_account")
	private String employerAccount;
	
	/**
	 * 姓名
	 */
    @TableField("employer_name")
    @JsonProperty("employer_name")
	private String employerName;
	
	/**
	 * 手机
	 */
					
	private String phone;
	
	/**
	 * 雇员账号
	 */

	@TableField("employee_account")
	@JsonProperty("employee_account")
	private String employeeAccount;
	
	/**
	 * 雇员姓名
	 */

	@TableField("employee_name")
	@JsonProperty("employee_name")
	private String employeeName;
	
	/**
	 * 联系电话
	 */

	@TableField("contact_phone")
	private String contactPhone;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
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
	public void setElectronic_signature(String electronic_signature) {
		this.electronicSignature = electronic_signature;
	}
	/**
	 * 获取：电子签名
	 */
	public String getElectronic_signature() {
		return electronicSignature;
	}
	/**
	 * 设置：签订日期
	 */
	public void setSignDate(Date sign_date) {
		this.signDate = sign_date;
	}
	/**
	 * 获取：签订日期
	 */
	public Date getSignDate() {
		return signDate;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidity_period(String validity_period) {
		this.validityPeriod = validity_period;
	}
	/**
	 * 获取：有效期
	 */
	public String getValidity_period() {
		return validityPeriod;
	}
	/**
	 * 设置：账号
	 */
	public void setEmployer_account(String employer_account) {
		this.employerAccount = employer_account;
	}
	/**
	 * 获取：账号
	 */
	public String getEmployer_account() {
		return employerAccount;
	}
	/**
	 * 设置：姓名
	 */
	public void setEmployerName(String employer_name) {
		this.employerName = employer_name;
	}
	/**
	 * 获取：姓名
	 */
	public String getEmployerName() {
		return employerName;
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
	public void setEmployee_account(String employee_account) {
		this.employeeAccount = employee_account;
	}
	/**
	 * 获取：雇员账号
	 */
	public String getEmployee_account() {
		return employeeAccount;
	}
	/**
	 * 设置：雇员姓名
	 */
	public void setEmployee_name(String employee_name) {
		this.employeeName = employee_name;
	}
	/**
	 * 获取：雇员姓名
	 */
	public String getEmployee_name() {
		return employeeName;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContact_phone(String contact_phone) {
		this.contactPhone = contact_phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContact_phone() {
		return contactPhone;
	}

}
