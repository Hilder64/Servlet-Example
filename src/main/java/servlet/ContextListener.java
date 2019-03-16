package servlet;

import model.entity.User;
import util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, User> users;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext =
                servletContextEvent.getServletContext();
        users = new ConcurrentHashMap<>();
        servletContext.setAttribute("users", users);

        final User user = Utils.createStubUser(1, "TestName", 18);
        users.put(user.getId(), user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /*
        in this method you can close connection to database
         */
        users = null;
    }
}
