package com.rachman.ch5;

import com.rachman.data_access.DAO_MySQL;
import com.rachman.data_access.UserDAO_MySQL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewUsersServlet", value = "/view-users")
public class ViewUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO_MySQL user_data = new UserDAO_MySQL();
        user_data.getAll();
        request.setAttribute("users", user_data.getAll());
        request.getRequestDispatcher("WEB-INF/ch5/view-users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
