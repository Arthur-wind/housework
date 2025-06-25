package com.dao;

import com.entity.Service_AppointmentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Service_AppointmentVO;
import com.entity.view.Service_AppointmentView;


/**
 * 服务预约
 * 
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Service_AppointmentDao extends BaseMapper<Service_AppointmentEntity> {
	
	List<Service_AppointmentVO> selectListVO(@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
	
	Service_AppointmentVO selectVO(@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
	
	List<Service_AppointmentView> selectListView(@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);

	List<Service_AppointmentView> selectListView(Pagination page,@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
	
	Service_AppointmentView selectView(@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
}
