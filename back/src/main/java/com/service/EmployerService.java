package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EmployerEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EmployerVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EmployerView;


/**
 * 雇主
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:54
 */
public interface EmployerService extends IService<EmployerEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EmployerVO> selectListVO(Wrapper<EmployerEntity> wrapper);
   	
   	EmployerVO selectVO(@Param("ew") Wrapper<EmployerEntity> wrapper);
   	
   	List<EmployerView> selectListView(Wrapper<EmployerEntity> wrapper);
   	
   	EmployerView selectView(@Param("ew") Wrapper<EmployerEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EmployerEntity> wrapper);
   	

}

