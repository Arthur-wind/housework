package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Service_AppointmentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Service_AppointmentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Service_AppointmentView;


/**
 * 服务预约
 *
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Service_AppointmentService extends IService<Service_AppointmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Service_AppointmentVO> selectListVO(Wrapper<Service_AppointmentEntity> wrapper);
   	
   	Service_AppointmentVO selectVO(@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
   	
   	List<Service_AppointmentView> selectListView(Wrapper<Service_AppointmentEntity> wrapper);
   	
   	Service_AppointmentView selectView(@Param("ew") Wrapper<Service_AppointmentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Service_AppointmentEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<Service_AppointmentEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<Service_AppointmentEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<Service_AppointmentEntity> wrapper);
}

