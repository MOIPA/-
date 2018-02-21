package servletAndContextAndConfigLearn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletAndContextAndConfigLearn.test",urlPatterns = "/servletAndContextAndConfigLearn.test")
public class test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String realPath = sc.getRealPath("/WEB-INF/stu.xml");
        System.out.println(realPath);
    }
}
