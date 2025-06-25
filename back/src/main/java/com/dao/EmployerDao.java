package com.dao;

import com.entity.EmployerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EmployerVO;
import com.entity.view.EmployerView;


/**
 * 雇主
 * 
 * @author 
 * @email 
 * @date 2025-6-13 19:23:54
 */
public interface EmployerDao extends BaseMapper<EmployerEntity> {
	
	List<EmployerVO> selectListVO(@Param("ew") Wrapper<EmployerEntity> wrapper);
	
	EmployerVO selectVO(@Param("ew") Wrapper<EmployerEntity> wrapper);
	
	List<EmployerView> selectListView(@Param("ew") Wrapper<EmployerEntity> wrapper);

	List<EmployerView> selectListView(Pagination page,@Param("ew") Wrapper<EmployerEntity> wrapper);
	
	EmployerView selectView(@Param("ew") Wrapper<EmployerEntity> wrapper);
	

}
