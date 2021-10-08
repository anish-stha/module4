package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserRetrieve", value = "/user_retrieval")
@MultipartConfig
public class UserRetrievalServlet extends HttpServlet{

    UserService userService;

    public UserRetrievalServlet() {
        super();
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        final PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        UserDao userDao = userService.retrieveUser(name);
        out.println("<img src='https://i.imgur.com/bxjuH1P.gif'></img>");
        out.println("<h1>" + "Welcome " + userDao.name +"</h1>");
        out.println("<div>" + "Your name:" + userDao.name + "</div>");
        out.println("<div>" + "Your email:" + userDao.email + "</div>");
        out.println("<div>" + "Your location:" + userDao.location + "</div>");
        out.println("<div>" + "Your gender:" + userDao.gender + "</div>");
        out.println("<div>" + "Your experience:" + userDao.experience + "</div>");
    }
}
