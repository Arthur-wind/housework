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
 * 需求信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("requirement_info")
public class Requirement_InfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Requirement_InfoEntity() {
		
	}
	
	public Requirement_InfoEntity(T t) {
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

	@JsonProperty("title")
	private String title;
	
	/**
	 * 项目名称
	 */

	@TableField("project_type")
//	@JsonProperty("project_type")
	private String projectType;
	
	/**
	 * 薪资
	 */
					
	private Float salary;
	
	/**
	 * 工作时间
	 */

	@TableField("working_hours")
	private String workingHours;
	
	/**
	 * 工作地点
	 */

	@TableField("work_location")
	@JsonProperty("work_location")
	private String workLocation;
	
	/**
	 * 要求
	 */
					
	private String requirements;
	
	/**
	 * 详细说明
	 */

	@TableField("detailed_description")
	private String detailedDescription;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
	@JsonProperty("publish_time")
	@TableField("publish_time")
	private Date publishTime;
	
	/**
	 * 封面
	 */

	@TableField("cover_image")
	private String coverImage;
	
	/**
	 * 账号
	 */

//	@TableId("employer_account")
	@TableField("employer_account")
	@JsonProperty("employer_account")
	private String employerAccount;
	
	/**
	 * 姓名
	 */

//	@TableId("employer_name")
	@TableField("employer_name")
	@JsonProperty("employer_name")
	private String employerName;
	
	/**
	 * 手机
	 */
					
	private String phone;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@TableField("last_click_time")
	@JsonProperty("last_click_time")
	private Date last_clickTime;
	
	/**
	 * 点击次数
	 */

	@TableField("click_count")
	private Integer clickCount;
	
	
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
	 * 设置：项目名称
	 */
	public void setProjectType(String project_type) {
		this.projectType = project_type;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectType() {
		return projectType;
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
	public void setWorking_hours(String working_hours) {
		this.workingHours = working_hours;
	}
	/**
	 * 获取：工作时间
	 */
	public String getWorking_hours() {
		return workingHours;
	}
	/**
	 * 设置：工作地点
	 */
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	/**
	 * 获取：工作地点
	 */
	public String getWorkLocation() {
		return workLocation;
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
	public void setDetailed_description(String detailed_description) {
		this.detailedDescription = detailed_description;
	}
	/**
	 * 获取：详细说明
	 */
	public String getDetailed_description() {
		return detailedDescription;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublish_time(Date publish_time) {
		this.publishTime = publish_time;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublish_time() {
		return publishTime;
	}
	/**
	 * 设置：封面
	 */
	public void setCover_image(String cover_image) {
		this.coverImage = cover_image;
	}
	/**
	 * 获取：封面
	 */
	public String getCover_image() {
		return coverImage;
	}
	/**
	 * 设置：账号
	 */
	public void setEmployer_Account(String employer_account) {
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
	 * 设置：最近点击时间
	 */
	public void setLast_Click_time(Date last_click_time) {
		this.last_clickTime = last_click_time;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getLast_Click_time() {
		return last_clickTime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClick_count(Integer click_count) {
		this.clickCount = click_count;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClick_count() {
		return clickCount;
	}

}
