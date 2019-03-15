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
 * @author Jakob, Vincent, Renz, Simon.
 */
public class DataAccessObject_Impl {

    /**
     * Inserts a customer into the database(mySQL). 
     * Balance is by default 0.
     * Remember to call this method before createUser, since email is a primary key set in the customer table.
     * @param email email is drawn from a textfield.
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
     * Inserts a user into the database(mySQL). 
     * Remember to call this method after createCustomer, 
     * since email is a foreign key set in createCustomer
     * @param username input drawn from a textfield.
     * @param password input drawn from a textfield.
     * @param email input drawn from a textfield.
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
     * Checks whether the input username and password matches in the database(mySQL).
     * @param username input drawn from a textfield.
     * @param password input drawn from a textfield.
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
     * Returns a user.
     * @param username is drawn from the database with a query.
     * @return the specified user.
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
     * Returns all cupcakebottoms. 
     * Returns cupcakebottoms from the database(mySQL), so they can be displayed in a jsp.
     * @return an ArrayList that holds all the cupcakebottoms.
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
     * Returns all cupcaketoppings. 
     * Returns cupcaketoppings from the database(mySQL), so they can be displayed in a jsp.
     * @return an ArrayList that holds all the cupcaketoppings.
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
     * Returns a customer.
     * The method is used to display balance and what user is currently logged in.
     * @param username input drawn from a textfield.
     * @return a user.
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
     * Creates an invoice in the database(mySQL).
     * Currently not in use anywhere.
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
     * Creates an orderline.
     * Currently not in use anywhere.
     * Meant to combine the cupcakebottom and cupcaketopping to create a cupcake with a price.
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

    /**
     * Updates a customers balance.
     * @param email Input is taken from a textfield.
     * @param custBalance The customers balance before adding any money.
     * @param balance The balance to be added to custBalance.
     */
    public void updateBalance(String email, int custBalance, int balance) {
        try {
            int amount = custBalance + balance;
            DBConnector c = new DBConnector();
            String query = "UPDATE customers "
                         + "SET Balance = "+ amount + " "
                         + "WHERE Email = '" + email + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
    
