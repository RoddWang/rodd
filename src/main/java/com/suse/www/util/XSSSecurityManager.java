/**
 * 
 */
package com.suse.www.util;

import java.util.Iterator;
import java.util.regex.Pattern;

import javax.servlet.FilterConfig;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.suse.www.entity.XSSSecurityCon;
import com.suse.www.entity.XSSSecurityConfig;


/**
 * @ClassName: XSSSecurityManager.java
 * @Description: TODO
 * @author: Rodd(Wang,Jian)
 * @email jian.wang2@hpe.com
 * @date Jan 5, 2017 10:57:27 AM
 */
public class XSSSecurityManager {
private static Logger logger = Logger.getLogger(XSSSecurityManager.class);  
    
    /** 
     * REGEX：Check the regular expression 
     */  
    public static String REGEX;  
      
     /** 
     * Special characters matching
     */  
    private static Pattern XSS_PATTERN ;  
      
      
    private XSSSecurityManager(){  
        //Cannot be instantiated  
    }  
      
    public static void init(FilterConfig config){  
        logger.info("XSSSecurityManager init(FilterConfig config) begin");  
        //init filter config file 
        String xssPath = config.getServletContext().getRealPath("/")  
                + config.getInitParameter("securityconfig");  
          
        // Initialize the security filter configuration  
        try {  
            if(initConfig(xssPath)){  
                // Generate the verifier 
                XSS_PATTERN = Pattern.compile(REGEX);  
            }  
        } catch (DocumentException e) {  
            logger.error("Security filter configuration file <xss_security_config.xml> Loading exception",e);  
        }  
        logger.info("XSSSecurityManager init(FilterConfig config) end");  
    }  
      
    /** 
     * Read the security audit configuration filexss_security_config.xml 
     * set XSSSecurityConfig config information
     * @param The configuration file path: eg C:/apache-tomcat-6.0.33/webapps/security_filter/WebRoot/config/xss/xss_security_config.xml 
     * @return  
     * @throws DocumentException 
     */  
    @SuppressWarnings("unchecked")  
    public static boolean initConfig(String path) throws DocumentException {  
        logger.info("XSSSecurityManager.initConfig(String path) begin");  
        
        Element superElement = new SAXReader().read(path).getRootElement();  
        XSSSecurityConfig.IS_CHECK_HEADER = new Boolean(getEleValue(superElement,XSSSecurityCon.IS_CHECK_HEADER));  
        XSSSecurityConfig.IS_CHECK_PARAMETER = new Boolean(getEleValue(superElement,XSSSecurityCon.IS_CHECK_PARAMETER));  
        XSSSecurityConfig.IS_LOG = new Boolean(getEleValue(superElement,XSSSecurityCon.IS_LOG));  
        XSSSecurityConfig.IS_CHAIN = new Boolean(getEleValue(superElement,XSSSecurityCon.IS_CHAIN));  
        XSSSecurityConfig.REPLACE = new Boolean(getEleValue(superElement,XSSSecurityCon.REPLACE));  
  
        Element regexEle = superElement.element(XSSSecurityCon.REGEX_LIST);  
          
        if(regexEle != null){  
            Iterator<Element> regexIt = regexEle.elementIterator();  
            StringBuffer tempStr = new StringBuffer("^");  
            //XML cdata tags to transmit data, will be the default before \ add a \,so  need to replace \ \ become \
            while(regexIt.hasNext()){  
                Element regex = (Element)regexIt.next();  
                String tmp = regex.getText();  
                tmp = tmp.replaceAll("\\\\\\\\", "\\\\");  
                tempStr.append(tmp);  
                tempStr.append("|");  
            }  
            if(tempStr.charAt(tempStr.length()-1)=='|'){  
                REGEX= tempStr.substring(0, tempStr.length()-1)+"$";  
                logger.info("Security matching rules "+REGEX);  
            }else{  
                logger.error("Security filter configuration file loaded failure: regular expressions  "+tempStr.toString());  
                return false;  
            }  
        }else{  
            logger.error("No security filter configuration file "+XSSSecurityCon.REGEX_LIST+" attribute");  
            return false;  
        }  
        logger.info("XSSSecurityManager.initConfig(String path) end");  
        return true;  
  
    }  
      
    /** 
     * From the target element in the specified tag information, if can't find the label, record the error log
     * @param element The target node 
     * @param tagName Make the label
     * @return  
     */  
    private static String getEleValue(Element element, String tagName){  
        if (isNullStr(element.elementText(tagName))){  
            logger.error("No security filter configuration file "+XSSSecurityCon.REGEX_LIST+" attribute");  
        }  
        return element.elementText(tagName);  
    }  
      
    /** 
     * To replace illegal characters
     * @param text 
     * @return 
     */  
    public static String securityReplace(String text){  
        if(isNullStr(text)){  
            return text;  
        }else{  
            return text.replaceAll(REGEX, XSSSecurityCon.REPLACEMENT);  
        }  
    }  
      
    /** 
     * If matching characters contain special characters 
     * @param text 
     * @return 
     */  
    public static boolean matches(String text){  
        if(text==null){  
            return false;  
        }  
        return XSS_PATTERN.matcher(text).matches();  
    }  
      
    /** 
     * Release the key information
     */  
    public static void destroy(){  
        logger.info("XSSSecurityManager.destroy() begin");  
        XSS_PATTERN = null;  
        REGEX = null;  
        logger.info("XSSSecurityManager.destroy() end");  
    }  
      
    /** 
     * Determine whether it is an empty string
     * @param value 
     * @return 
     */  
    public static boolean isNullStr(String value){  
        return value == null || value.trim().equals("");  
    } 
}
