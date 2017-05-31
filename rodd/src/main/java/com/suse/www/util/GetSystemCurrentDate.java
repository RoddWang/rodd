/**
 * 
 */
package com.suse.www.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: GetCurrentDate.java
 * @Description: return system current date
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Mar 7, 2017 11:14:11 AM
 */
public class GetSystemCurrentDate {

	/*
	 * @Description:
	 * @param: null
	 * @author: Rodd(Wang,Jian)
	 * @return type: yyyy-MM-dd HH:mm:ss
	 */
	public String returnCurrentDateOne(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}
	
	/*
	 * @Description:
	 * @param: null
	 * @author: Rodd(Wang,Jian)
	 * @return type: yyyy-MM-dd
	 */
	public String returnCurrentDateTwo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}
	
	/*
	 * @Description:
	 * @param: null
	 * @author: Rodd(Wang,Jian)
	 * @return type: MM/dd/yyyy HH:mm:ss
	 */
	public String returnCurrentDateThree(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}
	
	/*
	 * @Description:
	 * @param: null
	 * @author: Rodd(Wang,Jian)
	 * @return type: MM/dd/yyyy
	 * 
	 */
	public String returnCurrentDateFour(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}
}
