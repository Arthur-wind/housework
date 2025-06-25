package com.entity.view;

import com.entity.Consult_employerEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 咨询雇主
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("consult_employer")
public class Consult_employerView  extends Consult_employerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Consult_employerView(){
	}
 
 	public Consult_employerView(Consult_employerEntity consult_employerEntity){
 	try {
			BeanUtils.copyProperties(this, consult_employerEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
