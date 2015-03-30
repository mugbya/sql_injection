package com.mugbya.injection.web;

import com.mugbya.injection.dao.user.UserDao;
import com.mugbya.injection.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mugbya on 2015/3/27.
 */
public class ActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String uri = req.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
        if ("/user".equals(action)){
            String  id = req.getParameter("id");
            System.out.println(id);

            UserDao dao = new UserDao();
            try{
                User user = dao.findById(id);
                if (user != null){
                    req.setAttribute("user",user);
                }else{
                    req.setAttribute("user","暂无记录");
                }
                req.getRequestDispatcher("WEB-INF/jsp/userDetail.jsp").forward(req,resp);
            }catch (Exception e){
                throw new RuntimeException("error");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
