package com.entity.view;

import com.entity.Material_CertificationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 资料认证
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
@TableName("material_certification")
public class Material_CertificationView  extends Material_CertificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public Material_CertificationView(){
	}
 
 	public Material_CertificationView(Material_CertificationEntity material_certificationEntity){
 	try {
			BeanUtils.copyProperties(this, material_certificationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
