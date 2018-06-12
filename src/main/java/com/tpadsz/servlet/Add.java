package com.tpadsz.servlet;

import com.tpadsz.servlet.entity.User;
import com.tpadsz.servlet.test.MyBatisTest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "add", urlPatterns = {"/add"})
public class Add extends HttpServlet {
    public Add() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        MyBatisTest test = new MyBatisTest();
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("id==========》"+request.getParameter("id"));
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        test.add();
        out.print("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
