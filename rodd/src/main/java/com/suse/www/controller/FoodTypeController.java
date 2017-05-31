/**
 * 
 */
package com.suse.www.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suse.www.service.Impl.TFoodTypeService;

/**
 * @author Rodd.Wang
 *
 * @date 2017年5月10日
 */
@Controller
@RequestMapping("/foodType")
public class FoodTypeController {

	@Resource
	private TFoodTypeService tFoodTypeService;
	
	
}
