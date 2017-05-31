/**
 * 
 */
package com.suse.www.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suse.www.entity.Asset;

/**
 * @ClassName: GrommetTestController.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Jan 3, 2017 10:23:14 AM
 */
@Controller
@RequestMapping("/grommet")
public class GrommetTestController {

	@RequestMapping("/GrommetTest")
	public ModelAndView testOne(HttpServletRequest req){
		ModelAndView  modelAndView = new ModelAndView("/grommet/GrommetTest");
		return modelAndView;
	}
	@RequestMapping("/react1")
	public ModelAndView react1(HttpServletRequest req){
		ModelAndView  modelAndView = new ModelAndView("/grommet/react1");
		return modelAndView;
	}
	@RequestMapping("/react2")
	public ModelAndView react2(HttpServletRequest req){
		ModelAndView  modelAndView = new ModelAndView("/grommet/react2");
		return modelAndView;
	}
	@RequestMapping("/react3")
	public ModelAndView react3(HttpServletRequest req){
		ModelAndView  modelAndView = new ModelAndView("/grommet/react3");
		return modelAndView;
	}
	@RequestMapping("/test1")
	public ModelAndView test1(HttpServletRequest req){
		ModelAndView  modelAndView = new ModelAndView("/grommet/test1");
		return modelAndView;
	}
	//return String
	@RequestMapping("/returnString")
	public String returnString(Model model){
		Asset asset = new Asset();
		asset.setId(110);
		asset.setAsset_name("Rodd");
		asset.setApp_name("Wang");
		asset.setAdapter_cluster_id(120);
		model.addAttribute("asset",asset);
		model.addAttribute("name", "return String");
		String url = "/test/returnValueTest";
		return url;
	}
	//returnMap
	@RequestMapping("/returnMap")
	public String returnMap(){
		Map map = new HashMap();
		map.put("name", "return Map");
		map.put("asset.id", 120);
		map.put("asset.app_name", "haha");
		map.put("asset.asset_name", "rodd");
		return "redirect:/views/test/returnValueTest.jsp";
	}
	//returnVoid
	@RequestMapping("/returnVoid")
	public String returnModelMap( ){
		Asset asset = new Asset();
		asset.setId(110110);
		asset.setAsset_name("Rodd");
		asset.setApp_name("Wang");
		asset.setAdapter_cluster_id(120);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("asset", asset);
		modelAndView.addObject("name", "return void");
		return "forward:/views/test/returnValueTest.jsp";
	}
}
