package dao;

import dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class UserDAO extends DataBase {


    private Connection connection;
    private Statement statement;


    public List<UserDTO> selectQuery(String query) {
        ResultSet resultSet = null;
        List<UserDTO> users = new ArrayList<UserDTO>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                users.add(new UserDTO(resultSet.getInt("id"),resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("login"), resultSet.getString("password")));

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        return users;
    }






    public void insertUser(UserDTO user){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,login,password);
            statement=connection.createStatement();
            statement.execute("Insert into users(first_name,last_name,login,password) values('"+user.getFirst_name()
                    +"','"+user.getLast_name()+"','"+user.getLogin()+"','"+user.getPassword()+"');");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }



}
