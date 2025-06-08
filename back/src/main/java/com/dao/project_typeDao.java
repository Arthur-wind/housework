package com.dao;

import com.entity.project_typeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.project_typeVO;
import com.entity.view.project_typeView;


/**
 * 项目类型
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface project_typeDao extends BaseMapper<project_typeEntity> {
	
	List<project_typeVO> selectListVO(@Param("ew") Wrapper<project_typeEntity> wrapper);
	
	project_typeVO selectVO(@Param("ew") Wrapper<project_typeEntity> wrapper);
	
	List<project_typeView> selectListView(@Param("ew") Wrapper<project_typeEntity> wrapper);

	List<project_typeView> selectListView(Pagination page,@Param("ew") Wrapper<project_typeEntity> wrapper);
	
	project_typeView selectView(@Param("ew") Wrapper<project_typeEntity> wrapper);
	

}
