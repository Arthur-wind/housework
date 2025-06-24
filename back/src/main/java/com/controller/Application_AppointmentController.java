package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.Application_AppointmentEntity;
import com.entity.view.Application_AppointmentView;
import com.service.Application_AppointmentService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


//  申请预约
//  后端接口

@RestController
@RequestMapping("/application_appointment")
public class Application_AppointmentController {
    @Autowired
    private Application_AppointmentService application_appointmentService;



    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,Application_AppointmentEntity application_appointment,
        HttpServletRequest request){

        if(params.containsKey("project_name")) {
            application_appointment.setProjectName((String)params.get("project_name"));
        }
        if(params.containsKey("employer_name")) {
            application_appointment.setEmployerName((String)params.get("employer_name"));
        }
        if(params.containsKey("employee_name")) {
            application_appointment.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.containsKey("is_reviewed")) {
            application_appointment.setIsReviewed((String)params.get("is_reviewed"));
        }
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("employer")) {
            application_appointment.setEmployerAccount((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("employee")) {
            application_appointment.setEmployeeAccount((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<Application_AppointmentEntity> ew = new EntityWrapper<Application_AppointmentEntity>();
        PageUtils page = application_appointmentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, application_appointment), params), params));

        return R.ok().put("data", page);
    }


	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Application_AppointmentEntity application_appointment, 
		HttpServletRequest request){

        if(params.containsKey("project_name")) {
            application_appointment.setProjectName((String)params.get("project_name"));
        }
        if(params.containsKey("employer_name")) {
            application_appointment.setEmployerName((String)params.get("employer_name"));
        }
        if(params.containsKey("employee_name")) {
            application_appointment.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.containsKey("is_reviewed")) {
            application_appointment.setIsReviewed((String)params.get("is_reviewed"));
        }
        EntityWrapper<Application_AppointmentEntity> ew = new EntityWrapper<Application_AppointmentEntity>();
		PageUtils page = application_appointmentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, application_appointment), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( Application_AppointmentEntity application_appointment){
       	EntityWrapper<Application_AppointmentEntity> ew = new EntityWrapper<Application_AppointmentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( application_appointment, "application_appointment")); 
        return R.ok().put("data", application_appointmentService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(Application_AppointmentEntity application_appointment){
        EntityWrapper< Application_AppointmentEntity> ew = new EntityWrapper< Application_AppointmentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( application_appointment, "application_appointment")); 
		Application_AppointmentView application_appointmentView =  application_appointmentService.selectView(ew);
		return R.ok("查询申请预约成功").put("data", application_appointmentView);
    }
	

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Application_AppointmentEntity application_appointment = application_appointmentService.selectById(id);
        return R.ok().put("data", application_appointment);
    }


	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Application_AppointmentEntity application_appointment = application_appointmentService.selectById(id);
        return R.ok().put("data", application_appointment);
    }
    

    @RequestMapping("/save")
    public R save(@RequestBody Application_AppointmentEntity application_appointment, HttpServletRequest request){
application_appointment.setId(System.currentTimeMillis() + (long)(Math.random() * 1000));

        application_appointmentService.insert(application_appointment);
        return R.ok();
    }
    

    @RequestMapping("/add")
    public R add(@RequestBody Application_AppointmentEntity application_appointment, HttpServletRequest request){
application_appointment.setId(System.currentTimeMillis() + (long)(Math.random() * 1000));

        application_appointmentService.insert(application_appointment);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody Application_AppointmentEntity application_appointment, HttpServletRequest request){

        application_appointmentService.updateById(application_appointment);
        return R.ok();
    }
    

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        application_appointmentService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Application_AppointmentEntity> wrapper = new EntityWrapper<Application_AppointmentEntity>();
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

		int count = application_appointmentService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	

    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<Application_AppointmentEntity> ew = new EntityWrapper<Application_AppointmentEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("employer")) {
            ew.eq("employer_account", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("employee")) {
            ew.eq("employee_account", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = application_appointmentService.selectValue(params, ew);
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

    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<Application_AppointmentEntity> ew = new EntityWrapper<Application_AppointmentEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("employer")) {
            ew.eq("employer_account", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("employee")) {
            ew.eq("employee_account", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = application_appointmentService.selectTimeStatValue(params, ew);
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

    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<Application_AppointmentEntity> ew = new EntityWrapper<Application_AppointmentEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("employer")) {
            ew.eq("employer_account", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("employee")) {
            ew.eq("employee_account", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = application_appointmentService.selectGroup(params, ew);
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
