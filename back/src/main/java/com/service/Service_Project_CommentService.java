package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Service_Project_CommentEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Service_Project_CommentVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Service_Project_CommentView;


/**
 * 服务项目评论表
 *
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Service_Project_CommentService extends IService<Service_Project_CommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Service_Project_CommentVO> selectListVO(Wrapper<Service_Project_CommentEntity> wrapper);
   	
   	Service_Project_CommentVO selectVO(@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);
   	
   	List<Service_Project_CommentView> selectListView(Wrapper<Service_Project_CommentEntity> wrapper);
   	
   	Service_Project_CommentView selectView(@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Service_Project_CommentEntity> wrapper);
   	

}

