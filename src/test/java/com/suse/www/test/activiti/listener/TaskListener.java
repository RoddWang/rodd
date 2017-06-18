/**
 * 
 */
package com.suse.www.test.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;

/**
 * @author Rodd
 * 
 * @Description 任务监听器
 * 
 */
public interface TaskListener {
	/**
	 * @param delegateTask
	 * return 
	 */
	public void notify(DelegateTask delegateTask);
	
}
