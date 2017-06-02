package com.pvirtech.filejumper.controller.common.filter;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域过滤器 
 */
public class SimpleCORSFilter implements Filter {
	
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        chain.doFilter(req, res);
    }
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
    
}
