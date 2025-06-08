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


import com.dao.Service_AppointmentDao;
import com.entity.Service_AppointmentEntity;
import com.service.Service_AppointmentService;
import com.entity.vo.Service_AppointmentVO;
import com.entity.view.Service_AppointmentView;

@Service("service_appointmentService")
public class Service_AppointmentServiceImpl extends ServiceImpl<Service_AppointmentDao, Service_AppointmentEntity> implements Service_AppointmentService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Service_AppointmentEntity> page = this.selectPage(
                new Query<Service_AppointmentEntity>(params).getPage(),
                new EntityWrapper<Service_AppointmentEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Service_AppointmentEntity> wrapper) {
		  Page<Service_AppointmentView> page =new Query<Service_AppointmentView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Service_AppointmentVO> selectListVO(Wrapper<Service_AppointmentEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Service_AppointmentVO selectVO(Wrapper<Service_AppointmentEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Service_AppointmentView> selectListView(Wrapper<Service_AppointmentEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Service_AppointmentView selectView(Wrapper<Service_AppointmentEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<Service_AppointmentEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<Service_AppointmentEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<Service_AppointmentEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
