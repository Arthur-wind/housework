package com.entity.view;

import com.entity.Requirement_InfoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 需求信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("requirement_info")
public class Requirement_InfoView  extends Requirement_InfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Requirement_InfoView(){
	}
 
 	public Requirement_InfoView(Requirement_InfoEntity requirement_infoEntity){
 	try {
			BeanUtils.copyProperties(this, requirement_infoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
