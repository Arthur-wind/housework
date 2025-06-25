package com.dao;

import com.entity.Employer_evaluationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Employer_evaluationVO;
import com.entity.view.Employer_evaluationView;


/**
 * 雇主评价
 * 
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Employer_evaluationDao extends BaseMapper<Employer_evaluationEntity> {
	
	List<Employer_evaluationVO> selectListVO(@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);
	
	Employer_evaluationVO selectVO(@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);
	
	List<Employer_evaluationView> selectListView(@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);

	List<Employer_evaluationView> selectListView(Pagination page,@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);
	
	Employer_evaluationView selectView(@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);
	

}
