package main;

import dao.*;
import dto.BaseStockDTO;
import dto.TovarListDTO;
import dto.UserDTO;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private UserDAO userDAO = new UserDAO();
    private BaseStockDAO baseStockDAO = new BaseStockDAO();
    private TovarListDAO tovarListDAO = new TovarListDAO();
    private LogTools tools = new LogTools();


    public static void main(String[] args) {


        new Main().start();


    }

    public void start() {
        System.out.println("Welcome ");
        tools.logMessage("Welcome to out BaseMent ", 3);
        int choise = 0;

        while (choise != 4) {
            System.out.println("1) Sign up");
            System.out.println("2) Sign in");
            System.out.println("3) Show all users");
            System.out.println("4) Exit");
            choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    signUp();
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    showUsers();
                    break;
                default:
                    return;
            }


        }
    }

    private void signUp() {
        tools.logMessage("Sing up --------  method is started.......................................", 3);
        System.out.println(" First name # ");
        String firstName = scanner.next();
        if (firstName.trim().equals("")) {
            System.out.println("Empty firstname ");
            return;
        }



        System.out.println("Last name # ");
        String lastName = scanner.next();
        if (lastName.equals("")) {
            System.out.println("Empty lastName ");
            return;
        }


        System.out.println("Login # ");
        String login = scanner.next();
        if (login.equals("")) {
            System.out.println("Empty login");
            return;
        }



        System.out.println("Password # ");
        String password = scanner.next();
        if (password.equals("")) {
            System.out.println("Empty password ");
            return;
        }



        UserDTO userDTO = new UserDTO(firstName, lastName, login, password);
        userDAO.insertUser(userDTO);
        tools.logMessage(firstName+"   "+lastName+"     "+login+"    "+password + "registered successfully",3);
        System.out.println(" User registered successfully");

    }

    private void showUsers() {
        tools.logMessage("Using ----select method---- to showing all users",3);
        List<UserDTO> users = userDAO.selectQuery("select * from users;");
        for (int i = 0; i < users.size(); i++) {
            tools.logMessage(users.get(i).getFirst_name() + " " + users.get(i).getLast_name(),3);
            System.out.println(users.get(i).getFirst_name() + " " + users.get(i).getLast_name());
        }
        System.out.println();




    }

    private void signIn() {
        int choise = 0;
        System.out.println("Enter login #");
        String login = scanner.next();
        System.out.println("Enter password #");
        String password = scanner.next();
        List<UserDTO> users = userDAO.selectQuery("select * from users where login='" + login + "'");
        if (users.isEmpty()) {
            System.out.println(" Error, incorrect login.");
            return;
        }
        if (!password.equals(users.get(0).getPassword())) {
            System.out.println("Error , incorrect password ");
            return;
        } else {
            if (login.equals("Yigami")){

            }else if (login.equals("Axror")){

            }else if (login.equals("Bobur"))
            {

            }
            tools.logMessage("Sing in user "+login,3);
            while (choise != 6) {
                System.out.println("Welcome # " + users.get(0).getFirst_name() + " " + users.get(0).getLast_name());
                System.out.println();
                System.out.println("1) Ostatok");
                System.out.println("2) Prixod");
                System.out.println("3) Rasxod");
                System.out.println("4) Tovar_list");
                System.out.println("5) New_tovar");
                System.out.println("6) Back");

                choise = scanner.nextInt();
                switch (choise) {
                    case 1:
                        showOstatok();
                        break;
                    case 2:
                        addPrixod();
                        break;
                    case 3:
                        addRasxod();
                        break;
                    case 4:
                        showTovarList();
                        break;
                    case 5:
                        newTovar();
                        break;


                    default:
                        return;
                }
                System.out.println();
                System.out.println();

            }
        }


    }

    private void newTovar() {
        tools.logMessage("Selected new tovar ",3);
        System.out.println("Enter product name # ");
        String p_name = scanner.next();
        tools.logMessage("Entered tovar "+p_name,3);
        if (p_name.equals(tovarListDAO.selectQuery("select name from tovar_list where name='" + p_name + "';"))) {
            tools.logMessage("This product is already exist",3);
            System.out.println("This product already exist !");
        } else {
            System.out.println("Enter amount of new product # ");
            int amount;
            amount = scanner.nextInt();
            tools.logMessage("Entered "+amount+"of new tovar ",3);
            TovarListDTO tovarListDTO = new TovarListDTO(p_name, amount);
            tovarListDAO.insertQuery(tovarListDTO);
            tools.logMessage("New Tovar is successfully added to TovarList ",3);

        }

    }

    private void showTovarList() {
        tools.logMessage("ShowTovarList method  is activated ",3);
        List<TovarListDTO> showTovarList = tovarListDAO.selectQuery("select * from tovar_list;");
        for (int i = 0; i < showTovarList.size(); i++) {
            System.out.println("id= " + showTovarList.get(i).getId()
                    + ", name= " + showTovarList.get(i).getName() + ", cost= " + showTovarList.get(i).getCost());
        }
        tools.logMessage(showTovarList.toString(),3);
    }


    private void showOstatok() {
        tools.logMessage("Activated   ----------ShowOstatok method  ",3);
        List<BaseStockDTO> baseStock = baseStockDAO.selectJoinQuery("select * from base_stock;");
        for (int i = 0; i < baseStock.size(); i++) {
            System.out.println("id = " + baseStock.get(i).getId() +
                    ", name = " + baseStock.get(i).getName() + ", amount = " + baseStock.get(i).getAmount() + ";");
        }
        tools.logMessage(baseStock.toString(),3);
    }

    private void addPrixod() {
        tools.logMessage("Activated   ------ AddPrixod method ",3);
        System.out.print("Enter tovar # ");
        String t_name = scanner.next();
        System.out.print("Enter amount #");
        int t_amount = scanner.nextInt();
        BaseStockDTO addNewTovar = null;
        List<TovarListDTO> tovarListDTO = tovarListDAO.selectQuery("select * from tovar_list where name='" + t_name + "';");
        List<BaseStockDTO> baseStockDTO = baseStockDAO.selectQuery("select * from base_stock where name ='" + t_name + "';");
        if (baseStockDTO.isEmpty()) {
            addNewTovar = new BaseStockDTO(t_name, t_amount);
        }
        try {
            if (tovarListDTO.get(0).getName().equals(t_name)) {
                if (baseStockDTO.get(0).getName().equals(t_name)) {
                    baseStockDAO.updateQuery(addNewTovar, "update base_stock set amount = amount+" + t_amount +
                            " where name = '" + addNewTovar.getName() + "';");
                }

                BaseStockDTO newTovar = new BaseStockDTO(t_name, t_amount);
                baseStockDAO.insertQuery(newTovar);
            } else {
                System.out.println(" Error,  product is not exist ");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    private void addRasxod() {
        tools.logMessage("Activated ----AddRasxod  mwthod ----- ",3);
        System.out.print("Enter tovar # ");
        String name = scanner.next();
        if (name.equals(baseStockDAO.selectQuery("select name from base_stock where name= '" + name + "';"))) {
            tools.logMessage("Entering tovar +"+name+" ",3);
            System.out.println("Enter amount #");
            int amount = scanner.nextInt();
            List<BaseStockDTO> baseStockDTOS = baseStockDAO.selectQuery("select amount from base_stock where name='" + name + "';");
            if (amount > baseStockDTOS.get(0).getAmount()) {
                tools.logMessage("Error in entering amount of product",3);
                System.out.println("Error , amount exception");
                return;
            } else {
                baseStockDAO.updateQuery((BaseStockDTO) baseStockDTOS,
                        "update base_stock set amount ='amount" + (-amount) + "';");
                tools.logMessage("Using ----- UPDATE operation  ----- for changing amount to"+amount,3);

            }

        } else {
            System.out.println("Error, no exist tovar!");
            tools.logMessage("Error no exist tovar ",3);
        }
    }

}

