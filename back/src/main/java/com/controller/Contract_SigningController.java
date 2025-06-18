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

import com.entity.Contract_SigningEntity;
import com.entity.view.Contract_SigningView;

import com.service.Contract_SigningService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 签订合同
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/contract_signing")
public class Contract_SigningController {
    @Autowired
    private Contract_SigningService contract_signingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,Contract_SigningEntity contract_signing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("employer")) {
			contract_signing.setEmployer_account((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("employee")) {
			contract_signing.setEmployee_account((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<Contract_SigningEntity> ew = new EntityWrapper<Contract_SigningEntity>();
		PageUtils page = contract_signingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, contract_signing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Contract_SigningEntity contract_signing, 
		HttpServletRequest request){
        EntityWrapper<Contract_SigningEntity> ew = new EntityWrapper<Contract_SigningEntity>();
		PageUtils page = contract_signingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, contract_signing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Contract_SigningEntity contract_signing){
       	EntityWrapper<Contract_SigningEntity> ew = new EntityWrapper<Contract_SigningEntity>();
      	ew.allEq(MPUtil.allEQMapPre( contract_signing, "contract_signing")); 
        return R.ok().put("data", contract_signingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Contract_SigningEntity contract_signing){
        EntityWrapper< Contract_SigningEntity> ew = new EntityWrapper< Contract_SigningEntity>();
 		ew.allEq(MPUtil.allEQMapPre( contract_signing, "contract_signing")); 
		Contract_SigningView contract_signingView =  contract_signingService.selectView(ew);
		return R.ok("查询签订合同成功").put("data", contract_signingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Contract_SigningEntity contract_signing = contract_signingService.selectById(id);
        return R.ok().put("data", contract_signing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Contract_SigningEntity contract_signing = contract_signingService.selectById(id);
        return R.ok().put("data", contract_signing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Contract_SigningEntity contract_signing, HttpServletRequest request){
    	contract_signing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(contract_signing);
        contract_signingService.insert(contract_signing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Contract_SigningEntity contract_signing, HttpServletRequest request){
    	contract_signing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(contract_signing);
        contract_signingService.insert(contract_signing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Contract_SigningEntity contract_signing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(contract_signing);
        contract_signingService.updateById(contract_signing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        contract_signingService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Contract_SigningEntity> wrapper = new EntityWrapper<Contract_SigningEntity>();
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

		int count = contract_signingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
