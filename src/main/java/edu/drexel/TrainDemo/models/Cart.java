package edu.drexel.TrainDemo.models;

// import java.math.BigDecimal;
// import java.math.BigInteger;
// import java.sql.Time;
import java.util.List;

//import org.springframework.data.util.Pair;

public class Cart {
   
    private List<CartItem> Items;

    public Cart(List<CartItem> items) {
        Items = items;
    }

    public List<CartItem> getItems() {
        return Items;
    }

    public void setItems(List<CartItem> items) {
        Items = items;
    }

    @Override
    public String toString() {
        return "Cart [Items=" + Items + "]";
    }

    

}

