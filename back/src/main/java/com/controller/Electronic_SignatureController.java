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

/**
 * 电子签名
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/electronic_signature")
public class Electronic_SignatureController {
    @Autowired
    private Electronic_SignatureService electronic_signatureService;


    


    /**
     * 后端列表
     */
//    @RequestMapping("/page")
//    public R page(@RequestParam Map<String, Object> params,Electronic_SignatureEntity electronic_signature,
//        HttpServletRequest request){
//        // 手动处理映射
//        if(params.containsKey("project_name")) {
//            electronic_signature.setProjectName((String)params.get("project_name"));
//        }
//        if(params.containsKey("employer_name")) {
//            electronic_signature.setEmployerName((String)params.get("employer_name"));
//        }
//        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("employer")) {
//            electronic_signature.setEmployer_account((String)request.getSession().getAttribute("username"));
//        }
//        if(tableName.equals("employee")) {
//            electronic_signature.setEmployee_account((String)request.getSession().getAttribute("username"));
//        }
//        EntityWrapper<Electronic_SignatureEntity> ew = new EntityWrapper<Electronic_SignatureEntity>();
//        PageUtils page = electronic_signatureService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, electronic_signature), params), params));
//
//        return R.ok().put("data", page);
//    }
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,
                  Electronic_SignatureEntity contract_signing,
                  HttpServletRequest request) {

        // 1. 从 session 获取用户身份信息
        String tableName = request.getSession().getAttribute("tableName").toString();
        String username = (String) request.getSession().getAttribute("username");

        // 2. 创建查询包装器
        EntityWrapper<Electronic_SignatureEntity> ew = new EntityWrapper<>();

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
        PageUtils page = electronic_signatureService.queryPage(
                params,
                MPUtil.sort(MPUtil.between(ew, params),
                        params
                ));

        return R.ok().put("data", page);
    }
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,Electronic_SignatureEntity electronic_signature,
		HttpServletRequest request){
        // 手动处理映射
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

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( Electronic_SignatureEntity electronic_signature){
       	EntityWrapper<Electronic_SignatureEntity> ew = new EntityWrapper<Electronic_SignatureEntity>();
      	ew.allEq(MPUtil.allEQMapPre( electronic_signature, "electronic_signature"));
        return R.ok().put("data", electronic_signatureService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Electronic_SignatureEntity electronic_signature){
        EntityWrapper< Electronic_SignatureEntity> ew = new EntityWrapper< Electronic_SignatureEntity>();
 		ew.allEq(MPUtil.allEQMapPre( electronic_signature, "electronic_signature"));
		Electronic_SignatureView electronic_signatureView =  electronic_signatureService.selectView(ew);
		return R.ok("查询电子签名成功").put("data", electronic_signatureView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Electronic_SignatureEntity electronic_signature = electronic_signatureService.selectById(id);
        return R.ok().put("data", electronic_signature);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Electronic_SignatureEntity electronic_signature = electronic_signatureService.selectById(id);
        return R.ok().put("data", electronic_signature);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Electronic_SignatureEntity electronic_signature, HttpServletRequest request){
    	electronic_signature.setId(new Date().getTime()+(long)(Math.random() * 1000));

    	//ValidatorUtils.validateEntity(electronic_signature);
        electronic_signatureService.insert(electronic_signature);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Electronic_SignatureEntity electronic_signature, HttpServletRequest request){
    	electronic_signature.setId(new Date().getTime()+(long)(Math.random() * 1000));

    	//ValidatorUtils.validateEntity(electronic_signature);
        electronic_signatureService.insert(electronic_signature);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Electronic_SignatureEntity electronic_signature, HttpServletRequest request){
        //ValidatorUtils.validateEntity(electronic_signature);
        electronic_signatureService.updateById(electronic_signature);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        electronic_signatureService.deleteBatchIds(Arrays.asList(ids));
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
