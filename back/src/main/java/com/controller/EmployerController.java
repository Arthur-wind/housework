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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.EmployerEntity;
import com.entity.view.EmployerView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.EmployerService;
import com.service.TokenService;
import com.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 雇主
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:54
 */
@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;


    
	@Autowired
	private TokenService tokenService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		EmployerEntity user = employerService.selectOne(new EntityWrapper<EmployerEntity>().eq("employer_account", username));
		if (user == null || !passwordEncoder.matches(password,user.getPassword())) {
			return R.error("账号或密码不正确");
		}
		System.out.println("用户名：" + username + " 密码：" + password);

		String token = tokenService.generateToken(user.getId(), username,"employer",  "雇主" );
		// 3. 使用 JWT 生成可携带用户信息的 token（用于传递给后台系统）
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", user.getId());
		claims.put("userName", username);
		claims.put("role", "employer");
		claims.put("tableName", "employer");
		claims.put("token", token);
		String jwtToken = JwtUtils.generateToken(claims, user.getEmployerName());
		String enTicket;

		try {
			// 把 claims 转成 JSON 字符串（这里用 Jackson ObjectMapper，确保你pom依赖了）
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(claims);

			// AES密钥，和AESUtil中保持一致
			String aesSecret = "1234567890123456"; // 16位密钥，示例

			enTicket = AESUtil.encrypt(json, aesSecret);
			System.out.println("ticket: " + enTicket);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("生成 ticket 失败");
		}

		return R.ok()
				.put("enTicket", enTicket)		//加密ticket
				.put("token", token)       // 旧逻辑：存入数据库的 token
				.put("jwtToken", jwtToken);	// 新逻辑：用于页面间跳转的 JWT token

	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody EmployerEntity employer){
		if (employer.getEmployerAccount() == null || employer.getEmployerAccount().isEmpty()) {
			return R.error("账号不能为空");
		}

    	ValidatorUtils.validateEntity(employer);

    	EmployerEntity user = employerService.selectOne(new EntityWrapper<EmployerEntity>()
				.eq("employer_account", employer.getEmployerAccount()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		employer.setId(uId);
		employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employerService.insert(employer);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        EmployerEntity user = employerService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	EmployerEntity user = employerService.selectOne(new EntityWrapper<EmployerEntity>().eq("employer_account", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setPassword(passwordEncoder.encode("123456"));
        employerService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
//    @RequestMapping("/page")
//    public R page(@RequestParam Map<String, Object> params,EmployerEntity employer,
//		HttpServletRequest request){
//
//        EntityWrapper<EmployerEntity> ew = new EntityWrapper<EmployerEntity>();
//		PageUtils page = employerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employer), params),
//				params)
//		);
//
//        return R.ok().put("data", page);
//    }
	@RequestMapping("/page")
	public R page(@RequestParam Map<String, Object> params, EmployerEntity employer, HttpServletRequest request){
		// 手动赋值
		if(params.get("employer_account") != null){
			employer.setEmployerAccount((String)params.get("employer_account"));
		}
		if(params.get("employer_name") != null){
			employer.setEmployerName((String)params.get("employer_name"));
		}
		// 其它字段同理

		EntityWrapper<EmployerEntity> ew = new EntityWrapper<EmployerEntity>();
		PageUtils page = employerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employer), params), params));
		return R.ok().put("data", page);
	}
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,EmployerEntity employer,
		HttpServletRequest request){
        EntityWrapper<EmployerEntity> ew = new EntityWrapper<EmployerEntity>();
		PageUtils page = employerService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employer), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( EmployerEntity employer){
       	EntityWrapper<EmployerEntity> ew = new EntityWrapper<EmployerEntity>();
      	ew.allEq(MPUtil.allEQMapPre( employer, "employer")); 
        return R.ok().put("data", employerService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(EmployerEntity employer){
        EntityWrapper< EmployerEntity> ew = new EntityWrapper< EmployerEntity>();
 		ew.allEq(MPUtil.allEQMapPre( employer, "employer")); 
		EmployerView employerView =  employerService.selectView(ew);
		return R.ok("查询雇主成功").put("data", employerView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        EmployerEntity employer = employerService.selectById(id);
        return R.ok().put("data", employer);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        EmployerEntity employer = employerService.selectById(id);
        return R.ok().put("data", employer);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EmployerEntity employer, HttpServletRequest request){
    	employer.setId(new Date().getTime()+(long)(Math.random() * 1000));
    	//ValidatorUtils.validateEntity(employer);
    	EmployerEntity user = employerService.selectOne(new EntityWrapper<EmployerEntity>().eq("employer_account", employer.getEmployerAccount()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		employer.setId(new Date().getTime());
		employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employerService.insert(employer);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody EmployerEntity employer, HttpServletRequest request){
    	employer.setId(new Date().getTime()+(long)(Math.random() * 1000));
    	//ValidatorUtils.validateEntity(employer);
    	EmployerEntity user = employerService.selectOne(new EntityWrapper<EmployerEntity>().eq("employer_account", employer.getEmployerAccount()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		employer.setId(new Date().getTime());
		employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employerService.insert(employer);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EmployerEntity employer, HttpServletRequest request){
        //ValidatorUtils.validateEntity(employer);
		employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employerService.updateById(employer);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        employerService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<EmployerEntity> wrapper = new EntityWrapper<EmployerEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = employerService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
