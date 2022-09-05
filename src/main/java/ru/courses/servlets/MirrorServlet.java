package ru.courses.servlets;

import ru.courses.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<String, Object> pageVariables = new HashMap<>();
//
//        String key = req.getParameter("key");
//
//        if (key == null || key.isEmpty()) {
//            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        } else {
//            resp.setStatus(HttpServletResponse.SC_OK);
//        }
//        pageVariables.put("key", key == null ? "" : key);
//
//        resp.getWriter().println(PageGenerator.getInstance().getPage("mirror.html", pageVariables));
//
//        resp.setContentType("text/html;charset=utf-8");
//        resp.setStatus(HttpServletResponse.SC_OK);

        resp.getWriter().println(req.getParameter("key"));
    }
}
