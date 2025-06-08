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


import com.dao.Contract_SigningDao;
import com.entity.Contract_SigningEntity;
import com.service.Contract_SigningService;
import com.entity.vo.Contract_SigningVO;
import com.entity.view.Contract_SigningView;

@Service("contract_signingService")
public class Contract_SigningServiceImpl extends ServiceImpl<Contract_SigningDao, Contract_SigningEntity> implements Contract_SigningService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Contract_SigningEntity> page = this.selectPage(
                new Query<Contract_SigningEntity>(params).getPage(),
                new EntityWrapper<Contract_SigningEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Contract_SigningEntity> wrapper) {
		  Page<Contract_SigningView> page =new Query<Contract_SigningView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Contract_SigningVO> selectListVO(Wrapper<Contract_SigningEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Contract_SigningVO selectVO(Wrapper<Contract_SigningEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Contract_SigningView> selectListView(Wrapper<Contract_SigningEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Contract_SigningView selectView(Wrapper<Contract_SigningEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
