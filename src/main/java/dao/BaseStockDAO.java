package dao;

import dto.BaseStockDTO;
import dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseStockDAO extends DataBase {

    private String url = "jdbc:mysql://127.0.0.1:3306/basement?useUnicode=true&serverTimezone=UTC&useSSL=FALSE&verifyServerCertificate=false";
    private String password = "root";
    private String login = "root";

    private Connection connection;
    private Statement statement;



    public List<BaseStockDTO> selectQuery(String query) {
        ResultSet resultSet = null;
        List<BaseStockDTO> stock = new ArrayList<BaseStockDTO>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                stock.add(new BaseStockDTO(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("number"), resultSet.getInt("summa")));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }
        return stock;
    }


    public List<BaseStockDTO> selectJoinQuery(String query) {
        ResultSet resultSet = null;
        List<BaseStockDTO> stock = new ArrayList<BaseStockDTO>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                stock.add(new BaseStockDTO(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("amount"),resultSet.getInt("summa")));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {

                statement.close();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        return stock;
    }



    public void crudMethod(String query) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }
    }

    public void insertQuery(BaseStockDTO baseStockDTO){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,login,password);
            statement=connection.createStatement();
            statement.execute("insert into base_stock(name,amount) " +
                    "values('"+baseStockDTO.getName()+"',"+baseStockDTO.getAmount()+");");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }
    }

    public void updateQuery(BaseStockDTO baseStockDTO,String query){
        try {
            connection=DriverManager.getConnection(url,login,password);
            statement=connection.createStatement();
            statement.execute(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void updateQuery(String query){
        try {
            connection=DriverManager.getConnection(url,login,password);
            statement=connection.createStatement();
            statement.execute(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
