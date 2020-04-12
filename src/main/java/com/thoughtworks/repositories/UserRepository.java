package com.thoughtworks.repositories;


import com.thoughtworks.entities.User;
import com.thoughtworks.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements UserRepositoryI {
    public static final String TABLE_NAME = "user";

    public User getUserByNameAndPassword(String userName, String password) {
        Connection connection = JDBCUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sqlQuery = "SELECT " +
                    "id, userName,password" +
                    " FROM " + TABLE_NAME + " WHERE userName = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            User fetchedUser = new User();
            if (resultSet.next()) {
                fetchedUser = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("password"));
            }
            if (password.equals(fetchedUser.getPassword())) {
                return fetchedUser;
            } else {
                return new User();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new User();
        } finally {
            JDBCUtil.releaseSource(connection, preparedStatement, resultSet);
        }
    }

    public void userRegister(User user) {
        Connection connection = JDBCUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            String sqlCmd = "INSERT INTO " + TABLE_NAME + "(userName,password) values(?,?)";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.releaseSource(connection, preparedStatement);
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = JDBCUtil.connectToDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sqlQuery = "SELECT " +
                    "id, userName,password" +
                    " FROM " + TABLE_NAME;
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.releaseSource(connection, preparedStatement, resultSet);
        }
        return users;
    }
}
