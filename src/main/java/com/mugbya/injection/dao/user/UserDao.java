package com.mugbya.injection.dao.user;

import com.mugbya.injection.entity.User;
import com.mugbya.injection.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mugbya on 2015/3/30.
 */
public class UserDao implements IUserDAO {
    @Override
    public int save(User entity) throws Exception {
        return 0;
    }

    @Override
    public int update(User entity) throws Exception {
        return 0;
    }

    @Override
    public int delete(String  id) throws Exception {
        return 0;
    }

    @Override
    public User findById(String  id) throws Exception {
        String sql = "select * " +"from user " + "where id = " + id;
        User user  = null;
        Connection conn = null;
        Statement stat = null;
        ResultSet rst = null;
        try {
            conn = DBUtil.getConnection();
            stat = conn.createStatement();
            rst = stat.executeQuery(sql);

            System.out.println(" 执行的sql 语句 : " + sql);

            if(rst.next()){
                user = new User();
                user.setId(rst.getInt("id"));
                user.setUsername(rst.getString("username"));
            }

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            DBUtil.close(conn);
        }

        return user;
    }

    @Override
    public List<User> findAll() throws Exception {

        return null;
    }

}
