/**
 * 
 */
package com.suse.www.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suse.www.service.imp.TFoodNameService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Controller
@RequestMapping("/foodName")
public class FoodNameController {

	@Resource
	private TFoodNameService tFoodNameService;
}
