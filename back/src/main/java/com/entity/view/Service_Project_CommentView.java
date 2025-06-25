package com.entity.view;

import com.entity.Service_Project_CommentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 服务项目评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("service_project_comment")
public class Service_Project_CommentView  extends Service_Project_CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Service_Project_CommentView(){
	}
 
 	public Service_Project_CommentView(Service_Project_CommentEntity service_project_commentEntity){
 	try {
			BeanUtils.copyProperties(this, service_project_commentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
