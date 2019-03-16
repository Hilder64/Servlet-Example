package servlet;

import model.entity.User;
import util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AddUserServlet extends HttpServlet {

    private Map<Integer, User> users;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {

        final Object users = getServletContext().getAttribute("users");

        if (users == null || !(users instanceof ConcurrentHashMap)) {
            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }

        id = new AtomicInteger(2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        if (Utils.requestIsValid(req)) {
            final String name = req.getParameter("name");
            final String age = req.getParameter("age");

            final User user = new User();
            final int id = this.id.getAndIncrement();
            user.setId(id);
            user.setName(name);
            user.setAge(Integer.valueOf(age));

            users.put(id, user);
        }
        resp.sendRedirect(req.getContextPath() + '/');
    }
}
