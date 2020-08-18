package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void add(User user) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();


        String sql = "insert into user values(null, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getIsAdmin());


            int ret = statement.executeUpdate();
            if(ret != 1) {
              throw new OrderSystemException("插入用户失败");
            }
            System.out.println("插入用户成功");
        } catch (SQLException | OrderSystemException e) {
            e.printStackTrace();
            System.out.println("插入用户失败");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();

        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);

            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按照姓名查找用户失败");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public User selectById(int userId) throws OrderSystemException{
        Connection connection = DBUtil.getConnection();

        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);

            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按照id查找用户失败");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /*public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("汤神");
        user.setPassword("123");
        user.setIsAdmin(0);
        //userDao.add(user);
        //System.out.println(userDao.selectByName("汤神").toString());
        System.out.println(userDao.selectById(1).toString());
    }*/
}
