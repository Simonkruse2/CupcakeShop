/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;


/**
 *
 * @author Jakob, Vincent, Renz, Simon.
 */
public class ShoppingCart {
    private ArrayList<OrderLine> orderLines = new ArrayList();

    public ShoppingCart(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    
    
}
