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
 * 咨询雇主
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("consult_employer")
public class Consult_employerEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Consult_employerEntity() {
		
	}
	
	public Consult_employerEntity(T t) {
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
	@TableId("consult_time")
	private Date consultTime;

	/**
	 * 雇员账号
	 */

	@TableField("employee_account")
	private String employeeAccount;

	/**
	 * 雇员姓名
	 */

	@TableField("employee_name")
	private String employeeName;

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
	 * 是否审核
	 */

	@TableId("is_reviewed")
	private String isReviewed;

	/**
	 * 审核回复
	 */

	@TableField("review_comment")
	private String reviewComment;
	
	
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
	public void setConsult_time(Date consult_time) {
		this.consultTime = consult_time;
	}
	/**
	 * 获取：咨询时间
	 */
	public Date getConsult_time() {
		return consultTime;
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
	 * 设置：是否审核
	 */
	public void setIs_reviewed(String is_reviewed) {
		this.isReviewed = is_reviewed;
	}
	/**
	 * 获取：是否审核
	 */
	public String getIs_reviewed() {
		return isReviewed;
	}
	/**
	 * 设置：审核回复
	 */
	public void setReview_comment(String review_comment) {
		this.reviewComment = review_comment;
	}
	/**
	 * 获取：审核回复
	 */
	public String getReview_comment() {
		return reviewComment;
	}

}