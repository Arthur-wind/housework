package com.entity.view;

import com.entity.Application_AppointmentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("application_appointment")
public class Application_AppointmentView  extends Application_AppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Application_AppointmentView(){
	}
 
 	public Application_AppointmentView(Application_AppointmentEntity application_appointmentEntity){
 	try {
			BeanUtils.copyProperties(this, application_appointmentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
