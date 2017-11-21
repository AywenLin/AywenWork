package com.cms.web.exam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.bean.exam.Users;
import com.cms.mapper.exam.IRegMapper;

@Controller
@RequestMapping("admin/reg")
public class RegController {
	@Autowired
	private IRegMapper regmapper;
	/**
	 * 
	 * (页面跳转)<br/>
	 * 方法名：reg<br/>
	 * 创建人：AywenLin <br/>
	 * 时间：2017年11月20日-下午9:40:20 <br/>
	 * 手机:17742597905<br/>
	 * 
	 * @return String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping
	public String reg() {
		return "exam/form";
	}
  
	
	/**
	 * 
	 * (注册的逻辑)<br/>
	 * 方法名：doReg<br/>
	 * 创建人：AywenLin <br/>
	 * 时间：2017年11月20日-下午10:44:29 <br/>
	 * 手机:17742597905<br/>
	 * @param users
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping("/doReg")
	public String doReg(Users users){
		int num=regmapper.saveUser(users);
		if(num>0){
			return"success";
		}
		else{
			return"fail";
		}
	}
	
}
