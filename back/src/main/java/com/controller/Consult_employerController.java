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

import com.entity.Consult_EmployeeEntity;
import com.entity.Employer_evaluationEntity;
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

import com.entity.Consult_employerEntity;
import com.entity.view.Consult_employerView;

import com.service.Consult_employerService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询雇主
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/consult_employer")
public class Consult_employerController {
    @Autowired
    private Consult_employerService consult_employerService;





    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,
                  Consult_employerEntity consult_employer,
                  HttpServletRequest request) {

        // 1. 从session获取当前用户信息
        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = (String) request.getSession().getAttribute("username");

        // 2. 根据用户类型设置隔离条件
        EntityWrapper<Consult_employerEntity> ew = new EntityWrapper<>();

        if ("employer".equals(tableName)) {
            // 雇主只能查看自己发布的需求
            ew.eq("employer_account", username);
        }
        else if ("employee".equals(tableName)) {
            // 雇员可能查看所有需求，或按业务需要添加限制
             ew.eq("employee_account", username); // 如果需要限制雇员查看范围
        }

        // 3. 添加查询条件（安全方式）
        if (params.containsKey("work_location") && !params.get("work_location").toString().isEmpty()) {
            ew.like("work_location", params.get("work_location").toString());
        }
        if (params.containsKey("project_name") && !params.get("project_name").toString().isEmpty()) {
            ew.like("project_name", params.get("project_name").toString());
        }
        if (params.containsKey("employer_name") && !params.get("employer_name").toString().isEmpty()) {
            ew.like("employer_name", params.get("employer_name").toString());
        }
        if (params.containsKey("employee_name") && !params.get("employee_name").toString().isEmpty()) {
            ew.like("employee_name", params.get("employee_name").toString());
        }

        // 4. 执行查询

        PageUtils page = consult_employerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, consult_employer), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Consult_employerEntity consult_employer, 
		HttpServletRequest request){
        // 手动处理雇主姓名、雇员姓名、是否审核映射
        if(params.containsKey("employer_name")) {
            consult_employer.setEmployerName((String)params.get("employer_name"));
        }
        if(params.containsKey("employee_name")) {
            consult_employer.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.containsKey("is_reviewed")) {
            consult_employer.setIsReviewed((String)params.get("is_reviewed"));
        }
        EntityWrapper<Consult_employerEntity> ew = new EntityWrapper<Consult_employerEntity>();
		PageUtils page = consult_employerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, consult_employer), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Consult_employerEntity consult_employer){
       	EntityWrapper<Consult_employerEntity> ew = new EntityWrapper<Consult_employerEntity>();
      	ew.allEq(MPUtil.allEQMapPre( consult_employer, "consult_employer")); 
        return R.ok().put("data", consult_employerService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Consult_employerEntity consult_employer){
        EntityWrapper< Consult_employerEntity> ew = new EntityWrapper< Consult_employerEntity>();
 		ew.allEq(MPUtil.allEQMapPre( consult_employer, "consult_employer")); 
		Consult_employerView consult_employerView =  consult_employerService.selectView(ew);
		return R.ok("查询咨询雇主成功").put("data", consult_employerView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Consult_employerEntity consult_employer = consult_employerService.selectById(id);
        return R.ok().put("data", consult_employer);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Consult_employerEntity consult_employer = consult_employerService.selectById(id);
        return R.ok().put("data", consult_employer);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Consult_employerEntity consult_employer, HttpServletRequest request){
consult_employer.setId(System.currentTimeMillis() + (long)(Math.random() * 1000));

    	//ValidatorUtils.validateEntity(consult_employer);
        consult_employerService.insert(consult_employer);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Consult_employerEntity consult_employer, HttpServletRequest request){
consult_employer.setId(System.currentTimeMillis() + (long)(Math.random() * 1000));

    	//ValidatorUtils.validateEntity(consult_employer);
        consult_employerService.insert(consult_employer);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Consult_employerEntity consult_employer, HttpServletRequest request){
        //ValidatorUtils.validateEntity(consult_employer);
        consult_employerService.updateById(consult_employer);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        consult_employerService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Consult_employerEntity> wrapper = new EntityWrapper<Consult_employerEntity>();
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
		if(tableName.equals("employer")) {
			wrapper.eq("employer_account", (String)request.getSession().getAttribute("username"));
		}

		int count = consult_employerService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
