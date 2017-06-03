/**
 * 
 */
package com.suse.www.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.suse.www.entity.XSSSecurityCon;
import com.suse.www.entity.XSSSecurityConfig;
import com.suse.www.util.XSSSecurityManager;

/**
 * @ClassName: XSSFilter.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Jan 5, 2017 10:50:35 AM
 */
public class XSSFilter implements Filter {
	private Logger logger = Logger.getLogger(XSSFilter.class);

	@Override
	public void destroy() {
		logger.info("RequestFilter destroy() begin");  
		XSSSecurityManager.destroy();  
		logger.info("RequestFilter destroy() end");  
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 // Determine whether using HTTP 
	    checkRequestResponse(request, response);  
	    //   
	    HttpServletRequest httpRequest = (HttpServletRequest) request;  
	    HttpServletResponse httpResponse = (HttpServletResponse) response;  
	    // The HTTP wrapper class information  
	    XSSHttpRequestWrapper xssRequest = new XSSHttpRequestWrapper(httpRequest);  
	      
	    // Encapsulates the request information and check the work, if the validation fails
	    //(contain illegal characters), according to the configuration information for logging and request interrupt handling
	    if(xssRequest.validateParameter(httpResponse)){  
	        if(XSSSecurityConfig.IS_LOG){  
	            // Access log record attacks
	            // Can use a database, log, documents, etc
	        	logger.error("XSSSecurity don't access!");
	        }  
	        if(XSSSecurityConfig.IS_CHAIN){  
	        	 httpResponse.sendRedirect(httpRequest.getContextPath()+XSSSecurityCon.FILTER_ERROR_PAGE);
	            //httpRequest.getRequestDispatcher(httpRequest.getContextPath()+XSSSecurityCon.FILTER_ERROR_PAGE).forward( httpRequest, httpResponse);  
	            return;  
	        }  
	    }  
	    chain.doFilter(xssRequest, response);  
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		XSSSecurityManager.init(filterConfig);
		
	}
	
	 /** 
	   * Judge the Request, the Response type 
	   * @param request 
	   *            ServletRequest 
	   * @param response 
	   *            ServletResponse 
	   * @throws ServletException  
	   */  
	  private void checkRequestResponse(ServletRequest request,  
	          ServletResponse response) throws ServletException {  
	      if (!(request instanceof HttpServletRequest)) {  
	          throw new ServletException("Can only process HttpServletRequest");  

	      }  
	      if (!(response instanceof HttpServletResponse)) {  
	          throw new ServletException("Can only process HttpServletResponse");  
	      }  
	  }  
	
}
