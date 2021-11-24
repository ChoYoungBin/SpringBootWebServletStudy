package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);
        //[header]
        response.setHeader("Content-type", "text/plain;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        //편의Method - Header
        //content(response);

        //편의Method - Cookie
        //cookie(response);

        //편의Method - Redirect
        //redirect(response);

        //Body
        PrintWriter writer = response.getWriter();
        writer.println("안녕하세요");
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);//600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //basic
        //response.setStatus(HttpServletResponse.SC_FOUND);
        //response.setHeader("Location","/basic/hello-form.html");

        //more easy
        response.sendRedirect("/basic/hello-form.html");
    }
}
