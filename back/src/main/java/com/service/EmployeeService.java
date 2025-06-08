package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EmployeeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EmployeeView;


/**
 * 雇员
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface EmployeeService extends IService<EmployeeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EmployeeVO> selectListVO(Wrapper<EmployeeEntity> wrapper);
   	
   	EmployeeVO selectVO(@Param("ew") Wrapper<EmployeeEntity> wrapper);
   	
   	List<EmployeeView> selectListView(Wrapper<EmployeeEntity> wrapper);
   	
   	EmployeeView selectView(@Param("ew") Wrapper<EmployeeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EmployeeEntity> wrapper);
   	

}

