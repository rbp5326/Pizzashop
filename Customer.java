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
import java.util.Scanner;

public class Customer {
    //Class Level Variables - Protect the data
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;

    //Constructor Method
    public Customer(int _customerId) {
        this. customerId = _customerId;  //Increments the ID count
    }

    //Setters and Getters
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int _customerId) {this.customerId = _customerId;}

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String _customerName) {this.customerName = _customerName;}

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String _customerPhoneNumber) {this.customerPhoneNumber = _customerPhoneNumber;}

    //method used to print all available customers
    public static void printCustomer(ArrayList<Customer> cList){
        for (Customer cust: cList){
            System.out.println("Customer Id:" + cust.getCustomerId());
            System.out.println("Customer Name:" + cust.getCustomerName());
            System.out.println("Customer Phone:" + cust.getCustomerPhoneNumber());
        }
    }

}
