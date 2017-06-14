/**
 * 
 */
package com.suse.www.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.suse.www.entity.TUser;
import com.suse.www.service.ITFoodCountryService;
import com.suse.www.service.ITFoodNameService;
import com.suse.www.service.ITFoodTypeService;
import com.suse.www.service.ITUserService;
import com.suse.www.service.imp.TFoodCountryService;
import com.suse.www.service.imp.TFoodNameService;
import com.suse.www.service.imp.TFoodTypeService;
import com.suse.www.service.imp.TUserService;

/**
 * @author Rodd.Wang
 *
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Resource
	private ITUserService tUserService;
	@Resource
	private ITFoodTypeService tFoodTypeService;
	@Resource
	private ITFoodNameService tFoodNameService;
	@Resource
	private ITFoodCountryService tFoodCountryService; 
	
	@RequestMapping("/testAjax")
	public void testAjax(HttpServletResponse response){
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			List<TUser> tUserList = new ArrayList<TUser>();
			TUser t = new TUser();
			tUserList = tUserService.selectAll(t);
			String jsonResult = JSON.toJSONString(tUserList);
			printWriter.write(jsonResult);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != printWriter) {
				printWriter.flush();
				printWriter.close();
		    }
		  }
	}
}
