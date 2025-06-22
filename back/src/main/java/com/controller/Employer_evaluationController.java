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

import com.entity.Contract_SigningEntity;
import com.entity.Electronic_SignatureEntity;
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

import com.entity.Employer_evaluationEntity;
import com.entity.view.Employer_evaluationView;

import com.service.Employer_evaluationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 雇主评价
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/employer_evaluation")
public class Employer_evaluationController {
    @Autowired
    private Employer_evaluationService employer_evaluationService;


    


    /**
     * 后端列表
     */
//    @RequestMapping("/page")
//    public R page(@RequestParam Map<String, Object> params,Employer_evaluationEntity employer_evaluation,
//        HttpServletRequest request){
//        // 手动处理映射
//        if(params.containsKey("project_name")) {
//            employer_evaluation.setProjectName((String)params.get("project_name"));
//        }
//        if(params.containsKey("employer_name")) {
//            employer_evaluation.setEmployerName((String)params.get("employer_name"));
//        }
//        if(params.containsKey("employee_name")) {
//            employer_evaluation.setEmployeeName((String)params.get("employee_name"));
//        }
//        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("employer")) {
//            employer_evaluation.setEmployer_account((String)request.getSession().getAttribute("username"));
//        }
//        if(tableName.equals("employee")) {
//            employer_evaluation.setEmployee_account((String)request.getSession().getAttribute("username"));
//        }
//        EntityWrapper<Employer_evaluationEntity> ew = new EntityWrapper<Employer_evaluationEntity>();
//        PageUtils page = employer_evaluationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employer_evaluation), params), params));
//
//        return R.ok().put("data", page);
//    }
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,
                  Employer_evaluationEntity employer_evaluation,
                  HttpServletRequest request) {

        // 1. 从 session 获取用户身份信息
        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = (String) request.getSession().getAttribute("username");

        // 2. 创建查询包装器
        EntityWrapper<Employer_evaluationEntity> ew = new EntityWrapper<>();

        // 3. 根据用户类型添加数据隔离条件
        if ("employer".equals(tableName)) {
            ew.eq("employer_account", username);  // 雇主只能看到自己的签名
        } else if ("employee".equals(tableName)) {
            ew.eq("employee_account", username);  // 雇员只能看到自己的签名
        }

        // 4. 添加前端查询参数（安全过滤）
        if (params.containsKey("project_name") && !params.get("project_name").toString().isEmpty()) {
            ew.like("project_name", params.get("project_name").toString());
        }
        if (params.containsKey("employer_name") && !params.get("employer_name").toString().isEmpty()) {
            ew.like("employer_name", params.get("employer_name").toString());
        }
        if (params.containsKey("employee_name") && !params.get("employee_name").toString().isEmpty()) {
            ew.like("employee_name", params.get("employee_name").toString());
        }

        // 5. 执行分页查询

        PageUtils page = employer_evaluationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employer_evaluation), params), params));




        return R.ok().put("data", page);
    }
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Employer_evaluationEntity employer_evaluation,
		HttpServletRequest request){
        // 手动处理映射
        if(params.containsKey("project_name")) {
            employer_evaluation.setProjectName((String)params.get("project_name"));
        }
        if(params.containsKey("employer_name")) {
            employer_evaluation.setEmployerName((String)params.get("employer_name"));
        }
        if(params.containsKey("employee_name")) {
            employer_evaluation.setEmployeeName((String)params.get("employee_name"));
        }
        EntityWrapper<Employer_evaluationEntity> ew = new EntityWrapper<Employer_evaluationEntity>();
		PageUtils page = employer_evaluationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employer_evaluation), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Employer_evaluationEntity employer_evaluation){
       	EntityWrapper<Employer_evaluationEntity> ew = new EntityWrapper<Employer_evaluationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( employer_evaluation, "employer_evaluation")); 
        return R.ok().put("data", employer_evaluationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Employer_evaluationEntity employer_evaluation){
        EntityWrapper< Employer_evaluationEntity> ew = new EntityWrapper< Employer_evaluationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( employer_evaluation, "employer_evaluation")); 
		Employer_evaluationView employer_evaluationView =  employer_evaluationService.selectView(ew);
		return R.ok("查询雇主评价成功").put("data", employer_evaluationView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Employer_evaluationEntity employer_evaluation = employer_evaluationService.selectById(id);
        return R.ok().put("data", employer_evaluation);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Employer_evaluationEntity employer_evaluation = employer_evaluationService.selectById(id);
        return R.ok().put("data", employer_evaluation);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Employer_evaluationEntity employer_evaluation, HttpServletRequest request){
    	employer_evaluation.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(employer_evaluation);
        employer_evaluationService.insert(employer_evaluation);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Employer_evaluationEntity employer_evaluation, HttpServletRequest request){
    	employer_evaluation.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(employer_evaluation);
        employer_evaluationService.insert(employer_evaluation);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Employer_evaluationEntity employer_evaluation, HttpServletRequest request){
        //ValidatorUtils.validateEntity(employer_evaluation);
        employer_evaluationService.updateById(employer_evaluation);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        employer_evaluationService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Employer_evaluationEntity> wrapper = new EntityWrapper<Employer_evaluationEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("employer")) {
			wrapper.eq("employer_account", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("employee")) {
			wrapper.eq("employee_account", (String)request.getSession().getAttribute("username"));
		}

		int count = employer_evaluationService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
