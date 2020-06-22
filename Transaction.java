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

enum PaymentType {cash, credit}

public class Transaction {

    //Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType pType;

    //Constructor Method
    public Transaction(int _transactionId, Order _order, PaymentType _pType){
        this.transactionId = _transactionId;
        this.order = _order;
        this.pType = _pType;
    }

    //Setters and Getters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int _transactionId) {this.transactionId = _transactionId;}

    public Order getOrder() { return order; }
    public void setOrder(Order _order) {this.order = _order;}

    public PaymentType getPaymentType() { return pType; }
    public void setPaymentType(PaymentType _pType) {this.pType = _pType;}

    //Method used ot print transactions with relevant order
    public static void listTransactions(ArrayList<Transaction> tList){
        for (Transaction trans: tList){
            System.out.println("Transaction ID: " + trans.getTransactionId());

            Order order = trans.getOrder();
            //print menus
            for (Menu menu: order.getItems()){
                System.out.println(menu.getmenuId() + ":- " +menu.getmenuItem() +"|" + menu.getmenuPrice());
            }
            System.out.println("Payment Type: " + trans.getPaymentType());
        }
    }

}
