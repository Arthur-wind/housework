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
 * 咨询雇员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("consult_employee")
public class Consult_EmployeeEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Consult_EmployeeEntity() {
		
	}
	
	public Consult_EmployeeEntity(T t) {
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
	 * 添加时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;
	/**
	 * 标题
	 */
					
	private String title;
	
	/**
	 * 咨询问题
	 */
					
	private String question;
	
	/**
	 * 咨询时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date consult_time;
	
	/**
	 * 雇员账号
	 */
					
	private String employee_account;
	
	/**
	 * 雇员姓名
	 */
					
	private String employee_name;
	
	/**
	 * 账号
	 */
					
	private String employer_account;
	
	/**
	 * 姓名
	 */
					
	private String employer_name;
	
	/**
	 * 是否审核
	 */
					
	private String is_reviewed;
	
	/**
	 * 审核回复
	 */
					
	private String review_comment;
	
	


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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：咨询问题
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取：咨询问题
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 设置：咨询时间
	 */
	public void setConsult_Time(Date consult_time) {
		this.consult_time = consult_time;
	}
	/**
	 * 获取：咨询时间
	 */
	public Date getConsult_Time() {
		return consult_time;
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
	 * 设置：是否审核
	 */
	public void setIs_Reviewed(String is_reviewed) {
		this.is_reviewed = is_reviewed;
	}
	/**
	 * 获取：是否审核
	 */
	public String getIs_Reviewed() {
		return is_reviewed;
	}
	/**
	 * 设置：审核回复
	 */
	public void setReview_Comment(String review_comment) {
		this.review_comment = review_comment;
	}
	/**
	 * 获取：审核回复
	 */
	public String getReview_Comment() {
		return review_comment;
	}

}
