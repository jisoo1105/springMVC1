package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

//일반적으로 Servlet 객체명은 클래스명과 동일하게 사용한다.
//다만, 첫번째 글자를 소문자로 변경하여 등록한다.
@WebServlet(name="helloServlet", urlPatterns = "/hello") //name : 사용할 Servlet 객체명 , urlPatterns : 매핑할 url 주소
public class HelloServlet extends HttpServlet {

    @Override // Servlet이 호출되면 service 메소드가 호출된다.
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //비즈니스 로직
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);

    }
}
