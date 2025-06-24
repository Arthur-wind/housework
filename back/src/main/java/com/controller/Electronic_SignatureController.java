package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.Electronic_SignatureEntity;
import com.entity.view.Electronic_SignatureView;
import com.service.Electronic_SignatureService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


//  电子签名
//  后端接口

@RestController
@RequestMapping("/electronic_signature")
public class Electronic_SignatureController {
    @Autowired
    private Electronic_SignatureService electronic_signatureService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,
                  Electronic_SignatureEntity contract_signing,
                  HttpServletRequest request) {


        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = (String) request.getSession().getAttribute("username");


        EntityWrapper<Electronic_SignatureEntity> ew = new EntityWrapper<>();


        if ("employer".equals(tableName)) {
            ew.eq("employer_account", username);
        } else if ("employee".equals(tableName)) {
            ew.eq("employee_account", username);
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


        PageUtils page = electronic_signatureService.queryPage(
                params,
                MPUtil.sort(MPUtil.between(ew, params),
                        params
                ));

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Electronic_SignatureEntity electronic_signature,
		HttpServletRequest request){

        if(params.containsKey("project_name")) {
            electronic_signature.setProjectName((String)params.get("project_name"));
        }
        if(params.containsKey("employer_name")) {
            electronic_signature.setEmployerName((String)params.get("employer_name"));
        }
        EntityWrapper<Electronic_SignatureEntity> ew = new EntityWrapper<Electronic_SignatureEntity>();
		PageUtils page = electronic_signatureService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, electronic_signature), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( Electronic_SignatureEntity electronic_signature){
       	EntityWrapper<Electronic_SignatureEntity> ew = new EntityWrapper<Electronic_SignatureEntity>();
      	ew.allEq(MPUtil.allEQMapPre( electronic_signature, "electronic_signature"));
        return R.ok().put("data", electronic_signatureService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(Electronic_SignatureEntity electronic_signature){
        EntityWrapper< Electronic_SignatureEntity> ew = new EntityWrapper< Electronic_SignatureEntity>();
 		ew.allEq(MPUtil.allEQMapPre( electronic_signature, "electronic_signature"));
		Electronic_SignatureView electronic_signatureView =  electronic_signatureService.selectView(ew);
		return R.ok("查询电子签名成功").put("data", electronic_signatureView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Electronic_SignatureEntity electronic_signature = electronic_signatureService.selectById(id);
        return R.ok().put("data", electronic_signature);
    }

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Electronic_SignatureEntity electronic_signature = electronic_signatureService.selectById(id);
        return R.ok().put("data", electronic_signature);
    }
    

    @RequestMapping("/save")
    public R save(@RequestBody Electronic_SignatureEntity electronic_signature, HttpServletRequest request){
    	electronic_signature.setId(new Date().getTime()+(long)(Math.random() * 1000));


        electronic_signatureService.insert(electronic_signature);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody Electronic_SignatureEntity electronic_signature, HttpServletRequest request){
    	electronic_signature.setId(new Date().getTime()+(long)(Math.random() * 1000));

        electronic_signatureService.insert(electronic_signature);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody Electronic_SignatureEntity electronic_signature, HttpServletRequest request){

        electronic_signatureService.updateById(electronic_signature);//全部更新
        return R.ok();
    }
    

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        electronic_signatureService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<Electronic_SignatureEntity> wrapper = new EntityWrapper<Electronic_SignatureEntity>();
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

		int count = electronic_signatureService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
}
