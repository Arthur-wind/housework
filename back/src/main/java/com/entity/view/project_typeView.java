package com.entity.view;

import com.entity.project_typeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 项目类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("project_type")
public class project_typeView  extends project_typeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public project_typeView(){
	}
 
 	public project_typeView(project_typeEntity project_typeEntity){
 	try {
			BeanUtils.copyProperties(this, project_typeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
