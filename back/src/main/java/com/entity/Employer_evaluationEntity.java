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
 * 雇主评价
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("employer_evaluation")
public class Employer_evaluationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Employer_evaluationEntity() {
		
	}
	
	public Employer_evaluationEntity(T t) {
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
	 * 服务评价
	 */

	@TableId("service_evaluation")
	private String serviceEvaluation;
	
	/**
	 * 项目评价
	 */

	@TableId("project_evaluation")
	private String projectEvaluation;
	
	/**
	 * 满意程度
	 */

	@TableId("satisfaction_level")
	private String satisfactionLevel;
	
	/**
	 * 预约时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@TableField("appointment_time")
	private Date appointmentTime;
	
	/**
	 * 评语
	 */
					
	private String comments;
	
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
	 * 设置：服务评价
	 */
	public void setService_evaluation(String service_evaluation) {
		this.serviceEvaluation = service_evaluation;
	}
	/**
	 * 获取：服务评价
	 */
	public String getService_evaluation() {
		return serviceEvaluation;
	}
	/**
	 * 设置：项目评价
	 */
	public void setProject_evaluation(String project_evaluation) {
		this.projectEvaluation = project_evaluation;
	}
	/**
	 * 获取：项目评价
	 */
	public String getProject_evaluation() {
		return projectEvaluation;
	}
	/**
	 * 设置：满意程度
	 */
	public void setSatisfaction_level(String satisfaction_level) {
		this.satisfactionLevel = satisfaction_level;
	}
	/**
	 * 获取：满意程度
	 */
	public String getSatisfaction_level() {
		return satisfactionLevel;
	}
	/**
	 * 设置：预约时间
	 */
	public void setAppointment_time(Date appointment_time) {
		this.appointmentTime = appointment_time;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getAppointment_time() {
		return appointmentTime;
	}
	/**
	 * 设置：评语
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * 获取：评语
	 */
	public String getComments() {
		return comments;
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

}
