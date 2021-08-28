package com.example.reza.pbobeta;

public class StockItem {
    private final String productName;
    private final String price;
    private final int quantity;
    private final String image;

    public StockItem(String productName, String price, int quantity, String image) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public String getImage() {
        return image;
    }
//    @Override
//    public String toString() {
//        return "StockItem{" +
//                "productName='" + productName + '\'' +
//                ", price='" + price + '\'' +
//                ", quantity=" + quantity +
//                '}';
//    }
}
