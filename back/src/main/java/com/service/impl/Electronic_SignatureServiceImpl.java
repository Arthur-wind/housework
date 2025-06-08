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


import com.dao.Electronic_SignatureDao;
import com.entity.Electronic_SignatureEntity;
import com.service.Electronic_SignatureService;
import com.entity.vo.electronic_signatureVO;
import com.entity.view.Electronic_SignatureView;

@Service("electronic_signatureService")
public class Electronic_SignatureServiceImpl extends ServiceImpl<Electronic_SignatureDao, Electronic_SignatureEntity> implements Electronic_SignatureService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Electronic_SignatureEntity> page = this.selectPage(
                new Query<Electronic_SignatureEntity>(params).getPage(),
                new EntityWrapper<Electronic_SignatureEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Electronic_SignatureEntity> wrapper) {
		  Page<Electronic_SignatureView> page =new Query<Electronic_SignatureView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<electronic_signatureVO> selectListVO(Wrapper<Electronic_SignatureEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public electronic_signatureVO selectVO(Wrapper<Electronic_SignatureEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Electronic_SignatureView> selectListView(Wrapper<Electronic_SignatureEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Electronic_SignatureView selectView(Wrapper<Electronic_SignatureEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
