/*
package dao;

import dto.TovarListDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TovarListDAO extends DataBase {
    private Connection connection;
    private Statement statement;

    public List<TovarListDTO> selectQuery(String query) {
        ResultSet resultSet=null;
        List<TovarListDTO> showTovarList = new ArrayList<TovarListDTO>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                showTovarList.add(new TovarListDTO(resultSet.getInt("id"),
                        resultSet.getString("name"),resultSet.getInt("cost")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return showTovarList;
    }

    public void insertQuery(TovarListDTO tovarListDTO){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,login,password);
            statement=connection.createStatement();
            statement.execute("insert into tovar_list(name,cost) values ('"+tovarListDTO.getName()+"',"+tovarListDTO.getCost()+");");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }



}
*/
