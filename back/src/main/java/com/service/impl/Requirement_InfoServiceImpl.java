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


import com.dao.Requirement_InfoDao;
import com.entity.Requirement_InfoEntity;
import com.service.Requirement_InfoService;
import com.entity.vo.Requirement_InfoVO;
import com.entity.view.Requirement_InfoView;

@Service("requirement_infoService")
public class Requirement_InfoServiceImpl extends ServiceImpl<Requirement_InfoDao, Requirement_InfoEntity> implements Requirement_InfoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Requirement_InfoEntity> page = this.selectPage(
                new Query<Requirement_InfoEntity>(params).getPage(),
                new EntityWrapper<Requirement_InfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Requirement_InfoEntity> wrapper) {
		  Page<Requirement_InfoView> page =new Query<Requirement_InfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Requirement_InfoVO> selectListVO(Wrapper<Requirement_InfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Requirement_InfoVO selectVO(Wrapper<Requirement_InfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Requirement_InfoView> selectListView(Wrapper<Requirement_InfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Requirement_InfoView selectView(Wrapper<Requirement_InfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
