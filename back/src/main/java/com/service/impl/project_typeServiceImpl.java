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


import com.dao.project_typeDao;
import com.entity.project_typeEntity;
import com.service.project_typeService;
import com.entity.vo.project_typeVO;
import com.entity.view.project_typeView;

@Service("project_typeService")
public class project_typeServiceImpl extends ServiceImpl<project_typeDao, project_typeEntity> implements project_typeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<project_typeEntity> page = this.selectPage(
                new Query<project_typeEntity>(params).getPage(),
                new EntityWrapper<project_typeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<project_typeEntity> wrapper) {
		  Page<project_typeView> page =new Query<project_typeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<project_typeVO> selectListVO(Wrapper<project_typeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public project_typeVO selectVO(Wrapper<project_typeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<project_typeView> selectListView(Wrapper<project_typeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public project_typeView selectView(Wrapper<project_typeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
