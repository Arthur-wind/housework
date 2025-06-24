package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.project_typeEntity;
import com.entity.view.project_typeView;

import com.service.project_typeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;


//  项目类型

@RestController
@RequestMapping("/project_type")
public class project_typeController {
    @Autowired
    private project_typeService project_typeService;


    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,project_typeEntity project_type,
        HttpServletRequest request){

        if(params.containsKey("project_type")) {
            project_type.setProjectType((String)params.get("project_type"));
        }
        EntityWrapper<project_typeEntity> ew = new EntityWrapper<project_typeEntity>();
        PageUtils page = project_typeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, project_type), params), params));

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,project_typeEntity project_type, 
		HttpServletRequest request){

        if(params.containsKey("project_type")) {
            project_type.setProjectType((String)params.get("project_type"));
        }
        EntityWrapper<project_typeEntity> ew = new EntityWrapper<project_typeEntity>();
		PageUtils page = project_typeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, project_type), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( project_typeEntity project_type){
       	EntityWrapper<project_typeEntity> ew = new EntityWrapper<project_typeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( project_type, "project_type")); 
        return R.ok().put("data", project_typeService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(project_typeEntity project_type){
        EntityWrapper< project_typeEntity> ew = new EntityWrapper< project_typeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( project_type, "project_type")); 
		project_typeView project_typeView =  project_typeService.selectView(ew);
		return R.ok("查询项目类型成功").put("data", project_typeView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        project_typeEntity project_type = project_typeService.selectById(id);
        return R.ok().put("data", project_type);
    }


	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        project_typeEntity project_type = project_typeService.selectById(id);
        return R.ok().put("data", project_type);
    }
    

    @RequestMapping("/save")
    public R save(@RequestBody project_typeEntity project_type, HttpServletRequest request){
        project_type.setId(System.currentTimeMillis() + (long)(Math.random() * 1000));


        project_typeService.insert(project_type);
        return R.ok();
    }
    

    @RequestMapping("/add")
    public R add(@RequestBody project_typeEntity project_type, HttpServletRequest request){
        project_type.setId(System.currentTimeMillis() + (long)(Math.random() * 1000));


        project_typeService.insert(project_type);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody project_typeEntity project_type, HttpServletRequest request){

        project_typeService.updateById(project_type);
        return R.ok();
    }
    

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        project_typeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<project_typeEntity> wrapper = new EntityWrapper<project_typeEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = project_typeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
