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
 * 服务预约
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("service_appointment")
public class Service_AppointmentEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Service_AppointmentEntity() {
		
	}
	
	public Service_AppointmentEntity(T t) {
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
	 * 预约编号
	 */

	@TableId("appointment_no")
	private String appointmentNo;
	
	/**
	 * 项目名称
	 */
    @TableField("project_name")
    @JsonProperty("project_name")
	private String projectName;
	
	/**
	 * 价格
	 */
					
	private Float price;
	
	/**
	 * 预约时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
	@TableField("appointment_time")
	@JsonProperty("appointment_time")
	private Date appointmentTime;
	
	/**
	 * 预约备注
	 */

	@TableField("appointment_notes")
	private String appointmentNotes;
	
	/**
	 * 账号
	 */

	@TableId("employer_account")
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

	@TableId("employee_account")
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

	@TableId("contact_phone")
	private String contactPhone;
	
	/**
	 * 是否审核
	 */
    @TableField("is_reviewed")
    @JsonProperty("is_reviewed")
    private String isReviewed;

    /**
	 * 审核回复
	 */

	@TableField("review_comment")
	@JsonProperty("review_comment")
	private String reviewComment;
	
	/**
	 * 是否支付
	 */

	@TableField("payment_status")
	private String paymentStatus;
	
	
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
	 * 设置：预约编号
	 */
	public void setAppointment_no(String appointment_no) {
		this.appointmentNo = appointment_no;
	}
	/**
	 * 获取：预约编号
	 */
	public String getAppointment_no() {
		return appointmentNo;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String project_name) {
		this.projectName = project_name;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
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
	 * 设置：预约备注
	 */
	public void setAppointment_notes(String appointment_notes) {
		this.appointmentNotes = appointment_notes;
	}
	/**
	 * 获取：预约备注
	 */
	public String getAppointment_notes() {
		return appointmentNotes;
	}
	/**
	 * 设置：账号
	 */
	public void setEmployerAccount(String employer_account) {
		this.employerAccount = employer_account;
	}
	/**
	 * 获取：账号
	 */
	public String getEmployerAccount() {
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
	public void setEmployeeAccount(String employee_account) {
		this.employeeAccount = employee_account;
	}
	/**
	 * 获取：雇员账号
	 */
	public String getEmployeeAccount() {
		return employeeAccount;
	}
	/**
	 * 设置：雇员姓名
	 */
	public void setEmployeeName(String employee_name) {
		this.employeeName = employee_name;
	}
	/**
	 * 获取：雇员姓名
	 */
	public String getEmployeeName() {
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
	public void setIsReviewed(String isReviewed) {
		this.isReviewed = isReviewed;
	}
	/**
	 * 获取：是否审核
	 */
	public String getIsReviewed() {
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
	/**
	 * 设置：是否支付
	 */
	public void setPayment_status(String payment_status) {
		this.paymentStatus = payment_status;
	}
	/**
	 * 获取：是否支付
	 */
	public String getPayment_status() {
		return paymentStatus;
	}

}
