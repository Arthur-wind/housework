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


import com.dao.Application_AppointmentDao;
import com.entity.Application_AppointmentEntity;
import com.service.Application_AppointmentService;
import com.entity.vo.Application_AppointmentVO;
import com.entity.view.Application_AppointmentView;

@Service("application_appointmentService")
public class Application_AppointmentServiceImpl extends ServiceImpl<Application_AppointmentDao, Application_AppointmentEntity> implements Application_AppointmentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Application_AppointmentEntity> page = this.selectPage(
                new Query<Application_AppointmentEntity>(params).getPage(),
                new EntityWrapper<Application_AppointmentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Application_AppointmentEntity> wrapper) {
		  Page<Application_AppointmentView> page =new Query<Application_AppointmentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Application_AppointmentVO> selectListVO(Wrapper<Application_AppointmentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Application_AppointmentVO selectVO(Wrapper<Application_AppointmentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Application_AppointmentView> selectListView(Wrapper<Application_AppointmentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Application_AppointmentView selectView(Wrapper<Application_AppointmentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<Application_AppointmentEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<Application_AppointmentEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<Application_AppointmentEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
