/**
 * 
 */
package com.suse.www.service;

/**
 * @ClassName: ScheduledJobService.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Mar 7, 2017 11:00:31 AM
 */
public interface IScheduledJobService {

	public void refreshSQLStatus();
	
	public void synchronizeSQLDate();
	
	public void saveDataFromMSToMongoDB();
}
