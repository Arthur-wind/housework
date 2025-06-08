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


import com.dao.Consult_employerDao;
import com.entity.Consult_employerEntity;
import com.service.Consult_employerService;
import com.entity.vo.Consult_employerVO;
import com.entity.view.Consult_employerView;

@Service("consult_employerService")
public class Consult_employerServiceImpl extends ServiceImpl<Consult_employerDao, Consult_employerEntity> implements Consult_employerService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Consult_employerEntity> page = this.selectPage(
                new Query<Consult_employerEntity>(params).getPage(),
                new EntityWrapper<Consult_employerEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Consult_employerEntity> wrapper) {
		  Page<Consult_employerView> page =new Query<Consult_employerView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Consult_employerVO> selectListVO(Wrapper<Consult_employerEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Consult_employerVO selectVO(Wrapper<Consult_employerEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Consult_employerView> selectListView(Wrapper<Consult_employerEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Consult_employerView selectView(Wrapper<Consult_employerEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
