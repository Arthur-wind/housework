package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Requirement_InfoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Requirement_InfoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Requirement_InfoView;


/**
 * 需求信息
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Requirement_InfoService extends IService<Requirement_InfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Requirement_InfoVO> selectListVO(Wrapper<Requirement_InfoEntity> wrapper);
   	
   	Requirement_InfoVO selectVO(@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);
   	
   	List<Requirement_InfoView> selectListView(Wrapper<Requirement_InfoEntity> wrapper);
   	
   	Requirement_InfoView selectView(@Param("ew") Wrapper<Requirement_InfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Requirement_InfoEntity> wrapper);
   	

}

