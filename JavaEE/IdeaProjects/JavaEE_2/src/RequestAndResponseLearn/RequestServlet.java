package RequestAndResponseLearn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestServlet",urlPatterns = "/req")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得提交的数据
        String name = request.getParameter("name");
        System.out.println(name);

        Enumeration<String> parameterNames = request.getParameterNames();

        //请求转发
        request.getRequestDispatcher("/AServlet").forward(request,response);

//        请求包含
        request.getRequestDispatcher("/AServlet").include(request,response);
//        byte[] bytes = name.getBytes("ISO-8859-1");
//        String newName = new String(bytes, "utf-8");
//        System.out.println(newName);

//        response.sendRedirect();


    }
}
