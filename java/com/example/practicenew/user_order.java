package com.example.practicenew;

public class user_order {
    String orderNumber;
    String orderDate;
    String orderStatus;
    int image;

    public user_order(String orderNumber, String orderDate, String orderStatus,int image ) {
        this.orderNumber = orderNumber;
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
    public String getOrderStatus() {
        return orderStatus;
    }
    public int getImage() {
        return image;
    }

}
