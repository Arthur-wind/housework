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

import com.entity.Material_CertificationEntity;
import com.entity.view.Material_CertificationView;

import com.service.Material_CertificationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;


//  资料认证
//  后端接口

@RestController
@RequestMapping("/material_certification")
public class Material_CertificationController {
    @Autowired
    private Material_CertificationService material_certificationService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,Material_CertificationEntity material_certification,
        HttpServletRequest request){

        if(params.containsKey("employee_account")) {
            material_certification.setEmployeeAccount((String)params.get("employee_account"));
        }
        if(params.containsKey("employee_name")) {
            material_certification.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.containsKey("is_reviewed")) {
            material_certification.setIsReviewed((String)params.get("is_reviewed"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("employee")) {
            material_certification.setEmployeeAccount((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<Material_CertificationEntity> ew = new EntityWrapper<Material_CertificationEntity>();
        PageUtils page = material_certificationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, material_certification), params), params));

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Material_CertificationEntity material_certification, 
		HttpServletRequest request){

        if(params.containsKey("employee_account")) {
            material_certification.setEmployeeAccount((String)params.get("employee_account"));
        }
        if(params.containsKey("employee_name")) {
            material_certification.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.containsKey("is_reviewed")) {
            material_certification.setIsReviewed((String)params.get("is_reviewed"));
        }

        EntityWrapper<Material_CertificationEntity> ew = new EntityWrapper<Material_CertificationEntity>();
		PageUtils page = material_certificationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, material_certification), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R list( Material_CertificationEntity material_certification){
       	EntityWrapper<Material_CertificationEntity> ew = new EntityWrapper<Material_CertificationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( material_certification, "material_certification")); 
        return R.ok().put("data", material_certificationService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(Material_CertificationEntity material_certification){
        EntityWrapper< Material_CertificationEntity> ew = new EntityWrapper< Material_CertificationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( material_certification, "material_certification")); 
		Material_CertificationView material_certificationView =  material_certificationService.selectView(ew);
		return R.ok("查询资料认证成功").put("data", material_certificationView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Material_CertificationEntity material_certification = material_certificationService.selectById(id);
        return R.ok().put("data", material_certification);
    }

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Material_CertificationEntity material_certification = material_certificationService.selectById(id);
        return R.ok().put("data", material_certification);
    }
    

    @RequestMapping("/save")
    public R save(@RequestBody Material_CertificationEntity material_certification, HttpServletRequest request){
    	material_certification.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());

        material_certificationService.insert(material_certification);
        return R.ok();
    }
    

    @RequestMapping("/add")
    public R add(@RequestBody Material_CertificationEntity material_certification, HttpServletRequest request){
    	material_certification.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());

        material_certificationService.insert(material_certification);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody Material_CertificationEntity material_certification, HttpServletRequest request){

        material_certificationService.updateById(material_certification);
        return R.ok();
    }
    

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        material_certificationService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Material_CertificationEntity> wrapper = new EntityWrapper<Material_CertificationEntity>();
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

		int count = material_certificationService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
