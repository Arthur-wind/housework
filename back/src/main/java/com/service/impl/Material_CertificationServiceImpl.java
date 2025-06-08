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


import com.dao.Material_CertificationDao;
import com.entity.Material_CertificationEntity;
import com.service.Material_CertificationService;
import com.entity.vo.Material_CertificationVO;
import com.entity.view.Material_CertificationView;

@Service("material_certificationService")
public class Material_CertificationServiceImpl extends ServiceImpl<Material_CertificationDao, Material_CertificationEntity> implements Material_CertificationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Material_CertificationEntity> page = this.selectPage(
                new Query<Material_CertificationEntity>(params).getPage(),
                new EntityWrapper<Material_CertificationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<Material_CertificationEntity> wrapper) {
		  Page<Material_CertificationView> page =new Query<Material_CertificationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<Material_CertificationVO> selectListVO(Wrapper<Material_CertificationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public Material_CertificationVO selectVO(Wrapper<Material_CertificationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<Material_CertificationView> selectListView(Wrapper<Material_CertificationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public Material_CertificationView selectView(Wrapper<Material_CertificationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
