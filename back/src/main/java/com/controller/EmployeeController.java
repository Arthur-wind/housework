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

import com.entity.TokenEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.*;
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

import com.entity.EmployeeEntity;
import com.entity.view.EmployeeView;

import com.service.EmployeeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 雇员
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


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
		EmployeeEntity user = employeeService.selectOne(
                new EntityWrapper<EmployeeEntity>().eq("employee_account", username));
        System.out.println("接收到数据：" + password);
        System.out.println("数据库中的密码：" + user.getPassword());
        System.out.println("密码加密后：" + passwordEncoder.encode(password));
        if (user == null || !passwordEncoder.matches(password,user.getPassword())) {
			return R.error("账号或密码不正确");
		}


		String token = tokenService.generateToken(user.getId(), username,"employee",  "雇员" );
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", user.getId());
		claims.put("userName", username);
		claims.put("role", "employee");
		claims.put("tableName", "employee");
		claims.put("token", token);

		String jwtToken = JwtUtils.generateToken(claims, user.getEmployeeName());
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
public R register(@RequestBody EmployeeEntity employee) {
    System.out.println("接收到的数据：" + employee); // 调试输出
    if (employee.getEmployeeAccount() == null || employee.getEmployeeAccount().isEmpty()) {
        return R.error("账号不能为空");
    }

    ValidatorUtils.validateEntity(employee);

    EmployeeEntity user = employeeService.selectOne(new EntityWrapper<EmployeeEntity>()
            .eq("employee_account", employee.getEmployeeAccount()));
    if (user != null) {
        return R.error("注册用户已存在");
    }

    Long uId = new Date().getTime();
    employee.setId(uId);
    employee.setPassword(passwordEncoder.encode(employee.getPassword()));
    System.out.println("加密后的数据：" + employee.getPassword());
    employeeService.insert(employee);
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
        EmployeeEntity user = employeeService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	EmployeeEntity user = employeeService.selectOne(new EntityWrapper<EmployeeEntity>().eq("employee_account", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setPassword(passwordEncoder.encode("123456"));
        employeeService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, EmployeeEntity employee, HttpServletRequest request){
        // 手动赋值
        if(params.get("employee_account") != null){
            employee.setEmployeeAccount((String)params.get("employee_account"));
        }
        if(params.get("employee_name") != null){
            employee.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.get("contact_phone") != null){
            employee.setContact_Phone((String)params.get("contact_phone"));
        }
        if(params.get("id_card") != null){
            employee.setId_Card((String)params.get("id_card"));
        }
        // 其它字段同理

        EntityWrapper<EmployeeEntity> ew = new EntityWrapper<EmployeeEntity>();
        PageUtils page = employeeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employee), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, EmployeeEntity employee, HttpServletRequest request){
        // 手动赋值
        if(params.get("employee_account") != null){
            employee.setEmployeeAccount((String)params.get("employee_account"));
        }
        if(params.get("employee_name") != null){
            employee.setEmployeeName((String)params.get("employee_name"));
        }
        if(params.get("contact_phone") != null){
            employee.setContact_Phone((String)params.get("contact_phone"));
        }
        if(params.get("id_card") != null){
            employee.setId_Card((String)params.get("id_card"));
        }
        // 其它字段同理

        EntityWrapper<EmployeeEntity> ew = new EntityWrapper<EmployeeEntity>();
        PageUtils page = employeeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, employee), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( EmployeeEntity employee){
       	EntityWrapper<EmployeeEntity> ew = new EntityWrapper<EmployeeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( employee, "employee")); 
        return R.ok().put("data", employeeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(EmployeeEntity employee){
        EntityWrapper< EmployeeEntity> ew = new EntityWrapper< EmployeeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( employee, "employee")); 
		EmployeeView employeeView =  employeeService.selectView(ew);
		return R.ok("查询雇员成功").put("data", employeeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        EmployeeEntity employee = employeeService.selectById(id);
        return R.ok().put("data", employee);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        EmployeeEntity employee = employeeService.selectById(id);
        return R.ok().put("data", employee);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EmployeeEntity employee, HttpServletRequest request){
    	employee.setId(new Date().getTime()+(long)(Math.random() * 1000));
    	//ValidatorUtils.validateEntity(employee);
    	EmployeeEntity user = employeeService.selectOne(new EntityWrapper<EmployeeEntity>().eq("employee_account", employee.getEmployeeAccount()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		employee.setId(new Date().getTime());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.insert(employee);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody EmployeeEntity employee, HttpServletRequest request){
    	employee.setId(new Date().getTime()+(long)(Math.random() * 1000));
    	//ValidatorUtils.validateEntity(employee);
    	EmployeeEntity user = employeeService.selectOne(new EntityWrapper<EmployeeEntity>().eq("employee_account", employee.getEmployeeAccount()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		employee.setId(new Date().getTime());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.insert(employee);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EmployeeEntity employee, HttpServletRequest request){
        //ValidatorUtils.validateEntity(employee);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.updateById(employee);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        employeeService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<EmployeeEntity> wrapper = new EntityWrapper<EmployeeEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = employeeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
