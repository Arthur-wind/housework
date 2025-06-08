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
 * 雇员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("employee")
public class EmployeeEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public EmployeeEntity() {
		
	}
	
	public EmployeeEntity(T t) {
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
	 * 雇员账号
	 */
					
	private String employee_account;
	
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
