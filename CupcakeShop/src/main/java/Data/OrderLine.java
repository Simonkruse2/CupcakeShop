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
public class OrderLine {
    private Cupcake cupcake;
    private int quantity;

    public OrderLine(Cupcake cupcake, int quantity) {
        this.cupcake = cupcake;
        this.quantity = quantity;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
