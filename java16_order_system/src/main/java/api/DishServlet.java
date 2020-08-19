package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.DishDao;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public int price;
    }

    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            HttpSession session =  req.getSession(false);
            if(session == null) {
                throw new OrderSystemException("当前未登录");
            }
            User user = (User)session.getAttribute("user");
            if(user == null) {
                throw new OrderSystemException("当前未登录");
            }
            String body = OrderSystemUtil.readBody(req);
            Request request = gson.fromJson(body,Request.class);
            Dish dish = new Dish();
            dish.setName(request.name);
            dish.setPrice(request.price);
            DishDao dishDao = new DishDao();
            dishDao.add(dish);
            response.ok = 1;
            response.reason = "";
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
