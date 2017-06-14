/**
 * 
 */
package com.suse.www.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suse.www.service.imp.TUserService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private TUserService tUserService;
	
}
