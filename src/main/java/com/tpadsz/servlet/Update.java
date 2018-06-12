package com.tpadsz.servlet;

import com.tpadsz.servlet.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "update", urlPatterns = {"/update"})
public class Update extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("id==========》"+request.getParameter("id"));
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        if (!name.equals("") && !pwd.equals("")) {
            out.println("<script>alert(\'update successfully\');location.href=\'index.jsp\'</script>");
        } else {
            out.println("<script>alert(\'update failed\');history.back()</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
