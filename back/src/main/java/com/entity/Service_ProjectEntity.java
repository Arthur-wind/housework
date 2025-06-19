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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 服务项目
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("service_project")
public class Service_ProjectEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Service_ProjectEntity() {
		
	}
	
	public Service_ProjectEntity(T t) {
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
    @TableField("project_name")
    @JsonProperty("project_name")
	private String projectName;
	
	/**
	 * 项目类型
	 */
    @TableField("project_type")
    @JsonProperty("project_type")
	private String projectType;
	
	/**
	 * 价格
	 */
					
	private Float price;
	
	/**
	 * 封面
	 */

	@TableId("cover_image")
	private String coverImage;
	
	/**
	 * 状态
	 */
    @TableField("status")
    @JsonProperty("status")
	private String status;
	
	/**
	 * 详细介绍
	 */
					
	private String description;
	
	/**
	 * 雇员账号
	 */

	@TableId("employee_account")
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

	@TableId("review_comment")
	private String reviewComment;
	
	/**
	 * 赞
	 */

	@TableId("thumbs_up")
	private Integer thumbsUp;
	
	/**
	 * 踩
	 */

	@TableId("thumbs_down")
	private Integer thumbsDown;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
	@TableField("last_click_time")
	private Date last_clickTime;
	
	/**
	 * 点击次数
	 */

	@TableId("click_count")
	private Integer clickCount;
	
	
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
	 * 设置：项目类型
	 */
	public void setProjectType(String project_type) {
		this.projectType = project_type;
	}
	/**
	 * 获取：项目类型
	 */
	public String getProjectType() {
		return projectType;
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
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：详细介绍
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：详细介绍
	 */
	public String getDescription() {
		return description;
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
	 * 设置：赞
	 */
	public void setThumbs_up(Integer thumbs_up) {
		this.thumbsUp = thumbs_up;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbs_up() {
		return thumbsUp;
	}
	/**
	 * 设置：踩
	 */
	public void setThumbs_down(Integer thumbs_down) {
		this.thumbsDown = thumbs_down;
	}
	/**
	 * 获取：踩
	 */
	public Integer getThumbs_down() {
		return thumbsDown;
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
