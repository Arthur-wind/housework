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
 * 资料认证
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
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
    @TableField("employee_account")
    @JsonProperty("employee_account")
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
    @TableField("contact_phone")
    @JsonProperty("contact_phone")
	private String contactPhone;
	
	/**
	 * 身份证
	 */
	@TableField("id_card_image")
	@JsonProperty("id_card_image")
	private String idCardImage;
	
	/**
	 * 资格证书
	 */
// 资格证书图片
	@TableField("qualification_certificate")
	@JsonProperty("qualification_certificate")
	private String qualificationCertificate;
	
	/**
	 * 申请资料
	 */
    @TableField("application_materials")
	private String applicationMaterials;
	
	/**
	 * 申请原因
	 */
    @TableField("application_reason")
    @JsonProperty("application_reason")
	private String applicationReason;
	
	/**
	 * 申请时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
	@TableField("application_time")
	@JsonProperty("application_time")
	private Date applicationTime;
	
	/**
	 * 是否审核
	 */
    @TableField("is_reviewed")
    @JsonProperty("is_reviewed")
    private String isReviewed;

    /**
	 * 审核回复
	 */
    @TableField("review_comment")
    @JsonProperty("review_comment")
	private String reviewComment;


	// 更完整的写法
	@JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  // 加上pattern保持前后一致
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
	 * 设置：身份证
	 */
	public String getIdCardImage() {
		return idCardImage;
	}
	public void setIdCardImage(String idCardImage) {
		this.idCardImage = idCardImage;
	}
	/**
	 * 设置：资格证书
	 */

	public String getQualificationCertificate() {
		return qualificationCertificate;
	}
	public void setQualificationCertificate(String qualificationCertificate) {
		this.qualificationCertificate = qualificationCertificate;
	}
	/**
	 * 设置：申请资料
	 */
	public void setapplicationMaterials(String shenqingziliao) {
		this.applicationMaterials = shenqingziliao;
	}
	/**
	 * 获取：申请资料
	 */
	public String getapplicationMaterials() {
		return applicationMaterials;
	}
	/**
	 * 设置：申请原因
	 */
	public void setApplication_reason(String application_reason) {
		this.applicationReason = application_reason;
	}
	/**
	 * 获取：申请原因
	 */
	public String getApplication_reason() {
		return applicationReason;
	}
	/**
	 * 设置：申请时间
	 */
	public void setApplicationTime(Date application_time) {
		this.applicationTime = application_time;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getApplicationTime() {
		return applicationTime;
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

}
