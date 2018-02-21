package CookieAndSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "SaveCarSessionServlet",urlPatterns = "/savecar")
public class SaveCarSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int intName=Integer.parseInt(name);
        String[] products = new String[]{"小裙子","帽子","头饰"};
        String curPro = products[intName];

        HttpSession session = request.getSession();
        Map<String,Integer> car = (Map<String, Integer>) session.getAttribute("car");
        if(car!=null){
            //添加过商品
            Integer count = car.get(curPro);
            if(count==null) count=1;
            else  count++;
            car.put(curPro,count);
        }else{
            car = new LinkedHashMap<String,Integer>();
            car.put(curPro,1);
        }
        session.setAttribute("car",car);
        response.sendRedirect("/shoplistpicup.jsp");
    }
}
