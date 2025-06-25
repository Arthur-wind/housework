package com.entity.view;

import com.entity.Contract_SigningEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 签订合同
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("contract_signing")
public class Contract_SigningView  extends Contract_SigningEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Contract_SigningView(){
	}
 
 	public Contract_SigningView(Contract_SigningEntity contract_signingEntity){
 	try {
			BeanUtils.copyProperties(this, contract_signingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
