package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체] Parameter 조회");
        Enumeration<String> parameterNames = request.getParameterNames();
        parameterNames.asIterator().forEachRemaining(paramName -> System.out.println(paramName +" : " + request.getParameter(paramName)));

        System.out.println("[개별] Parameter 조회");
        String wow = request.getParameter("wow");
        System.out.println("wow : " + wow);

        System.out.println("[이름이 같은 복수의 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username : " + name);
        }

        response.getWriter().write("ok");
    }
}
