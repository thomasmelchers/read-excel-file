package com.thomasmelchers.models;

public class Sale {

    private String teaName;
    private String teaOrigin;
    private String customer;
    private double quantity;
    private double price;
    private double total;

    public Sale() {}

    public Sale(String teaName, String teaOrigin, String customer, double quantity, double price, double total) {
        this.teaName = teaName;
        this.teaOrigin = teaOrigin;
        this.customer = customer;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaOrigin() {
        return teaOrigin;
    }

    public void setTeaOrigin(String teaOrigin) {
        this.teaOrigin = teaOrigin;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @java.lang.Override
    public String toString() {
        return "Sale{" +
                "teaName='" + teaName + '\'' +
                ", teaOrigin='" + teaOrigin + '\'' +
                ", customer='" + customer + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}

