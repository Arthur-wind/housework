package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Application_AppointmentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Application_AppointmentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Application_AppointmentView;


/**
 * 申请预约
 *
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Application_AppointmentService extends IService<Application_AppointmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Application_AppointmentVO> selectListVO(Wrapper<Application_AppointmentEntity> wrapper);
   	
   	Application_AppointmentVO selectVO(@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
   	
   	List<Application_AppointmentView> selectListView(Wrapper<Application_AppointmentEntity> wrapper);
   	
   	Application_AppointmentView selectView(@Param("ew") Wrapper<Application_AppointmentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Application_AppointmentEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<Application_AppointmentEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<Application_AppointmentEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<Application_AppointmentEntity> wrapper);
}

