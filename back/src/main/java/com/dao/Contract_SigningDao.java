package com.dao;

import com.entity.Contract_SigningEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Contract_SigningVO;
import com.entity.view.Contract_SigningView;


/**
 * 签订合同
 * 
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Contract_SigningDao extends BaseMapper<Contract_SigningEntity> {
	
	List<Contract_SigningVO> selectListVO(@Param("ew") Wrapper<Contract_SigningEntity> wrapper);
	
	Contract_SigningVO selectVO(@Param("ew") Wrapper<Contract_SigningEntity> wrapper);
	
	List<Contract_SigningView> selectListView(@Param("ew") Wrapper<Contract_SigningEntity> wrapper);

	List<Contract_SigningView> selectListView(Pagination page,@Param("ew") Wrapper<Contract_SigningEntity> wrapper);
	
	Contract_SigningView selectView(@Param("ew") Wrapper<Contract_SigningEntity> wrapper);
	

}
