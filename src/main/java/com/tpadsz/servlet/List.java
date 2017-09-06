package com.tpadsz.servlet;

import com.tpadsz.servlet.entity.User;
import com.tpadsz.servlet.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "list",
        urlPatterns = {"/list"}
)
public class List extends HttpServlet {
    public List() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        UserService service = new UserService();
        java.util.List users = service.getAll();
        System.out.println("autoComplete测试");
        if (users.size() > 0) {
            for (int i = 0; i < users.size(); ++i) {
                System.out.println("id=" + ((User) users.get(i)).getId() + ",name=" + ((User) users.get(i)).getName());
                //request.setAttribute();
                session.setAttribute("users", users);
            }
        }
        response.getWriter().print(users);
        response.sendRedirect("list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
