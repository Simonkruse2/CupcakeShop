/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class Cupcake {
    private int price;
    private CakeBottom bottom;
    private CakeToppings toppings;

    public Cupcake(int price, CakeBottom bottom, CakeToppings toppings) {
        this.price = price;
        this.bottom = bottom;
        this.toppings = toppings;
    }

    public int getPrice() {
        return price;
    }

    public CakeBottom getBottom() {
        return bottom;
    }

    public CakeToppings getToppings() {
        return toppings;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBottom(CakeBottom bottom) {
        this.bottom = bottom;
    }

    public void setToppings(CakeToppings toppings) {
        this.toppings = toppings;
    }

    
    
    
}
