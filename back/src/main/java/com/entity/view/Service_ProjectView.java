package com.entity.view;

import com.entity.Service_ProjectEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 服务项目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("service_project")
public class Service_ProjectView  extends Service_ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Service_ProjectView(){
	}
 
 	public Service_ProjectView(Service_ProjectEntity service_projectEntity){
 	try {
			BeanUtils.copyProperties(this, service_projectEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
