package com.dao;

import com.entity.Electronic_SignatureEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.electronic_signatureVO;
import com.entity.view.Electronic_SignatureView;


/**
 * 电子签名
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Electronic_SignatureDao extends BaseMapper<Electronic_SignatureEntity> {
	
	List<electronic_signatureVO> selectListVO(@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);
	
	electronic_signatureVO selectVO(@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);
	
	List<Electronic_SignatureView> selectListView(@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);

	List<Electronic_SignatureView> selectListView(Pagination page,@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);
	
	Electronic_SignatureView selectView(@Param("ew") Wrapper<Electronic_SignatureEntity> wrapper);
	

}
