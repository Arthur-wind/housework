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


import com.dao.EmployerDao;
import com.entity.EmployerEntity;
import com.service.EmployerService;
import com.entity.vo.EmployerVO;
import com.entity.view.EmployerView;

@Service("employerService")
public class EmployerServiceImpl extends ServiceImpl<EmployerDao, EmployerEntity> implements EmployerService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EmployerEntity> page = this.selectPage(
                new Query<EmployerEntity>(params).getPage(),
                new EntityWrapper<EmployerEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EmployerEntity> wrapper) {
		  Page<EmployerView> page =new Query<EmployerView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<EmployerVO> selectListVO(Wrapper<EmployerEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EmployerVO selectVO(Wrapper<EmployerEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EmployerView> selectListView(Wrapper<EmployerEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EmployerView selectView(Wrapper<EmployerEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
