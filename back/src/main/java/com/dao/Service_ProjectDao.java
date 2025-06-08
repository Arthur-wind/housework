package com.dao;

import com.entity.Service_ProjectEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Service_ProjectVO;
import com.entity.view.Service_ProjectView;


/**
 * 服务项目
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Service_ProjectDao extends BaseMapper<Service_ProjectEntity> {
	
	List<Service_ProjectVO> selectListVO(@Param("ew") Wrapper<Service_ProjectEntity> wrapper);
	
	Service_ProjectVO selectVO(@Param("ew") Wrapper<Service_ProjectEntity> wrapper);
	
	List<Service_ProjectView> selectListView(@Param("ew") Wrapper<Service_ProjectEntity> wrapper);

	List<Service_ProjectView> selectListView(Pagination page,@Param("ew") Wrapper<Service_ProjectEntity> wrapper);
	
	Service_ProjectView selectView(@Param("ew") Wrapper<Service_ProjectEntity> wrapper);
	

}
