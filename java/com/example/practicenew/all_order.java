package com.example.practicenew;

public class all_order {

    String orderNumber;
    String username;
    String orderStatus;
    String orderDate;
    int image;

    public all_order(String orderNumber, String username,  String orderDate, String orderStatus,int image ) {
        this.orderNumber = orderNumber;
        this.username = username;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.image = image;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getUsername() {
        return username;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public int getImage() {
        return image;
    }

}
