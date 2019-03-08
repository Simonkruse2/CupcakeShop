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

    public ArrayList<Recipe> getRecipes(String name) {
        try {
            DBConnector c = new DBConnector();
            //       String query = "SELECT * FROM cupcake.CupcakeRecipes;";
            String query = "SELECT Name, Toppings, Bottom FROM `cupcake`.`CupcakeRecipes` WHERE Name LIKE '" + name + "';";
            ArrayList<Recipe> recipes = new ArrayList<>();
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String Name = rs.getString("Name");
                String toppings = rs.getString("Toppings");
                String bottom = rs.getString("Bottom");
                recipes.add(new Recipe(Name, toppings, bottom));
            }
            return recipes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

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
}
