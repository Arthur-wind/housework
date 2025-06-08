package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Electronic_SignatureEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.electronic_signatureVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Electronic_SignatureView;


/**
 * 电子签名
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Electronic_SignatureService extends IService<Electronic_SignatureEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<electronic_signatureVO> selectListVO(Wrapper<Electronic_SignatureEntity> wrapper);
   	
   	electronic_signatureVO selectVO(@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);
   	
   	List<Electronic_SignatureView> selectListView(Wrapper<Electronic_SignatureEntity> wrapper);
   	
   	Electronic_SignatureView selectView(@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Electronic_SignatureEntity> wrapper);
   	

}

