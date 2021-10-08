package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserRegistration", value = "/user_registration")
@MultipartConfig
public class UserRegistrationServlet extends HttpServlet {

    private UserService userService;

    public UserRegistrationServlet() {
        super();
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/signup.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String gender = request.getParameter("gender");
        String experience = request.getParameter("experience");
        // Set response content type
        UserDao user = new UserDao();
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setLocation(location);
        user.setExperience(experience);
        userService.saveUser(user);
        response.setContentType("text/html");

        if (name != null && gender != null && email != null && location != null && experience != null) {
            // We have everything we need
            out.println("<img src='https://i.imgur.com/bxjuH1P.gif'></img>");
            out.println("<h1>" + "Welcome " + name +"</h1>");
            out.println("<div>" + "Your name:" + name + "</div>");
            out.println("<div>" + "Your email:" + email + "</div>");
            out.println("<div>" + "Your location:" + location + "</div>");
            out.println("<div>" + "Your gender:" + gender + "</div>");
            out.println("<div>" + "Your experience:" + experience + "</div>");
        } else {
            out.println("<h1>Your input info is not complete, try again <a href=\"user_registration\">Go back</a></h1>");
        }
    }
}