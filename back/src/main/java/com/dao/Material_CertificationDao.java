package com.dao;

import com.entity.Material_CertificationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.Material_CertificationVO;
import com.entity.view.Material_CertificationView;


/**
 * 资料认证
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Material_CertificationDao extends BaseMapper<Material_CertificationEntity> {
	
	List<Material_CertificationVO> selectListVO(@Param("ew") Wrapper<Material_CertificationEntity> wrapper);
	
	Material_CertificationVO selectVO(@Param("ew") Wrapper<Material_CertificationEntity> wrapper);
	
	List<Material_CertificationView> selectListView(@Param("ew") Wrapper<Material_CertificationEntity> wrapper);

	List<Material_CertificationView> selectListView(Pagination page,@Param("ew") Wrapper<Material_CertificationEntity> wrapper);
	
	Material_CertificationView selectView(@Param("ew") Wrapper<Material_CertificationEntity> wrapper);
	

}
