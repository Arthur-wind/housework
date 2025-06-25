package com.entity.model;

import com.entity.EmployerEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 雇主
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-6-13 19:23:54
 */
public class EmployerModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 姓名
	 */
	
	private String employer_name;
		
	/**
	 * 年龄
	 */
	
	private Integer age;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 手机
	 */
	
	private String phone;
		
	/**
	 * 照片
	 */
	
	private String photo;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
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
	 * 设置：年龄
	 */
	 
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
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
	 * 设置：照片
	 */
	 
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * 获取：照片
	 */
	public String getPhoto() {
		return photo;
	}
			
}
