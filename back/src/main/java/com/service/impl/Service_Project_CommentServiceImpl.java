package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.Service_Project_CommentDao;
import com.entity.Service_Project_CommentEntity;
import com.service.Service_Project_CommentService;
import com.entity.vo.Service_Project_CommentVO;
import com.entity.view.Service_Project_CommentView;

@Service("service_project_commentService")
public class Service_Project_CommentServiceImpl extends ServiceImpl<Service_Project_CommentDao, Service_Project_CommentEntity> implements Service_Project_CommentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Service_Project_CommentEntity> page = this.selectPage(
                new Query<Service_Project_CommentEntity>(params).getPage(),
                new EntityWrapper<Service_Project_CommentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Service_Project_CommentEntity> wrapper) {
		  Page<Service_Project_CommentView> page =new Query<Service_Project_CommentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Service_Project_CommentVO> selectListVO(Wrapper<Service_Project_CommentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Service_Project_CommentVO selectVO(Wrapper<Service_Project_CommentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Service_Project_CommentView> selectListView(Wrapper<Service_Project_CommentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Service_Project_CommentView selectView(Wrapper<Service_Project_CommentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
