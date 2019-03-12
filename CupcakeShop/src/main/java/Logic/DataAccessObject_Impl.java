/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.CakeBottom;
import Data.CakeToppings;
import Data.Customer;
import Data.Recipe;
import Data.ShoppingCart;
import Data.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class DataAccessObject_Impl {

    /**
     * Opretter en customer i databasen(mySQL). Balance er sat til 0 pr.
     * default, email er givet som en parameter taget fra et tekstfelt. Vigtigt
     * at denne metode kaldes først, da email er en primarykey der bliver sat i
     * customertabellen i databasen.
     *
     * @param email
     */
    public void createCustomer(String email) {
        try {
            DBConnector c = new DBConnector();
            String query = "INSERT INTO customers(Balance,Email) "
                    + "VALUES(0, '" + email + "');";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Opretter en user i databasen(mySQL). username,password og email er input
     * trukket ud af et tekstfelt. Skal kaldes efter createCustomer, da email er
     * en foreign key sat i customertabellen.
     *
     * @param username
     * @param password
     * @param email
     */
    public void createUser(String username, String password, String email) {
        try {
            DBConnector c = new DBConnector();
            String query = "INSERT INTO users(Username,Password, Email) "
                    + "VALUES('" + username + "', '" + password + "', '" + email + "');";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Tjekker i databasen om input username matcher input password.
     *
     * @param username
     * @param password
     * @return true for login.
     */
    public boolean checkLogin(String username, String password) {
        String _password = "";
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT Password FROM `users` WHERE Username = '" + username + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                _password = rs.getString("Password");
            }
            return _password.equals(password);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Henter en user.
     *
     * @param username - søges frem i databasen med et String username som
     * query.
     * @return en given user
     */
    public User getUser(String username) {
        User u = null;
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * \n"
                    + "FROM users \n"
                    + "WHERE username = '" + username + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String _username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                u = new User(_username, password, email);

            }
            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Henter alle cupcakebunde. Henter cupcakebunde fra databasen, så de kan
     * displayes i en jsp.
     *
     * @return en ArrayList der indeholder alle cupcakebunde.
     */
    public ArrayList<CakeBottom> getBottom() {
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM cupcake.cakebottom;";
            ArrayList<CakeBottom> bottomArray = new ArrayList<>();
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String bottom = rs.getString("Bottom");
                int price = rs.getInt("Price");
                bottomArray.add(new CakeBottom(bottom, price));
            }
            return bottomArray;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Henter alle cupcaketoppings. Henter cupcaketoppings fra databasen, så de
     * kan displayes i en jsp.
     *
     * @return en ArrayList der indeholder alle cupcaketoppings.
     */
    public ArrayList<CakeToppings> getToppings() {
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM cupcake.caketoppings;";
            ArrayList<CakeToppings> toppingsArray = new ArrayList<>();
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String toppings = rs.getString("Toppings");
                int price = rs.getInt("Price");
                toppingsArray.add(new CakeToppings(toppings, price));
            }
            return toppingsArray;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Henter en given customer. Skal bruges til at vise bl.a. balance og hvem
     * der er logget ind.
     *
     * @param username - gives som et parameter, der bruges i sql queriet.
     * @return en given customer.
     */
    public Customer getCustomer(String username) {
        Customer u = null;
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * \n"
                    + "FROM users\n"
                    + "natural join customers\n"
                    + "WHERE username = '" + username + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int balance = rs.getInt("balance");
                String _username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                u = new Customer(balance, _username, password, email);

            }
            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param u
     */
    public void storeOrder(User u) {
        try {
            DBConnector c = new DBConnector();
            String query = "INSERT INTO invoice(Username,TotalPrice) "
                    + "VALUES('" + u.getUsername() + "', '" + u.getCart() + "');";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param shoppingCart
     * @param u
     */
    public void storeOrderline(ShoppingCart shoppingCart, User u) {

        try {
            DBConnector c = new DBConnector();
            for (int i = 0; i < shoppingCart.getOrderLines().size(); i++) {
                String query = "INSERT INTO orderline(Quantity,Cakebottom,Caketoppings,TotalPrice) "
                        + "VALUES(" + shoppingCart.getOrderLines().get(i).getQuantity() + ", '"
                        + shoppingCart.getOrderLines().get(i).getCupcake().getBottom()
                        + "', '" + shoppingCart.getOrderLines().get(i).getCupcake().getToppings() + "', "
                        + shoppingCart.getOrderLines().get(i).getCupcake().getPrice() + ");";
                Connection connection = c.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateBalance(User u, Customer cust, int balance) {
        try {
            DBConnector c = new DBConnector();
            String query = "UPDATE Balance \n"
                         + "SET ("+balance + cust.getBalance() + ")"
                         + "FROM customers \n"
                         + "WHERE email = '" + u.getEmail() + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
    
