package CookieAndSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet",urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get current ping pai
        String name = request.getParameter("name");
        Cookie his = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for(Cookie c:cookies){
                if(c.getName().equals("history")){
                    his = c;
                }
            }
        }
        String value = "";
        if(his!=null){
            if(his.getValue().contains(name)){
                value = his.getValue();
            }else{
                value = his.getValue()+":"+name;
            }
        }else{
            value = name;
        }
        Cookie newHis = new Cookie("history",value);

        response.addCookie(newHis);
        request.setAttribute("history",value);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
        //get privious cookie
        //create new cookie
        //add cookie to new resp
        //put record to req
        //jump
    }
}
