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

import com.entity.Service_Project_CommentEntity;
import com.entity.view.Service_Project_CommentView;

import com.service.Service_Project_CommentService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;


//   服务项目评论表
//   后端接口

@RestController
@RequestMapping(value = {"/service_project_comment","/discussservice_project"})
public class Service_Project_CommentController {
    @Autowired
    private Service_Project_CommentService service_project_commentService;



    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,Service_Project_CommentEntity service_project_comment,
		HttpServletRequest request){
        EntityWrapper<Service_Project_CommentEntity> ew = new EntityWrapper<Service_Project_CommentEntity>();
		PageUtils page = service_project_commentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, service_project_comment), params), params));

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Service_Project_CommentEntity service_project_comment,
		HttpServletRequest request){
        EntityWrapper<Service_Project_CommentEntity> ew = new EntityWrapper<Service_Project_CommentEntity>();
		PageUtils page = service_project_commentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, service_project_comment), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R list( Service_Project_CommentEntity service_project_comment){
       	EntityWrapper<Service_Project_CommentEntity> ew = new EntityWrapper<Service_Project_CommentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( service_project_comment, "service_project_comment")); 
        return R.ok().put("data", service_project_commentService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(Service_Project_CommentEntity service_project_comment){
        EntityWrapper< Service_Project_CommentEntity> ew = new EntityWrapper< Service_Project_CommentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( service_project_comment, "service_project_comment")); 
		Service_Project_CommentView service_project_commentView =  service_project_commentService.selectView(ew);
		return R.ok("查询服务项目评论表成功").put("data", service_project_commentView);
    }
	

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Service_Project_CommentEntity service_project_comment = service_project_commentService.selectById(id);
        return R.ok().put("data", service_project_comment);
    }

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Service_Project_CommentEntity service_project_comment = service_project_commentService.selectById(id);
        return R.ok().put("data", service_project_comment);
    }
    

    @RequestMapping("/save")
    public R save(@RequestBody Service_Project_CommentEntity service_project_comment, HttpServletRequest request){
    	service_project_comment.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());

        service_project_commentService.insert(service_project_comment);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody Service_Project_CommentEntity service_project_comment, HttpServletRequest request){
    	service_project_comment.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());

        service_project_commentService.insert(service_project_comment);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody Service_Project_CommentEntity service_project_comment, HttpServletRequest request){

        service_project_commentService.updateById(service_project_comment);//全部更新
        return R.ok();
    }
    

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        service_project_commentService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Service_Project_CommentEntity> wrapper = new EntityWrapper<Service_Project_CommentEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = service_project_commentService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
