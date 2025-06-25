package com.entity.vo;

import com.entity.Requirement_InfoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 需求信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public class Requirement_InfoVO  implements Serializable {
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
	 * 工作时间
	 */
	
	private String working_hours;
		
	/**
	 * 工作地点
	 */
	
	private String work_location;
		
	/**
	 * 要求
	 */
	
	private String requirements;
		
	/**
	 * 详细说明
	 */
	
	private String detailed_description;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date publish_time;
		
	/**
	 * 封面
	 */
	
	private String cover_image;
		
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
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date last_click_time;
		
	/**
	 * 点击次数
	 */
	
	private Integer click_count;
				
	
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
	 * 设置：工作时间
	 */
	 
	public void setWorking_Hours(String working_hours) {
		this.working_hours = working_hours;
	}
	
	/**
	 * 获取：工作时间
	 */
	public String getWorking_Hours() {
		return working_hours;
	}
				
	
	/**
	 * 设置：工作地点
	 */
	 
	public void setWork_Location(String work_location) {
		this.work_location = work_location;
	}
	
	/**
	 * 获取：工作地点
	 */
	public String getWork_Location() {
		return work_location;
	}
				
	
	/**
	 * 设置：要求
	 */
	 
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	
	/**
	 * 获取：要求
	 */
	public String getRequirements() {
		return requirements;
	}
				
	
	/**
	 * 设置：详细说明
	 */
	 
	public void setDetailed_Description(String detailed_description) {
		this.detailed_description = detailed_description;
	}
	
	/**
	 * 获取：详细说明
	 */
	public String getDetailed_Description() {
		return detailed_description;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setPublish_Time(Date publish_time) {
		this.publish_time = publish_time;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getPublish_Time() {
		return publish_time;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setCover_Image(String cover_image) {
		this.cover_image = cover_image;
	}
	
	/**
	 * 获取：封面
	 */
	public String getCover_Image() {
		return cover_image;
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
	 * 设置：最近点击时间
	 */
	 
	public void setLast_Click_Time(Date last_click_time) {
		this.last_click_time = last_click_time;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getLast_Click_Time() {
		return last_click_time;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClick_Count(Integer click_count) {
		this.click_count = click_count;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClick_Count() {
		return click_count;
	}
			
}
