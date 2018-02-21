package servletAndContextAndConfigLearn;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "servletAndContextAndConfigLearn.AServlet",urlPatterns = "/AServlet")
public class AServlet implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        this.config= servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("config");
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("service");
        String name  = getServletConfig().getServletName();
        Enumeration<String> en = getServletConfig().getInitParameterNames();
        servletResponse.getWriter().print(name);
        while(en.hasMoreElements()){
            String key = en.nextElement();
            String value = getServletConfig().getInitParameter(key);
            servletResponse.getWriter().println(key+"==>"+value);
        }

    }

    @Override
    public String getServletInfo() {
        System.out.println("info");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("des");
    }
}
