/**
 * 
 */
package com.suse.www.entity;

/**
 * @ClassName: XSSSecurityConfig.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Jan 5, 2017 10:56:14 AM
 */
public class XSSSecurityConfig {
	/** 
     * CHECK_HEADER：Whether to open the header
     */  
    public static boolean IS_CHECK_HEADER;   
      
    /** 
     * CHECK_PARAMETER：Whether to open the parameter
     */  
    public static boolean IS_CHECK_PARAMETER;  
      
    /** 
     * IS_LOG：Whether to record log 
     */  
    public static boolean IS_LOG;  
      
    /** 
     * IS_LOG：Whether the interrupt operation 
     */  
    public static boolean IS_CHAIN;  
      
    /** 
     * REPLACE：Whether to open replace
     */  
    public static boolean REPLACE; 
}
