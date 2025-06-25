package com.dao;

import com.entity.Service_Project_CommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Service_Project_CommentVO;
import com.entity.view.Service_Project_CommentView;


/**
 * 服务项目评论表
 * 
 * @author 
 * @email 
 * @date 2025-6-13 19:23:55
 */
public interface Service_Project_CommentDao extends BaseMapper<Service_Project_CommentEntity> {
	
	List<Service_Project_CommentVO> selectListVO(@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);
	
	Service_Project_CommentVO selectVO(@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);
	
	List<Service_Project_CommentView> selectListView(@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);

	List<Service_Project_CommentView> selectListView(Pagination page,@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);
	
	Service_Project_CommentView selectView(@Param("ew") Wrapper<Service_Project_CommentEntity> wrapper);
	

}
