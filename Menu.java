
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

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private double menuPrice;

    //Constructor Method
    public Menu(int _menuId, String _menuItem, double menuPrice){
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.menuPrice = menuPrice;
    }

    //Setters and Getters
    public int getmenuId() { return menuId; }
    public void setmenuId(int _menuId) {this.menuId = _menuId;}

    public String getmenuItem() { return menuItem; }
    public void setmenuItem(String _menuItem) {this.menuItem = _menuItem;}

    public double getmenuPrice() { return menuPrice; }
    public void setmenuPrice(int _menuPrice) {this.menuPrice = _menuPrice;}

    //method used to print all menus
    public static void listMenu(ArrayList<Menu> mList){
        for (Menu menu: mList){
            System.out.println(menu.getmenuId() + ":- " +menu.getmenuItem() + "$-" + menu.getmenuPrice());
        }
    }
}
