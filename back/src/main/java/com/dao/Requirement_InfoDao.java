package com.dao;

import com.entity.Requirement_InfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Requirement_InfoVO;
import com.entity.view.Requirement_InfoView;


/**
 * 需求信息
 * 
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Requirement_InfoDao extends BaseMapper<Requirement_InfoEntity> {
	
	List<Requirement_InfoVO> selectListVO(@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);
	
	Requirement_InfoVO selectVO(@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);
	
	List<Requirement_InfoView> selectListView(@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);

	List<Requirement_InfoView> selectListView(Pagination page,@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);
	
	Requirement_InfoView selectView(@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);
	

}
