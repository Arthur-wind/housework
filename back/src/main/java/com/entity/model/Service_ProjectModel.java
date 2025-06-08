package com.entity.model;

import com.entity.Service_ProjectEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 服务项目
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public class Service_ProjectModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目类型
	 */
	
	private String project_type;
		
	/**
	 * 价格
	 */
	
	private Float price;
		
	/**
	 * 封面
	 */
	
	private String cover_image;
		
	/**
	 * 状态
	 */
	
	private String status;
		
	/**
	 * 详细介绍
	 */
	
	private String description;
		
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
	 * 赞
	 */
	
	private Integer thumbs_up;
		
	/**
	 * 踩
	 */
	
	private Integer thumbs_down;
		
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
	 * 设置：项目类型
	 */
	 
	public void setproject_type(String project_type) {
		this.project_type = project_type;
	}
	
	/**
	 * 获取：项目类型
	 */
	public String getproject_type() {
		return project_type;
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
	 * 设置：赞
	 */
	 
	public void setThumbs_Up(Integer thumbs_up) {
		this.thumbs_up = thumbs_up;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbs_Up() {
		return thumbs_up;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setThumbs_Down(Integer thumbs_down) {
		this.thumbs_down = thumbs_down;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getThumbs_Down() {
		return thumbs_down;
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
