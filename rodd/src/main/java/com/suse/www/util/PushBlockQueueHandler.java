/**
 * 
 */
package com.suse.www.util;

/**
 * @ClassName: PushBlockQueueHandler.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Mar 7, 2017 4:29:06 PM
 */
public class PushBlockQueueHandler implements Runnable {

	 private Object obj;
	    public PushBlockQueueHandler(Object obj){
	        this.obj = obj;
	    }
	    
	    @Override
	    public void run() {
	        doBusiness();
	    }
	    
	    /**
	     * 业务处理时限
	     */
	    public void doBusiness(){
	        System.out.println(" 处理请求 "+obj );
	    }

}
