package edu.drexel.TrainDemo.models;

public class CartItem {
   
    private String index;
    private Path path;
    private double price;

    public CartItem() {
    }

   

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public CartItem(String index, Path path, Double price) {
        this.index = index;
        this.path = path;
        this.price = price;
    }

}

