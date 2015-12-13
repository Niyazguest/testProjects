package ru.niyaz.testservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * Created by user on 13.12.15.
 */
public class ReverseWordServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write(new StringBuilder(request.getParameter("word")).reverse().toString());
        } catch (Exception ex) {
            return;
        }
    }
}
