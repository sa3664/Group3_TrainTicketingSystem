package edu.drexel.TrainDemo.models;

import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.Time;
//import java.util.List;

//import org.springframework.data.util.Pair;

public class CartItem {
   
    private Integer index;
    private Path path;
    private BigDecimal price;

    public CartItem() {
    }

   

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public CartItem(Integer index, Path path, BigDecimal price) {
        this.index = index;
        this.path = path;
        this.price = price;
    }

}

