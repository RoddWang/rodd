/**
 * 
 */
package com.suse.www.mongo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.suse.www.mongo.entity.User;
import com.suse.www.mongo.service.IUserService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/mongo/user")
public class User1Controller {

	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		String jsonStr = "";
		User t = new User();
		t.setId("4");
		t.setUsername("rodd4");
		t.setPassword("rodd4");
		userService.store(t);
        t = new User();
        t = userService.findOne("2");
        jsonStr = JSONObject.toJSONString(t);
		return jsonStr;
	}
}
