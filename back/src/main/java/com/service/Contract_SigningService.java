package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Contract_SigningEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Contract_SigningVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Contract_SigningView;


/**
 * 签订合同
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Contract_SigningService extends IService<Contract_SigningEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Contract_SigningVO> selectListVO(Wrapper<Contract_SigningEntity> wrapper);
   	
   	Contract_SigningVO selectVO(@Param("ew") Wrapper<Contract_SigningEntity> wrapper);
   	
   	List<Contract_SigningView> selectListView(Wrapper<Contract_SigningEntity> wrapper);
   	
   	Contract_SigningView selectView(@Param("ew") Wrapper<Contract_SigningEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Contract_SigningEntity> wrapper);
   	

}

