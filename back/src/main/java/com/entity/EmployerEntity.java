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
 * 雇主
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:54
 */
@TableName("employer")
public class EmployerEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public EmployerEntity() {
		
	}
	
	public EmployerEntity(T t) {
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
	 * 账号
	 */
	@TableField("employer_account")
	@JsonProperty("employer_account")
	private String employerAccount; // 改为驼峰命名（推荐）

	/**
	 * 姓名
	 */
	@TableField("employer_name")
	@JsonProperty("employer_name")
	private String employerName; // 改为驼峰命名（推荐）
	
	/**
	 * 密码
	 */
	@TableField("password")
	private String password;

	
	/**
	 * 年龄
	 */
	@TableField("age")
	private Integer age;
	
	/**
	 * 性别
	 */
	@TableField("gender")
	private String gender;
	
	/**
	 * 手机
	 */
	@TableField("phone")
	@JsonProperty("phone")
	private String phone;
	
	/**
	 * 照片
	 */
	@TableField("photo")
	private String photo;
	
	
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
