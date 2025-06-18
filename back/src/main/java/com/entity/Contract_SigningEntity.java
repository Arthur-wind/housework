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
 * 签订合同
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("contract_signing")
public class Contract_SigningEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Contract_SigningEntity() {
		
	}
	
	public Contract_SigningEntity(T t) {
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

	@TableId("project_name")
	private String projectName;
	
	/**
	 * 内容
	 */
					
	private String content;
	
	/**
	 * 文件
	 */
					
	private String document;
	
	/**
	 * 签订日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@TableField("sign_date")
	@DateTimeFormat 		
	private Date signDate;
	
	/**
	 * 有效期
	 */

	@TableId("validity_period")
	private String validityPeriod;
	
	/**
	 * 账号
	 */

	@TableId("employer_account")
	private String employerAccount;
	
	/**
	 * 姓名
	 */

	@TableId("employer_name")
	private String employerName;
	
	/**
	 * 手机
	 */
					
	private String phone;
	
	/**
	 * 雇员账号
	 */

	@TableId("employee_account")
	private String employeeAccount;
	
	/**
	 * 雇员姓名
	 */

	@TableId("employee_name")
	private String employeeName;
	
	/**
	 * 联系电话
	 */

	@TableId("contact_phone")
	private String contactPhone;
	
	/**
	 * 是否审核
	 */
					
	private String is_reviewed;
	
	/**
	 * 审核回复
	 */
					
	private String review_comment;
	
	
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
	public void setProject_name(String project_name) {
		this.projectName = project_name;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProject_name() {
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
	 * 设置：文件
	 */
	public void setDocument(String document) {
		this.document = document;
	}
	/**
	 * 获取：文件
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * 设置：签订日期
	 */
	public void setSign_date(Date sign_date) {
		this.signDate = sign_date;
	}
	/**
	 * 获取：签订日期
	 */
	public Date getSign_date() {
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
	public void setEmployer_name(String employer_name) {
		this.employerName = employer_name;
	}
	/**
	 * 获取：姓名
	 */
	public String getEmployer_name() {
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
	/**
	 * 设置：是否审核
	 */
	public void setIs_reviewed(String is_reviewed) {
		this.is_reviewed = is_reviewed;
	}
	/**
	 * 获取：是否审核
	 */
	public String getIs_reviewed() {
		return is_reviewed;
	}
	/**
	 * 设置：审核回复
	 */
	public void setReview_comment(String review_comment) {
		this.review_comment = review_comment;
	}
	/**
	 * 获取：审核回复
	 */
	public String getReview_comment() {
		return review_comment;
	}

}
