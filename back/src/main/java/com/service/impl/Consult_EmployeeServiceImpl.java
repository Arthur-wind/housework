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


import com.dao.Consult_EmployeeDao;
import com.entity.Consult_EmployeeEntity;
import com.service.Consult_EmployeeService;
import com.entity.vo.Consult_EmployeeVO;
import com.entity.view.Consult_EmployeeView;

@Service("consult_employeeService")
public class Consult_EmployeeServiceImpl extends ServiceImpl<Consult_EmployeeDao, Consult_EmployeeEntity> implements Consult_EmployeeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Consult_EmployeeEntity> page = this.selectPage(
                new Query<Consult_EmployeeEntity>(params).getPage(),
                new EntityWrapper<Consult_EmployeeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Consult_EmployeeEntity> wrapper) {
		  Page<Consult_EmployeeView> page =new Query<Consult_EmployeeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Consult_EmployeeVO> selectListVO(Wrapper<Consult_EmployeeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Consult_EmployeeVO selectVO(Wrapper<Consult_EmployeeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Consult_EmployeeView> selectListView(Wrapper<Consult_EmployeeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Consult_EmployeeView selectView(Wrapper<Consult_EmployeeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
