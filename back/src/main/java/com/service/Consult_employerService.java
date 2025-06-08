package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Consult_employerEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Consult_employerVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Consult_employerView;


/**
 * 咨询雇主
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Consult_employerService extends IService<Consult_employerEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Consult_employerVO> selectListVO(Wrapper<Consult_employerEntity> wrapper);
   	
   	Consult_employerVO selectVO(@Param("ew") Wrapper<Consult_employerEntity> wrapper);
   	
   	List<Consult_employerView> selectListView(Wrapper<Consult_employerEntity> wrapper);
   	
   	Consult_employerView selectView(@Param("ew") Wrapper<Consult_employerEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Consult_employerEntity> wrapper);
   	

}

