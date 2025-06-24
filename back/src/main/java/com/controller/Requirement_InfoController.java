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

import com.entity.Requirement_InfoEntity;
import com.entity.view.Requirement_InfoView;

import com.service.Requirement_InfoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;


//   需求信息
//   后端接口


@RestController
@RequestMapping("/requirement_info")
public class Requirement_InfoController {
    @Autowired
    private Requirement_InfoService requirement_infoService;



    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,
                  Requirement_InfoEntity requirement_info,
                  HttpServletRequest request) {


        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = (String) request.getSession().getAttribute("username");


        EntityWrapper<Requirement_InfoEntity> ew = new EntityWrapper<>();

        if ("employer".equals(tableName)) {

            ew.eq("employer_account", username);
        }
        else if ("employee".equals(tableName)) {

            // ew.eq("employee_account", username); // 如果需要限制雇员查看范围
        }


        if (params.containsKey("work_location") && !params.get("work_location").toString().isEmpty()) {
            ew.like("work_location", params.get("work_location").toString());
        }
        if (params.containsKey("project_type") && !params.get("project_type").toString().isEmpty()) {
            ew.like("project_type", params.get("project_type").toString());
        }


        PageUtils page = requirement_infoService.queryPage(
                params,
                MPUtil.sort(MPUtil.between(ew, params), params)
        );

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Requirement_InfoEntity requirement_info, 
        HttpServletRequest request){

        if(params.containsKey("work_location")) {
            requirement_info.setWorkLocation((String)params.get("work_location"));
        }
        EntityWrapper<Requirement_InfoEntity> ew = new EntityWrapper<Requirement_InfoEntity>();
        PageUtils page = requirement_infoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, requirement_info), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( Requirement_InfoEntity requirement_info){
       	EntityWrapper<Requirement_InfoEntity> ew = new EntityWrapper<Requirement_InfoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( requirement_info, "requirement_info")); 
        return R.ok().put("data", requirement_infoService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(Requirement_InfoEntity requirement_info){
        EntityWrapper< Requirement_InfoEntity> ew = new EntityWrapper< Requirement_InfoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( requirement_info, "requirement_info")); 
		Requirement_InfoView requirement_infoView =  requirement_infoService.selectView(ew);
		return R.ok("查询需求信息成功").put("data", requirement_infoView);
    }
	

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Requirement_InfoEntity requirement_info = requirement_infoService.selectById(id);
		requirement_info.setClick_count(requirement_info.getClick_count()+1);
		requirement_info.setLast_Click_time(new Date());
		requirement_infoService.updateById(requirement_info);
        return R.ok().put("data", requirement_info);
    }


	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Requirement_InfoEntity requirement_info = requirement_infoService.selectById(id);
		requirement_info.setClick_count(requirement_info.getClick_count()+1);
		requirement_info.setLast_Click_time(new Date());
		requirement_infoService.updateById(requirement_info);
        return R.ok().put("data", requirement_info);
    }
    

    @RequestMapping("/save")
    public R save(@RequestBody Requirement_InfoEntity requirement_info, HttpServletRequest request){
    	requirement_info.setId(new Date().getTime()+(long)(Math.random() * 1000));

        requirement_infoService.insert(requirement_info);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody Requirement_InfoEntity requirement_info, HttpServletRequest request){
    	requirement_info.setId(new Date().getTime()+(long)(Math.random() * 1000));

        requirement_infoService.insert(requirement_info);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody Requirement_InfoEntity requirement_info, HttpServletRequest request){

        requirement_infoService.updateById(requirement_info);
        return R.ok();
    }
    

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        requirement_infoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Requirement_InfoEntity> wrapper = new EntityWrapper<Requirement_InfoEntity>();
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

		int count = requirement_infoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	

	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,Requirement_InfoEntity requirement_info, HttpServletRequest request,String pre){
        EntityWrapper<Requirement_InfoEntity> ew = new EntityWrapper<Requirement_InfoEntity>();
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
		PageUtils page = requirement_infoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, requirement_info), params), params));
        return R.ok().put("data", page);
    }

}
