package com.dao;

import com.entity.Consult_employerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Consult_employerVO;
import com.entity.view.Consult_employerView;


/**
 * 咨询雇主
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Consult_employerDao extends BaseMapper<Consult_employerEntity> {
	
	List<Consult_employerVO> selectListVO(@Param("ew") Wrapper<Consult_employerEntity> wrapper);
	
	Consult_employerVO selectVO(@Param("ew") Wrapper<Consult_employerEntity> wrapper);
	
	List<Consult_employerView> selectListView(@Param("ew") Wrapper<Consult_employerEntity> wrapper);

	List<Consult_employerView> selectListView(Pagination page,@Param("ew") Wrapper<Consult_employerEntity> wrapper);
	
	Consult_employerView selectView(@Param("ew") Wrapper<Consult_employerEntity> wrapper);
	

}
