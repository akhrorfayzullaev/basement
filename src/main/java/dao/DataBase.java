package dao;

import dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/kinoteatr";
        String password = "root";
        String login = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, password,login);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from films ;");
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id")+" ");
                System.out.print(resultSet.getString("name_of_film")+" ");
                System.out.print(resultSet.getString("dlina")+" ");
                System.out.print(resultSet.getInt("reyting")+" ");
                System.out.print(resultSet.getString("stoimost_bileta")+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
