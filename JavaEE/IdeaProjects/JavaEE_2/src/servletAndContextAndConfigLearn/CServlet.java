package servletAndContextAndConfigLearn;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletName = getServletConfig().getServletName();
        servletResponse.getWriter().print(servletName);
    }

    @Override
    public void init() {
//        super.init();
    }
}
