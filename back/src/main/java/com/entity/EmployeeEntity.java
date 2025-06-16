package com.entity;

import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

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

    public EmployeeEntity() {}

    public EmployeeEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 雇员账号
     */
    @TableField("employee_account")
    @JsonProperty("employee_account")
    private String employeeAccount;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 雇员姓名
     */
    @TableField("employee_name")
    @JsonProperty("employee_name")
    private String employeeName;

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
     * 联系电话
     */
    @TableField("contact_phone")
    @JsonProperty("contact_phone")
    private String contactPhone;

    /**
     * 身份证
     */
    @TableField("id_card")
    @JsonProperty("id_card")
    private String idCard;

    /**
     * 照片
     */
    @TableField("photo")
    private String photo;

    /**
     * 添加时间
     */
    @TableField("addtime")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    // Getter and Setter Methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_Account() {
        return employeeAccount;
    }

    public void setEmployee_Account(String employee_account) {
        this.employeeAccount = employee_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployee_Name() {
        return employeeName;
    }

    public void setEmployee_Name(String employee_name) {
        this.employeeName = employee_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact_Phone() {
        return contactPhone;
    }

    public void setContact_Phone(String contact_phone) {
        this.contactPhone = contact_phone;
    }

    public String getId_Card() {
        return idCard;
    }

    public void setId_Card(String id_card) {
        this.idCard = id_card;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
