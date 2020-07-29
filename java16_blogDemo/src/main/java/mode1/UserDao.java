package mode1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
   public void add(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user values (null,?,?)";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            int ret = statement.executeUpdate();
            if(ret != 1) {
                System.out.println("插入新用户失败");
                return;
            }
            System.out.println("插入新用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public User selectByName(String name) {
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
                return user;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /*public static void main(String[] args) {
        /*UserDao userDao = new UserDao();
        User user = new User();
        user.setName("tz");
        user.setPassword("1234");
        userDao.add(user);*/
        /*UserDao userDao = new UserDao();
        User user = userDao.selectByName("tz");
        System.out.println(user);
    }*/
}
