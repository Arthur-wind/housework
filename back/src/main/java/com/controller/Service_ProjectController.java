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

import com.entity.Service_ProjectEntity;
import com.entity.view.Service_ProjectView;

import com.service.Service_ProjectService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 服务项目
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/service_project")
public class Service_ProjectController {
    @Autowired
    private Service_ProjectService service_projectService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,Service_ProjectEntity service_project,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("employee")) {
			service_project.setEmployee_Account((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<Service_ProjectEntity> ew = new EntityWrapper<Service_ProjectEntity>();
		PageUtils page = service_projectService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, service_project), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Service_ProjectEntity service_project, 
		HttpServletRequest request){
        EntityWrapper<Service_ProjectEntity> ew = new EntityWrapper<Service_ProjectEntity>();
		PageUtils page = service_projectService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, service_project), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Service_ProjectEntity service_project){
       	EntityWrapper<Service_ProjectEntity> ew = new EntityWrapper<Service_ProjectEntity>();
      	ew.allEq(MPUtil.allEQMapPre( service_project, "service_project")); 
        return R.ok().put("data", service_projectService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Service_ProjectEntity service_project){
        EntityWrapper< Service_ProjectEntity> ew = new EntityWrapper< Service_ProjectEntity>();
 		ew.allEq(MPUtil.allEQMapPre( service_project, "service_project")); 
		Service_ProjectView service_projectView =  service_projectService.selectView(ew);
		return R.ok("查询服务项目成功").put("data", service_projectView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Service_ProjectEntity service_project = service_projectService.selectById(id);
		service_project.setClick_Count(service_project.getClick_Count()+1);
		service_project.setLast_Click_Time(new Date());
		service_projectService.updateById(service_project);
        return R.ok().put("data", service_project);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Service_ProjectEntity service_project = service_projectService.selectById(id);
		service_project.setClick_Count(service_project.getClick_Count()+1);
		service_project.setLast_Click_Time(new Date());
		service_projectService.updateById(service_project);
        return R.ok().put("data", service_project);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        Service_ProjectEntity service_project = service_projectService.selectById(id);
        if(type.equals("1")) {
        	service_project.setThumbs_Up(service_project.getThumbs_Up()+1);
        } else {
        	service_project.setThumbs_Down(service_project.getThumbs_Down()+1);
        }
        service_projectService.updateById(service_project);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Service_ProjectEntity service_project, HttpServletRequest request){
    	service_project.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(service_project);
        service_projectService.insert(service_project);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Service_ProjectEntity service_project, HttpServletRequest request){
    	service_project.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(service_project);
        service_projectService.insert(service_project);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Service_ProjectEntity service_project, HttpServletRequest request){
        //ValidatorUtils.validateEntity(service_project);
        service_projectService.updateById(service_project);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        service_projectService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
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
		
		Wrapper<Service_ProjectEntity> wrapper = new EntityWrapper<Service_ProjectEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("employee")) {
			wrapper.eq("employee_account", (String)request.getSession().getAttribute("username"));
		}

		int count = service_projectService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,Service_ProjectEntity service_project, HttpServletRequest request,String pre){
        EntityWrapper<Service_ProjectEntity> ew = new EntityWrapper<Service_ProjectEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "click_count");
        params.put("order", "desc");
		PageUtils page = service_projectService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, service_project), params), params));
        return R.ok().put("data", page);
    }







}
