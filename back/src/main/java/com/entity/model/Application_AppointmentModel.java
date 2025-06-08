package com.entity.model;

import com.entity.Application_AppointmentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 申请预约
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public class Application_AppointmentModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目名称
	 */
	
	private String project_name;
		
	/**
	 * 薪资
	 */
	
	private Float salary;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date application_time;
		
	/**
	 * 申请备注
	 */
	
	private String application_notes;
		
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
	 * 是否审核
	 */
	
	private String is_reviewed;
		
	/**
	 * 审核回复
	 */
	
	private String review_comment;
		
	/**
	 * 是否支付
	 */
	
	private String payment_status;
				
	
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
	 * 设置：薪资
	 */
	 
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	/**
	 * 获取：薪资
	 */
	public Float getSalary() {
		return salary;
	}
				
	
	/**
	 * 设置：申请时间
	 */
	 
	public void setApplication_Time(Date application_time) {
		this.application_time = application_time;
	}
	
	/**
	 * 获取：申请时间
	 */
	public Date getApplication_Time() {
		return application_time;
	}
				
	
	/**
	 * 设置：申请备注
	 */
	 
	public void setShenqingbeizhu(String application_notes) {
		this.application_notes = application_notes;
	}
	
	/**
	 * 获取：申请备注
	 */
	public String getShenqingbeizhu() {
		return application_notes;
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
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setPayment_Status(String payment_status) {
		this.payment_status = payment_status;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getPayment_Status() {
		return payment_status;
	}
			
}
