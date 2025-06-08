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
 * 资料认证
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("material_certification")
public class Material_CertificationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public Material_CertificationEntity() {
		
	}
	
	public Material_CertificationEntity(T t) {
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
	 * 雇员姓名
	 */
					
	private String employee_name;
	
	/**
	 * 联系电话
	 */
					
	private String contact_phone;
	
	/**
	 * 身份证
	 */
					
	private String id_card;
	
	/**
	 * 资格证书
	 */
					
	private String application_certificate;
	
	/**
	 * 申请资料
	 */
					
	private String shenqingziliao;
	
	/**
	 * 申请原因
	 */
					
	private String application_reason;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date application_time;
	
	/**
	 * 是否审核
	 */
					
	private String is_reviewed;
	
	/**
	 * 审核回复
	 */
					
	private String review_comment;
	
	
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
	 * 设置：资格证书
	 */
	public void setapplication_certificate(String application_certificate) {
		this.application_certificate = application_certificate;
	}
	/**
	 * 获取：资格证书
	 */
	public String getapplication_certificate() {
		return application_certificate;
	}
	/**
	 * 设置：申请资料
	 */
	public void setShenqingziliao(String shenqingziliao) {
		this.shenqingziliao = shenqingziliao;
	}
	/**
	 * 获取：申请资料
	 */
	public String getShenqingziliao() {
		return shenqingziliao;
	}
	/**
	 * 设置：申请原因
	 */
	public void setApplication_Reason(String application_reason) {
		this.application_reason = application_reason;
	}
	/**
	 * 获取：申请原因
	 */
	public String getApplication_Reason() {
		return application_reason;
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
