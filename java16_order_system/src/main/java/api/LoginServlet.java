package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import model.UserDao;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public String password;
    }

    static class Response {
        public int ok;
        public String reason;
        public String name;
        public int isAdmin;
    }

    // 登陆功能 API
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            // 1. 读取 body 数据
            String body = OrderSystemUtil.readBody(req);
            // 2. 将读取的数据解析成对象
            Request request = gson.fromJson(body, Request.class);
            // 3. 按照用户名进行查找, 并校验密码
            UserDao userDao = new UserDao();
            User user = userDao.selectByName(request.name);
            if (user == null || !user.getPassword().equals(request.password)) {
                throw new OrderSystemException("用户名或密码错误");
            }
            // 5. 如果登陆成功, 就创建 session 对象. [重要]
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = user.getIsAdmin();
        } catch (OrderSystemException e) {
            // 4. 如果登陆失败, 返回错误提示
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            // 6. 结果写回给客户端
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    // 对应到检测登陆状态 API
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            // 1. 获取用户当前的 session, 如果 session 不存在, 认为未登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("当前未登录");
            }
            // 2. 从 session 中获取 user 对象
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("当前未登录");
            }
            // 3. 把 user 中的信息填充进返回值结果中.
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = user.getIsAdmin();
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}