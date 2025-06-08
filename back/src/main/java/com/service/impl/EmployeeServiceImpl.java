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


import com.dao.EmployeeDao;
import com.entity.EmployeeEntity;
import com.service.EmployeeService;
import com.entity.vo.EmployeeVO;
import com.entity.view.EmployeeView;

@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EmployeeEntity> page = this.selectPage(
                new Query<EmployeeEntity>(params).getPage(),
                new EntityWrapper<EmployeeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EmployeeEntity> wrapper) {
		  Page<EmployeeView> page =new Query<EmployeeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<EmployeeVO> selectListVO(Wrapper<EmployeeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EmployeeVO selectVO(Wrapper<EmployeeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EmployeeView> selectListView(Wrapper<EmployeeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EmployeeView selectView(Wrapper<EmployeeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
