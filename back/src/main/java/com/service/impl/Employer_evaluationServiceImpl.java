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


import com.dao.Employer_evaluationDao;
import com.entity.Employer_evaluationEntity;
import com.service.Employer_evaluationService;
import com.entity.vo.Employer_evaluationVO;
import com.entity.view.Employer_evaluationView;

@Service("employer_evaluationService")
public class Employer_evaluationServiceImpl extends ServiceImpl<Employer_evaluationDao, Employer_evaluationEntity> implements Employer_evaluationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Employer_evaluationEntity> page = this.selectPage(
                new Query<Employer_evaluationEntity>(params).getPage(),
                new EntityWrapper<Employer_evaluationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Employer_evaluationEntity> wrapper) {
		  Page<Employer_evaluationView> page =new Query<Employer_evaluationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Employer_evaluationVO> selectListVO(Wrapper<Employer_evaluationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Employer_evaluationVO selectVO(Wrapper<Employer_evaluationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Employer_evaluationView> selectListView(Wrapper<Employer_evaluationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Employer_evaluationView selectView(Wrapper<Employer_evaluationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
