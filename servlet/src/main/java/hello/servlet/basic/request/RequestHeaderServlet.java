package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extracted(request);

        showHeaders(request);

        showLocales(request);

        showCookies(request);

        showContents(request);

        showNetworkInfo(request);
    }

    private void showNetworkInfo(HttpServletRequest request) {
        String remoteHost = request.getRemoteHost();
        String remoteAddr = request.getRemoteAddr();
        int remotePort = request.getRemotePort();

        System.out.println("remoteHost = " + remoteHost);
        System.out.println("remoteAddr = " + remoteAddr);
        System.out.println("remotePort = " + remotePort);

        String localName = request.getLocalName();
        String localAddr = request.getLocalAddr();
        int localPort = request.getLocalPort();

        System.out.println("localName = " + localName);
        System.out.println("localAddr = " + localAddr);
        System.out.println("localPort = " + localPort);
    }

    private void showHeaders(HttpServletRequest request) {
          //예전방식
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + headerName);
//        }

        //요즘방식
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));
    }

    private void showLocales(HttpServletRequest request) {
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println(locale + " : " + locale));
    }

    private void showCookies(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + " :  " + cookie.getValue());
            }
        }
    }

    private void showContents(HttpServletRequest request) {
        String contentType = request.getContentType();
        int contentLength = request.getContentLength();
        String characterEncoding = request.getCharacterEncoding();

        System.out.println("contentType = " + contentType);
        System.out.println("contentLength = " + contentLength);
        System.out.println("characterEncoding = " + characterEncoding);
    }

    private void extracted(HttpServletRequest request) {
        String method = request.getMethod();
        String protocol = request.getProtocol();
        String scheme = request.getScheme();
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        boolean secure = request.isSecure();

        System.out.println("method = " + method);
        System.out.println("protocol = " + protocol);
        System.out.println("scheme = " + scheme);
        System.out.println("requestURL = " + requestURL);
        System.out.println("requestURI = " + requestURI);
        System.out.println("queryString = " + queryString);
        System.out.println("secure = " + secure);
    }
}
