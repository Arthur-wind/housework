package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Consult_EmployeeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Consult_EmployeeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Consult_EmployeeView;


/**
 * 咨询雇员
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Consult_EmployeeService extends IService<Consult_EmployeeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Consult_EmployeeVO> selectListVO(Wrapper<Consult_EmployeeEntity> wrapper);
   	
   	Consult_EmployeeVO selectVO(@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);
   	
   	List<Consult_EmployeeView> selectListView(Wrapper<Consult_EmployeeEntity> wrapper);
   	
   	Consult_EmployeeView selectView(@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Consult_EmployeeEntity> wrapper);
   	

}

