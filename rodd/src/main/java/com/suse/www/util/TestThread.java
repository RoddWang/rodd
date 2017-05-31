/**
 * 
 */
package com.suse.www.util;

import org.apache.log4j.Logger;

/**
 * @ClassName: TestThread.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Mar 7, 2017 3:00:21 PM
 */
public class TestThread extends Thread {
	Logger log = Logger.getLogger(getClass());
	@Override
	public void run() {
		try {
			log.debug(this.getName()+" run calculate at line 21!");
			new TestOne().calculate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.info(e.getMessage());
		}
	}

	
}
