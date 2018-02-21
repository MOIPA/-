package RequestAndResponseLearn;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Set;

@WebServlet(name = "ResponseServlet",urlPatterns = "/header")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //手动发送404
//        response.sendError(404,"找到了页面  测试404的");

        //重定向
//        response.setStatus(302);
//        response.setHeader("Location","/AServlet");
//        response.sendRedirect("/AServlet");

        //refresh
//        response.setHeader("refresh","5;url=/AServlet");
//        response.getWriter().print(
//                "<html>" +
//                "<header>" +
//                "</header>" +
//                "<body>" +
//                "<script type=\"text/javascript\">" +
//                "alert(\"hello jsp\")" +
//                "</script>" +
//                "</body>" +
//                "</html>");

//        //发送中文
//        OutputStream os = response.getOutputStream();
//        os.write("你好世界".getBytes());
//        os.close();
//
//        //发送中文2
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().print("你好世界");//输出？？？说明查找的码表没有这个字

//        发送图片
        //放在webinfo下别人无法绕过地址访问
//        String path = getServletContext().getRealPath("/WEB-INF/test.jpg");
//        response.getWriter().print(path);
        //告诉浏览器流的mime类型 这里是jpg
        response.setContentType("image/jpeg");
//        String path = getServletContext().getRealPath("/WEB-INF/test.jpg");
//        InputStream stream = getServletContext().getResourceAsStream("/WEB-INF/test.jpg");
//        URL url = getServletContext().getResource("/WEB-INF/test.jpg");
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/test.jpg");


        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=resourceAsStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
            outputStream.flush();
        }
        resourceAsStream.close();
//        stream.close();
        outputStream.close();


    }

}
