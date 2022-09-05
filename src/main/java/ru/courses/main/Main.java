package ru.courses.main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.courses.accounts.AccountService;
import ru.courses.accounts.UserProfile;
import ru.courses.servlets.AllRequestServlet;
import ru.courses.servlets.MirrorServlet;


public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("test"));

//        AllRequestServlet allRequestServlet = new AllRequestServlet();
//        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(allRequestServlet), "/*");
        //context.addServlet(new ServletHolder(mirrorServlet),"/mirror");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("templates");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
