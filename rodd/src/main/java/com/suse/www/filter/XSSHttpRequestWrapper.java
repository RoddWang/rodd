/**
 * 
 */
package com.suse.www.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import com.suse.www.entity.XSSSecurityConfig;
import com.suse.www.util.XSSSecurityManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


/**
 * @ClassName: XSSHttpRequestWrapper.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Jan 5, 2017 11:06:49 AM
 */
public class XSSHttpRequestWrapper extends HttpServletRequestWrapper {
	 /** 
     * Encapsulate the HTTP request
     * @param request 
     */  
    public XSSHttpRequestWrapper(HttpServletRequest request) {  
        super(request);  
    }  
      
    @Override  
    public String getHeader(String name) {  
        String value = super.getHeader(name);  
        // If open the special characters to replace, to replace the special characters  
        if(XSSSecurityConfig.REPLACE){  
            XSSSecurityManager.securityReplace(name);  
        }  
        return value;  
    }  
  
    @Override  
    public String getParameter(String name) {  
        String value = super.getParameter(name);  
        // If open the special characters to replace, to replace the special characters 
        if(XSSSecurityConfig.REPLACE){  
            XSSSecurityManager.securityReplace(name);  
        }  
        return value;  
    }  
  
    /** 
     * No violations of data, it returns false;
     *  
     * @return 
     */  
    private boolean checkHeader(){  
        Enumeration<String> headerParams = this.getHeaderNames();  
        while(headerParams.hasMoreElements()){  
            String headerName = headerParams.nextElement();  
            String headerValue = this.getHeader(headerName);  
            if(XSSSecurityManager.matches(headerValue)){  
                return true;  
            }  
        }  
        return false;  
    }  
      
    /** 
     * No violations of data, it returns false;
     *  
     * @return 
     */  
    private boolean checkParameter(){  
        Map<String, String[]> submitParams = this.getParameterMap();
     /*   Map<String,Object> submitParams = this.getParameterMap();*/
        Set<String> submitNames = submitParams.keySet(); 
        for(String submitName : submitNames){  
            Object submitValues = submitParams.get(submitName);  
            if(submitValues instanceof String){  
                if(XSSSecurityManager.matches((String)submitValues)){  
                    return true;  
                }  
            }else if(submitValues instanceof String[]){  
                for(String submitValue : (String[])submitValues){  
                    if(XSSSecurityManager.matches((String)submitValue)){  
                        return true;  
                    }  
                }  
            }  
        }  
        return false;  
    }  
      
     
    /** 
     * No violations of data, it returns false;
     * If any violation of the data, according to the configuration information to determine whether to jump to the wstax-admin home page
     * @param response 
     * @return 
     * @throws IOException  
     * @throws ServletException  
     */  
    public boolean validateParameter(HttpServletResponse response) throws ServletException, IOException{  
        // Start the header calibration, to check the header information  
        if(XSSSecurityConfig.IS_CHECK_HEADER){  
            if(this.checkHeader()){  
                return true;  
            }  
        }  
        // Start the parameter calibration, to calibrate the parameter information 
        if(XSSSecurityConfig.IS_CHECK_PARAMETER){  
            if(this.checkParameter()){  
                return true;  
            }  
        }  
        return false;  
    }  
      
}
