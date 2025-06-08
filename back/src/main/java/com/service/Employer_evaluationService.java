package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.Employer_evaluationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.Employer_evaluationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.Employer_evaluationView;


/**
 * 雇主评价
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface Employer_evaluationService extends IService<Employer_evaluationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<Employer_evaluationVO> selectListVO(Wrapper<Employer_evaluationEntity> wrapper);
   	
   	Employer_evaluationVO selectVO(@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);
   	
   	List<Employer_evaluationView> selectListView(Wrapper<Employer_evaluationEntity> wrapper);
   	
   	Employer_evaluationView selectView(@Param("ew") Wrapper<Employer_evaluationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<Employer_evaluationEntity> wrapper);
   	

}

