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

import com.utils.*;
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

import com.entity.Service_AppointmentEntity;
import com.entity.view.Service_AppointmentView;

import com.service.Service_AppointmentService;
import com.service.TokenService;

import java.io.IOException;

/**
 * 服务预约
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/service_appointment")
public class Service_AppointmentController {
    @Autowired
    private Service_AppointmentService service_appointmentService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,
                  Service_AppointmentEntity service_appointment,
                  HttpServletRequest request) {

        // 从后端Session获取当前登录用户信息，实现安全隔离
        String tableName = (String) request.getSession().getAttribute("tableName");
        String username = (String) request.getSession().getAttribute("username");

        if(tableName == null || username == null) {
            return R.error("未登录或登录信息失效");
        }

        EntityWrapper<Service_AppointmentEntity> ew = new EntityWrapper<>();

        // 数据隔离，确保用户只看到自己相关数据
        if ("guzhu".equalsIgnoreCase(tableName) || "employer".equalsIgnoreCase(tableName)) {
            ew.eq("employer_account", username);
        } else if ("guyuan".equalsIgnoreCase(tableName) || "employee".equalsIgnoreCase(tableName)) {
            ew.eq("employee_account", username);
        } else {
            // 管理员等角色可见全部或根据需求增加其它判断
        }

        // 其他查询条件
        if (StringUtils.isNotBlank(service_appointment.getProjectName())) {
            ew.like("project_name", service_appointment.getProjectName());
        }
        if (StringUtils.isNotBlank(service_appointment.getEmployerName())) {
            ew.like("employer_name", service_appointment.getEmployerName());
        }
        if (StringUtils.isNotBlank(service_appointment.getEmployeeName())) {
            ew.like("employee_name", service_appointment.getEmployeeName());
        }
        if (StringUtils.isNotBlank(service_appointment.getIsReviewed())) {
            ew.eq("is_reviewed", service_appointment.getIsReviewed());
        }

        PageUtils page = service_appointmentService.queryPage(params, ew);

        return R.ok().put("data", page);
    }


    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Service_AppointmentEntity service_appointment, 
		HttpServletRequest request){
        // 手动处理映射
        if(params.containsKey("project_name")) {
            service_appointment.setProjectName((String)params.get("project_name"));
        }
        if(params.containsKey("employer_name")) {
            service_appointment.setEmployerName((String)params.get("employer_name"));
        }
        if(params.containsKey("employee_name")) {
            service_appointment.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.containsKey("is_reviewed")) {
            service_appointment.setIsReviewed((String)params.get("is_reviewed"));
        }
        EntityWrapper<Service_AppointmentEntity> ew = new EntityWrapper<Service_AppointmentEntity>();
		PageUtils page = service_appointmentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, service_appointment), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Service_AppointmentEntity service_appointment){
       	EntityWrapper<Service_AppointmentEntity> ew = new EntityWrapper<Service_AppointmentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( service_appointment, "service_appointment")); 
        return R.ok().put("data", service_appointmentService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Service_AppointmentEntity service_appointment){
        EntityWrapper< Service_AppointmentEntity> ew = new EntityWrapper< Service_AppointmentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( service_appointment, "service_appointment")); 
		Service_AppointmentView service_appointmentView =  service_appointmentService.selectView(ew);
		return R.ok("查询服务预约成功").put("data", service_appointmentView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Service_AppointmentEntity service_appointment = service_appointmentService.selectById(id);
        return R.ok().put("data", service_appointment);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Service_AppointmentEntity service_appointment = service_appointmentService.selectById(id);
        return R.ok().put("data", service_appointment);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Service_AppointmentEntity service_appointment, HttpServletRequest request){
    	service_appointment.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(service_appointment);
        service_appointmentService.insert(service_appointment);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Service_AppointmentEntity service_appointment, HttpServletRequest request){
    	service_appointment.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(service_appointment);
        service_appointmentService.insert(service_appointment);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Service_AppointmentEntity service_appointment, HttpServletRequest request){
        //ValidatorUtils.validateEntity(service_appointment);
        service_appointmentService.updateById(service_appointment);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        service_appointmentService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Service_AppointmentEntity> wrapper = new EntityWrapper<Service_AppointmentEntity>();
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

		int count = service_appointmentService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<Service_AppointmentEntity> ew = new EntityWrapper<Service_AppointmentEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("employer")) {
            ew.eq("employer_account", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("employee")) {
            ew.eq("employee_account", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = service_appointmentService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<Service_AppointmentEntity> ew = new EntityWrapper<Service_AppointmentEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("employer")) {
            ew.eq("employer_account", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("employee")) {
            ew.eq("employee_account", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = service_appointmentService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<Service_AppointmentEntity> ew = new EntityWrapper<Service_AppointmentEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("employer")) {
            ew.eq("employer_account", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("employee")) {
            ew.eq("employee_account", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = service_appointmentService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

}
