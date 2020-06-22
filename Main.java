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

public class Main {
    static int cCount = 1;
    static int oCount = 1;
    static int tCount = 1;
    private static ArrayList<Customer> cList = null;
    public static void main(String[] args) {

        Main main = new Main();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, List 'T'ransaction or 'E'xit: ";
        cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();
        //create customer and order
        Customer customer = new Customer(cCount);
        Order order1 = new Order(oCount, customer);
        Transaction trans1 = new Transaction(tCount, order1, PaymentType.cash);

        Menu menu1 = new Menu(1, "Plain", 5.0);
        Menu menu2 = new Menu(2, "Meat",10.0);
        Menu menu3 = new Menu(3, "Extra", 7.0);
        Menu menu4 = new Menu(4, "Veg", 13.0);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);

        oList.add(order1);
        tList.add(trans1);

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch(userAction) {
                case CUST_CODE : cList.add(main.addCustomer());
                    break;
                case CUST_PRNT : Customer.printCustomer(cList);
                    break;
                case MENU_CODE : Menu.listMenu(mList);
                    break;
                case ORDE_CODE : main.addNewOrder(mList, tList);
                    break;
                case TRAN_CODE : Transaction.listTransactions(tList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }

    //method used to get an action for the menu
    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    //method used to add new customer into customer list
    public Customer addCustomer(){
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        System.out.println("New customer added!");
        return cust;
    }

    //method used to add new order
    public void addNewOrder(ArrayList<Menu> mList, ArrayList<Transaction> tList){
        Scanner scnr = new Scanner(System.in);
        Customer customerOrder = null;
        //first of all select customer
        if(cList.isEmpty()){ //validation
            System.out.println("Please add customer first!");
        }
        else{ //select customer
            int counter = 1;
            System.out.println("Customer List:-");
            for (Customer cust : cList) {

                System.out.println(counter + "). " + cust.getCustomerName());
            }
            System.out.print("Select a customer > ");
            int selectCust = scnr.nextInt();

            customerOrder = cList.get(selectCust - 1);
            Order order = new Order(++oCount, customerOrder);//create new order for customer

            //select multiple items for customer order
            boolean more = true;
            while(more){
                Menu.listMenu(mList);//print menu
                System.out.println("Select item for order: ");
                int itemID = scnr.nextInt();
                Menu selectedMenu = mList.get(itemID - 1);
                order.addItem(selectedMenu);
                System.out.println("You selected " + selectedMenu.getmenuItem()
                        +" and it's price " + selectedMenu.getmenuPrice());
                System.out.println("Do you want to add more item, "
                        + "press n for no or anyother key for continue ");
                scnr.nextLine(); //skip new line
                String option = scnr.nextLine();
                if(option.equalsIgnoreCase("n")){
                    more = false; //terminate while loop
                }

            }
            //order is created

            System.out.print("Please selec" +
                    "ct transaction type\n1. Cash\n2. Credit\nSelect an option> ");
            int transType = scnr.nextInt();
            PaymentType type = PaymentType.credit;
            if(transType == 1){
                type = PaymentType.cash;
            }
            tList.add(new Transaction(++tCount, order, type));
            System.out.println("New order is created!");
            System.out.println("Order Details");
            System.out.println("Customer Name:" +order.getCustomer().getCustomerName());
            System.out.println("Your selected items");
            //print menu and it's price
            for(Menu menus: order.getItems()){
                System.out.println(menus.getmenuItem() +" Price: " + menus.getmenuPrice());
            }
            //print total price of order
            System.out.println("The total price of items = " + getOrderPrice(order.getItems()));
            System.out.println("Thank You for your order");
        }

    }

    //method used to calculate order price
    public static double getOrderPrice(ArrayList<Menu> items){
        double total = 0.0;
        for(Menu menu : items){

            total+= menu.getmenuPrice();
        }

        return total;
    }
}







