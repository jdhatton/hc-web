package com.hc.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class IndexController implements ErrorController{

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;
    
    @Override
    public String getErrorPath() {
        return PATH;
    }
    
    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring. 
        // Here we just define response body.
    	
        return new ErrorJson(response.getStatus(), getErrorAttributes(request, true));
    }
    
    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
    
    public class ErrorJson {

        public Integer status;
        public String error;
        public String message;
        public String timeStamp;
        public String trace;

        public ErrorJson(int status, Map<String, Object> errorAttributes) {
        	System.out.println("\n ERROR: errorAttributes =  "+ errorAttributes);
            this.status = status;
            this.error = (String) errorAttributes.get("error");
            this.message = (String) errorAttributes.get("message");
            this.timeStamp = errorAttributes.get("timestamp").toString();
            this.trace = (String) errorAttributes.get("trace");
        }

    }
}
