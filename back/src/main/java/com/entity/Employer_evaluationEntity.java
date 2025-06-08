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
					
	private String project_name;
	
	/**
	 * 服务评价
	 */
					
	private String service_evaluation;
	
	/**
	 * 项目评价
	 */
					
	private String project_evaluation;
	
	/**
	 * 满意程度
	 */
					
	private String satisfaction_level;
	
	/**
	 * 预约时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date appointment_time;
	
	/**
	 * 评语
	 */
					
	private String comments;
	
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
	 * 设置：服务评价
	 */
	public void setService_Evaluation(String service_evaluation) {
		this.service_evaluation = service_evaluation;
	}
	/**
	 * 获取：服务评价
	 */
	public String getService_Evaluation() {
		return service_evaluation;
	}
	/**
	 * 设置：项目评价
	 */
	public void setProject_Evaluation(String project_evaluation) {
		this.project_evaluation = project_evaluation;
	}
	/**
	 * 获取：项目评价
	 */
	public String getProject_Evaluation() {
		return project_evaluation;
	}
	/**
	 * 设置：满意程度
	 */
	public void setSatisfaction_Level(String satisfaction_level) {
		this.satisfaction_level = satisfaction_level;
	}
	/**
	 * 获取：满意程度
	 */
	public String getSatisfaction_Level() {
		return satisfaction_level;
	}
	/**
	 * 设置：预约时间
	 */
	public void setAppointment_time(Date appointment_time) {
		this.appointment_time = appointment_time;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getAppointment_time() {
		return appointment_time;
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
