package servletAndContextAndConfigLearn;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * httpServlet的核心设计思想
 */
public abstract class MyHttpServlet extends MyGenericServlet {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //优化1：开发时都是基于http协议很少其他协议，而且服务器在service中传给我的servletRequest对象实际就是httpServletRequest对象
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        try{
            request = (HttpServletRequest) servletRequest;
            response = (HttpServletResponse) servletResponse;

            service(request,response);

        }catch (Exception e){

        }
    }
    public void service(HttpServletRequest req, HttpServletRequest rep) throws ServletException, IOException {
        //优化2：根据请求方式不同做不同事情
        //1 获得请求方式
        String method = req.getMethod(); //GET or POST
        if(method.equals(METHOD_GET)){
         doGet(req,rep);
        }else if(method.equals(METHOD_POST)){
            doPost(req,rep);
        }
        //2 调用不同方法
    }

    public void doGet(HttpServletRequest req, HttpServletRequest rep){
        //不设计为抽象方法  让用户自己重写需求方法
    }

    public void doPost(HttpServletRequest req, HttpServletRequest rep){

    }

}
