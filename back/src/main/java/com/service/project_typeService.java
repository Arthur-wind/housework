package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.project_typeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.project_typeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.project_typeView;


/**
 * 项目类型
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface project_typeService extends IService<project_typeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<project_typeVO> selectListVO(Wrapper<project_typeEntity> wrapper);
   	
   	project_typeVO selectVO(@Param("ew") Wrapper<project_typeEntity> wrapper);
   	
   	List<project_typeView> selectListView(Wrapper<project_typeEntity> wrapper);
   	
   	project_typeView selectView(@Param("ew") Wrapper<project_typeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<project_typeEntity> wrapper);
   	

}

