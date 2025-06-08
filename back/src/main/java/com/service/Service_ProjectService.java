package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Service_ProjectEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Service_ProjectVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Service_ProjectView;


/**
 * 服务项目
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Service_ProjectService extends IService<Service_ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Service_ProjectVO> selectListVO(Wrapper<Service_ProjectEntity> wrapper);
   	
   	Service_ProjectVO selectVO(@Param("ew") Wrapper<Service_ProjectEntity> wrapper);
   	
   	List<Service_ProjectView> selectListView(Wrapper<Service_ProjectEntity> wrapper);
   	
   	Service_ProjectView selectView(@Param("ew") Wrapper<Service_ProjectEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Service_ProjectEntity> wrapper);
   	

}

