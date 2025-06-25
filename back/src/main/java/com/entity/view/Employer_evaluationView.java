package com.entity.view;

import com.entity.Employer_evaluationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 雇主评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("employer_evaluation")
public class Employer_evaluationView  extends Employer_evaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Employer_evaluationView(){
	}
 
 	public Employer_evaluationView(Employer_evaluationEntity employer_evaluationEntity){
 	try {
			BeanUtils.copyProperties(this, employer_evaluationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
