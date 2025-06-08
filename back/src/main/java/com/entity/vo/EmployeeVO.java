package com.entity.vo;

import com.entity.EmployeeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 雇员
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public class EmployeeVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 雇员姓名
	 */
	
	private String employee_name;
		
	/**
	 * 年龄
	 */
	
	private Integer age;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 联系电话
	 */
	
	private String contact_phone;
		
	/**
	 * 身份证
	 */
	
	private String id_card;
		
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
	 * 设置：身份证
	 */
	 
	public void setId_Card(String id_card) {
		this.id_card = id_card;
	}
	
	/**
	 * 获取：身份证
	 */
	public String getId_Card() {
		return id_card;
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
