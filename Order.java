/*
Project: Lab 9
Purpose Details: Pizza ordering application
Course: IST 242
Author: Raj Patel
Date Developed: 6/14/20
Last Date Changed: 6/18/20
Rev: 2
 */

package edu.psu.abington.ist.ist242;


import java.util.ArrayList;

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer cust;
    private  ArrayList<Menu> menuItem;

    //Constructor Method
    public Order(int _orderId, Customer c){
        this.orderId = _orderId;
        this.cust = c;
        menuItem = new ArrayList<>();
    }

    //Setters and Getters
    public int getorderId() { return orderId; }
    public void setorderId(int _orderId) {this.orderId = _orderId;}
    public Customer getCustomer(){ return this.cust;}
    public ArrayList<Menu> getItems(){return menuItem;}
    //add menu item into an order
    public  void addItem(Menu menu){

        menuItem.add(menu);
    }
}
