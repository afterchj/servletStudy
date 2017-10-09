package com.tpadsz.servlet;

import com.tpadsz.servlet.entity.User;
import com.tpadsz.servlet.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "editUI", urlPatterns = {"/editUI"})
public class Edit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        UserService service = new UserService();
        System.out.println("autoComplete测试onSearch");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.getById(id);
        if (null != user) {
            request.setAttribute("user", user);
            //response.getWriter().print(user.getName());
            request.getRequestDispatcher("modify.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
