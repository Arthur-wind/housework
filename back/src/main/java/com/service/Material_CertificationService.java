package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Material_CertificationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Material_CertificationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Material_CertificationView;


/**
 * 资料认证
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Material_CertificationService extends IService<Material_CertificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Material_CertificationVO> selectListVO(Wrapper<Material_CertificationEntity> wrapper);
   	
   	Material_CertificationVO selectVO(@Param("ew") Wrapper<Material_CertificationEntity> wrapper);
   	
   	List<Material_CertificationView> selectListView(Wrapper<Material_CertificationEntity> wrapper);
   	
   	Material_CertificationView selectView(@Param("ew") Wrapper<Material_CertificationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Material_CertificationEntity> wrapper);
   	

}

