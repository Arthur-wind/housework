package com.dao;

import com.entity.Application_AppointmentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.Application_AppointmentVO;
import com.entity.view.Application_AppointmentView;


/**
 * 申请预约
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Application_AppointmentDao extends BaseMapper<Application_AppointmentEntity> {
	
	List<Application_AppointmentVO> selectListVO(@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
	
	Application_AppointmentVO selectVO(@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
	
	List<Application_AppointmentView> selectListView(@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);

	List<Application_AppointmentView> selectListView(Pagination page,@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
	
	Application_AppointmentView selectView(@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
	
	@MapKey("id")
    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);

	@MapKey("id")
    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);

	@MapKey("id")
    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
}
