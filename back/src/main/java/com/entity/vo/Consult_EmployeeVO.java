package com.entity.vo;

import com.entity.Consult_EmployeeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 咨询雇员
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public class Consult_EmployeeVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
