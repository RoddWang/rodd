/**
 * 
 */
package com.suse.www.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.suse.www.service.ScheduledJobService;
import com.suse.www.util.GetSystemCurrentDate;
import com.suse.www.util.TestThread;

/**
 * @ClassName: ScheduledJobServiceImp.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Mar 7, 2017 12:21:32 PM
 */
@Service
//@EnableScheduling
public class ScheduledJobServiceImp implements ScheduledJobService {
	private Logger log = Logger.getLogger(getClass());
	@Override
	@Scheduled(cron="2/5 * * * * ?" ) //秒，分，时，天（0-31），月（0-11），周 cron ="*/5 * * *　* ?"
	public void refreshSQLStatus() {
		System.out.println("Date is : "+ new GetSystemCurrentDate().returnCurrentDateOne());
		log.debug("Date is :"+  new GetSystemCurrentDate().returnCurrentDateOne());
	}
	@Override
	@Scheduled(cron="*/5 * * * * ?")
	public void synchronizeSQLDate() {
		try {
			System.out.println("Date is : "+ new GetSystemCurrentDate().returnCurrentDateOne());
			new TestThread().start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	@Override
	@Scheduled(cron="*/10 * * * * ?")
	public void saveDataFromMSToMongoDB() {
		System.out.println("Date is : "+ new GetSystemCurrentDate().returnCurrentDateOne());
		try {
			new TestThread().start();
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		
	}
	
	
	
}
