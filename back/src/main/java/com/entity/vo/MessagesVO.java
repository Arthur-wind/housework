package com.entity.vo;

import com.entity.MessagesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 意见反馈
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public class MessagesVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户名
	 */
	
	private String username;
		
	/**
	 * 留言内容
	 */
	
	private String content;
		
	/**
	 * 留言图片
	 */
	
	private String content_picture;
		
	/**
	 * 回复内容
	 */
	
	private String reply;
		
	/**
	 * 回复图片
	 */
	
	private String reply_picture;
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
				
	
	/**
	 * 设置：留言内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：留言内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：留言图片
	 */
	 
	public void setContent_Picture(String content_picture) {
		this.content_picture = content_picture;
	}
	
	/**
	 * 获取：留言图片
	 */
	public String getContent_Picture() {
		return content_picture;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getReply() {
		return reply;
	}
				
	
	/**
	 * 设置：回复图片
	 */
	 
	public void setReply_Picture(String reply_picture) {
		this.reply_picture = reply_picture;
	}
	
	/**
	 * 获取：回复图片
	 */
	public String getReply_Picture() {
		return reply_picture;
	}
			
}
