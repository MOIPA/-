package servletAndContextAndConfigLearn;

import javax.servlet.*;
import java.io.IOException;

/**
 *这就是GenericServlet设计思路
 */
public abstract class MyGenericServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        this.init();
    }

    public void init() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public abstract void  service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }

    public String getServletName(){
        return this.config.getServletName();
    }
    public String getInitParameter(String key){
        return this.config.getInitParameter(key);
    }

}
