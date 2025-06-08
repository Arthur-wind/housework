package com.dao;

import com.entity.Consult_EmployeeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Consult_EmployeeVO;
import com.entity.view.Consult_EmployeeView;


/**
 * 咨询雇员
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Consult_EmployeeDao extends BaseMapper<Consult_EmployeeEntity> {
	
	List<Consult_EmployeeVO> selectListVO(@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);
	
	Consult_EmployeeVO selectVO(@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);
	
	List<Consult_EmployeeView> selectListView(@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);

	List<Consult_EmployeeView> selectListView(Pagination page,@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);
	
	Consult_EmployeeView selectView(@Param("ew") Wrapper<Consult_EmployeeEntity> wrapper);
	

}
