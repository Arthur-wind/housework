package com.entity.view;

import com.entity.Service_AppointmentEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 服务预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("service_appointment")
public class Service_AppointmentView  extends Service_AppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Service_AppointmentView(){
	}
 
 	public Service_AppointmentView(Service_AppointmentEntity service_appointmentEntity){
 	try {
			BeanUtils.copyProperties(this, service_appointmentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
