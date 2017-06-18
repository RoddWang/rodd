/**
 * 
 */
package com.suse.www.test.activiti.listener.Imp;

import org.activiti.engine.delegate.DelegateTask;

import com.suse.www.test.activiti.listener.TaskListener;

/**
 * @author Administrator
 *
 */
public class TaskListenerImp implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		//可以根据登陆人的id 查询出对应的领导人 然后设置下一个审批人
		
		String strAssignee = "zhagnsan";
		delegateTask.setAssignee(strAssignee);

	}
	

}
