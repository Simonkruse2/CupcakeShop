/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


/**
 *
 * @author Jakob, Vincent, Renz, Simon.
 */
public class User {
    private String username;
    private String password;
    private String email;
    private ShoppingCart cart;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
    

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + '}';
    }

}
