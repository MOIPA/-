package servletAndContextAndConfigLearn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

@WebServlet(name = "servletAndContextAndConfigLearn.UseServletContext")
public class UseServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> initParameterNames = getServletContext().getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String value = getServletContext().getInitParameter(initParameterNames.nextElement());
            //获取配置作用
        }

        //使用servletContext通讯
        ServletContext sc = getServletContext();
        sc.setAttribute("bag","lv");

        //获取资源  /:代表了项目根目录
        InputStream resource = sc.getResourceAsStream("/WEB-INF/stu.xml");
        //获得资源绝对路径
        String realPath = sc.getRealPath("/WEB-INF/stu.xml");


    }
}
