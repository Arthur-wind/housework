package com.entity.view;

import com.entity.Electronic_SignatureEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 电子签名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("electronic_signature")
public class Electronic_SignatureView  extends Electronic_SignatureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Electronic_SignatureView(){
	}
 
 	public Electronic_SignatureView(Electronic_SignatureEntity electronic_signatureEntity){
 	try {
			BeanUtils.copyProperties(this, electronic_signatureEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
