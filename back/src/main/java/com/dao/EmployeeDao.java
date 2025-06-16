package com.dao;

import com.entity.EmployeeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EmployeeVO;
import com.entity.view.EmployeeView;


/**
 * 雇员
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface EmployeeDao extends BaseMapper<EmployeeEntity> {
	
	List<EmployeeVO> selectListVO(@Param("ew") Wrapper<EmployeeEntity> wrapper);
	
	EmployeeVO selectVO(@Param("ew") Wrapper<EmployeeEntity> wrapper);
	
	List<EmployeeView> selectListView(@Param("ew") Wrapper<EmployeeEntity> wrapper);

	List<EmployeeView> selectListView(Pagination page,@Param("ew") Wrapper<EmployeeEntity> wrapper);
	
	EmployeeView selectView(@Param("ew") Wrapper<EmployeeEntity> wrapper);


}
