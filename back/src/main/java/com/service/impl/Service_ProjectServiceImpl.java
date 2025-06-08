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


import com.dao.Service_ProjectDao;
import com.entity.Service_ProjectEntity;
import com.service.Service_ProjectService;
import com.entity.vo.Service_ProjectVO;
import com.entity.view.Service_ProjectView;

@Service("service_projectService")
public class Service_ProjectServiceImpl extends ServiceImpl<Service_ProjectDao, Service_ProjectEntity> implements Service_ProjectService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Service_ProjectEntity> page = this.selectPage(
                new Query<Service_ProjectEntity>(params).getPage(),
                new EntityWrapper<Service_ProjectEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Service_ProjectEntity> wrapper) {
		  Page<Service_ProjectView> page =new Query<Service_ProjectView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Service_ProjectVO> selectListVO(Wrapper<Service_ProjectEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Service_ProjectVO selectVO(Wrapper<Service_ProjectEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Service_ProjectView> selectListView(Wrapper<Service_ProjectEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Service_ProjectView selectView(Wrapper<Service_ProjectEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
