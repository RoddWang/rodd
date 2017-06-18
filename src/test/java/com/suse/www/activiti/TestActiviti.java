/**
 * 
 */
package com.suse.www.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author Rodd
 *
 */
public class TestActiviti {

	/**
	 *  创建流程表
	 */
	@Test
	public void createTable(){

		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.xml") //
				.buildProcessEngine();
		System.out.println("ProcessEngine: "+processEngine);
		
	}
	/*
	 * 创建流程表说明:
	 * 需要注释掉项目中 也就是pom.xml中 ibatis 或者mybatis相关内容 使用他自己的 方可成功
	 * 
	*/
	
	
	/*流程部署相关表 
	act_re_deployement 部署对象表 act_rep_procdef  流程定义表 act_ge_bytearray 资源文件表 
	act_ge_prperty  主键生成策略表（对于部署对象表的主键ID）  
	流程实例相关表 
	act_ru_execution 正在执行的执行对象表（包含执行对象ID和流程实例ID，如果有多个线程可能流程实例ID不一样） 
	act_hi_procinst 流程实例历史表 
	act_hi_actinst 存放历史所有完成的任务   
	Task 任务相关表 
	act_ru_task 代办任务表 （只对应节点是UserTask的） 
	act_hi_taskinst 代办任务历史表 （只对应节点是UserTask的）  
	act_hi_actinst  所有节点活动历史表 （对应流程的所有节点的活动历史，从开始节点一直到结束节点中间的所有节点的活动都会被记录）   
	流程变量表 
	act_ru_variable 正在执行的流程变量表 act_hi_variable 流程变量历史表*/
}
