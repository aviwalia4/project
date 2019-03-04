package com.hexaware.FTP111.util;
//import com.hexaware.FTP111.util.Validators;
import java.util.Scanner;
import com.hexaware.FTP111.factory.CustomerFactory;
import com.hexaware.FTP111.model.Customer;
import com.hexaware.FTP111.factory.MenuFactory;
import com.hexaware.FTP111.model.Menu;
import com.hexaware.FTP111.factory.OrdersFactory;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.factory.VendorFactory;
import com.hexaware.FTP111.model.Vendor;
import com.hexaware.FTP111.model.MenuDetails;
import java.util.List;
import com.hexaware.FTP111.model.Wallet;
import com.hexaware.FTP111.factory.WalletFactory;
import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.model.OrderStatus;
//import com.hexaware.FTP111.util.Validators;

/**
* CliMain used as Client interface for java coading.
* @author hexware
 */

class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
* mainMenu method used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-------------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Item Details");
    System.out.println("3. Order Details");
    System.out.println("4. Vendor Detail");
    System.out.println("5. Customer Detail");
    System.out.println("6. Place Order");
    System.out.println("7. Pending Orders");
    //System.out.println("8. Update Status");
    System.out.println("0. Exit");
    mainMenuDetails();
  }
/**
* mainMenuDetails method process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          createOrder();
          break;
        case 3:
          orderDetails();
          break;
        case 4:
          vendorDetails();
          break;
        case 5:
          customerDetails();
          break;
        case 6:
          placeOrder();
          break;
        case 7:
          pendingOrders();
          break;
        case 0:
          Runtime.getRuntime().halt(0);
          break;
        default:System.out.println("Wrong option entered Choose either 1,2,3,4,5,6,7 or 0 for exit");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
* showFullMenu method display the menu item stored in database.
 */
  private void showFullMenu() {
//    Menu[] menu = MenuFactory.showMenu();
    List<Menu> menu = MenuFactory.showMenu();
    System.out.println("-----------------------------------------------------------------------------------------------");
    System.out.printf("%5s %20s %20s %20s %20s", "Menu Id", "Menu Food type", "Menu Veg/Non Veg", "Menu Item Name", "Calories");
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------------");
    for (Menu m : menu) {
      System.out.format("%5s %20s %20s %20s %20s", m.getMenItemId(), m.getMenFoodType(), m.getMenVegNonVeg(), m.getMenItemName(), m.getMenCalories());
      System.out.println();
    }
    System.out.println("---------------------------------------------------------------------------------------------");
  }

/**
* createOrder method display the menu item stored in database.
 */
  private void createOrder() {
    System.out.println("Enter food Id :");
    int foodId = option.nextInt();
    try {
      Validators.validateMenuItemId(foodId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    List<MenuDetails> foodlist = MenuFactory.getMenuDetails(foodId);
    System.out.println("--------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%10s %17s %10s %18s %15s %20s %15s", "Menu Item Id", "Menu Item Name", "Vendor Id", "Vendor Name", "Menu Price",
                   "Menu Vendor Rating", "Calories");
    System.out.println();
    System.out.println("---------------------------------------------------------------------------------------------------------------------");
    for (MenuDetails md : foodlist) {
      System.out.format("%10s %17s %10s %18s %15s %20s %15s", md.getMenItemId(), md.getMenItemName(), md.getVenId(), md.getVendorName(),
                        +Math.round(md.getMenVenPrice()), md.getMenVenRating(), md.getMenCalories());
      System.out.println();
    }
    System.out.println("---------------------------------------------------------------------------------------------------------------------");
  }
/**
*  method display all the items ordered by the customer.
 */
  private void orderDetails() {
    System.out.println("Order history: \n 1.Customer Order History \n 2. Vendor Order History");
    int choice = option.nextInt();
    if (choice == 1) {
      System.out.println("Enter Customer Id :");
      int cusId = option.nextInt();
      System.out.println("Enter Password");
      String cusPass = option.next();
      try {
        Validators.validateCustomerId(cusId, cusPass);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      List<Orders> orderlist = OrdersFactory.getOrderDetails(cusId);
      System.out.println("---------------------------------------------------------------------------------------------------"
          + "-----------------");
      System.out.printf("%5s %12s %18s %18s %15s %20s", "Order Id", "Vendor Name", "Vendor Id", "Wallet Trans Id",
                        "Order Total Price", "Order Status", "Order Date Time");
      System.out.println();
      System.out.println("------------------------------------------------------------------------------------------------------------");
      for (Orders o : orderlist) {
        System.out.format("%3s %12s %15s %15s %20s %22s", o.getOrderId(), o.getVendorName(), o.getVenId(), o.getWalTransId(),
            +Math.round(o.getOrderTotalPrice()), o.getOrderStatus(), o.getOrderDate());
        System.out.println();
      }
      System.out.println("-------------------------------------------------------------------------------------------------------------");
    } else if (choice == 2) {
      System.out.println("Enter the Vendor Id");
      int venId = option.nextInt();
      System.out.println("Enter the Vendor Password");
      String venPass = option.next();
      try {
        Validators.validateVenIdandPass(venId, venPass);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        System.out.println();
        mainMenu();
      }
      List<Orders> orderlist = OrdersFactory.showOrdersForVendor(venId);
      System.out.println("---------------------------------------------------------------------------------------------------"
              + "-----------------");
      System.out.printf("%5s %10s %15s %18s %15s %20s", "Order Id", "Customer Id", "Vendor Name", "Wallet Trans Id",
                            "Order Total Price", "Order Status", "Order Date Time");
      System.out.println();
      System.out.println("------------------------------------------------------------------------------------------------------------");
      for (Orders o : orderlist) {
        System.out.format("%3s %10s %15s %15s %20s %22s", o.getOrderId(), o.getCusId(), o.getVendorName(), o.getWalTransId(),
              +Math.round(o.getOrderTotalPrice()), o.getOrderStatus(), o.getOrderDate());
        System.out.println();
      }
      System.out.println("-------------------------------------------------------------------------------------------------------------");
    }

  }
/**
* vendorDetails display all the details of a vendor.
 */
  private void vendorDetails() {
    System.out.println("Enter the Vendor Id");
    int venId = option.nextInt();
    System.out.println("Enter the Vendor Password");
    String venPass = option.next();
    try {
      Validators.validateVenIdandPass(venId, venPass);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    //Vendor[] vendorlist = VendorFactory.vendorDetails();
    List<Vendor> vendorlist = VendorFactory.vendorDetails(venId);
    System.out.println("----------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%4s %17s %17s %19s %20s %25s", "Vendor Id", "Vendor Name", "Vendor Phone", "Vendor AccNo", "Vendor Balance",
        "Vendor Email");
    System.out.println();
    System.out.println("----------------------------------------------------------------------------------------------------------------------");
    for (Vendor v : vendorlist) {
      System.out.format("%4d %20s %20s %20s %20s %25s", v.getVendorId(), v.getVendorName(), v.getVendorPhone(), v.getVendorAccNo(),
          Math.round(v.getVendorBalance()), v.getVendorEmail());
      System.out.println();
    }
    System.out.println("----------------------------------------------------------------------------------------------------------------------");
  }
/**
* customerDetails display all the details of a customer.
 */
  private void customerDetails() {
    System.out.println("Enter your customer ID");
    int cusId = option.nextInt();
    System.out.println("Enter password");
    String cusPass = option.next();
    try {
      Validators.validateCustomerId(cusId, cusPass);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    List<Customer> customerlist = CustomerFactory.customerDetails(cusId);
    System.out.println("------------------------------------------------------------------------------------------");
    System.out.printf("%4s %18s %18s %20s", "Customer Id", "Customer Name", "Customer Phone", "Customer Email");
    System.out.println();
    System.out.println("------------------------------------------------------------------------------------------");
    for (Customer c : customerlist) {
      System.out.format("%4s %20s %20s %25s", c.getCustomerId(), c.getCustomerName(), c.getCustomerPhone(), c.getCustomerEmail());
      System.out.println();
    }
    System.out.println("-----------------------------------------------------------------------------------------");
  }
/**
* showWalletBalance methods display the menu items stored in the database.
 */
  private void placeOrder() {
    System.out.println("Enter your customer ID");
    int cusId = option.nextInt();
    System.out.println("Enter password");
    String cusPass = option.next();
    try {
      Validators.validateCusId(cusId);
      Validators.validateCustomerId(cusId, cusPass);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    System.out.println("Enter the Vendor Id");
    int venId = option.nextInt();
    try {
      Validators.validateVendorId(venId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    System.out.println("Enter the Food ID");
    int menItemId = option.nextInt();
    try {
      Validators.validateMenuItemId(menItemId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    System.out.println("Enter the Quantity");
    int qty = option.nextInt();
    List<Wallet> walletList = WalletFactory.showWallet(cusId);
    System.out.println("Wallet Details");
    System.out.println("------------------------------------------------------------------------------");
    System.out.println();
    System.out.printf("%4s %20s %20s", "Wallet Id", "Wallet Amount", "Wallet Source");
    System.out.println();
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println();

    for (Wallet wallet : walletList) {
      System.out.format("%4d %20s %20s", wallet.getWalletTranId(), Math.round(wallet.getWalletCurrentBalance()), wallet.getWalletPaymentMethod());
      System.out.println();
    }
    double orderPrice = MenuFactory.getOrderPrice(menItemId, venId);
    double totalOrderPrice = orderPrice * qty;
    System.out.println("Your Total Price:" + totalOrderPrice);
    System.out.println("Enter the wallet Id of your choice");
    int walletId = option.nextInt();
    try {
      Validators.validateWalletId(walletId, cusId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    double venAmount = VendorFactory.fetchVenBalance(venId);
    double wallAmount = WalletFactory.findByOrderPrice(walletId);
    if (wallAmount > totalOrderPrice) {
      Orders orders = new Orders(cusId, venId, totalOrderPrice, walletId);
      int ordId = OrdersFactory.setPlaceOrder(orders);
      System.out.println("Approved");
      double updateCusBal = wallAmount - totalOrderPrice;
      double updateVenBal = venAmount + totalOrderPrice;
      //WalletFactory.
      WalletFactory.cusUpdate(updateCusBal, cusId, walletId);
      VendorFactory.venUpdate(updateVenBal, venId);
      OrderItem orderItem = new OrderItem(cusId, venId, menItemId, qty, orderPrice, ordId);
      OrdersFactory.updateOrderItems(orderItem);

    } else {
      System.out.println("You have insufficient balance please choose another wallet");
    }
  }
/**
* pendingOrders methods display the pending orders of customers.
 */
  private void pendingOrders() {
    System.out.println("Enter Vendor Id");
    int venId = option.nextInt();
    System.out.println("Enter Password");
    String venPass = option.next();
    try {
      Validators.validateVendor(venId, venPass);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println();
      mainMenu();
    }
    List<Orders> orderList = OrdersFactory.showOrders(venId);
    if (orderList.isEmpty()) {
      System.out.println("NO PENDING ORDERS!");
    } else {
      System.out.println("----------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%4s %19s %25s %25s %25s", "Order Id", "Customer Id", "Order Date", "Order Price", "Order Status");
      System.out.println();
      System.out.println("----------------------------------------------------------------------------------------------------------------------");
      for (Orders orders : orderList) {
        System.out.format("%4s %20s %25s %25s %25s", orders.getOrderId(), orders.getCusId(), orders.getOrderDate(),
            +Math.round(orders.getOrderTotalPrice()), orders.getOrderStatus());
        System.out.println();
      }

      System.out.println("------------------------------------------------------------------------------------------------------------------");
      System.out.println("Enter the order Id you want to APPROVE or REJECT:");
      int orderOption = option.nextInt();
      System.out.println("Enter \n 1.TO APPROVE \n 2.TO REJECT");
      int optionValue = option.nextInt();
      System.out.println("Enter the comments:");
      String comments = option.next();
      if (optionValue == 1) {
        OrdersFactory.updatePendingOrders(orderOption, OrderStatus.APPROVED, comments, venId);
        System.out.println("ORDER APPROVED");
      } else if (optionValue == 2) {
        OrdersFactory.updatePendingOrders(orderOption, OrderStatus.REJECTED, comments, venId);
        System.out.println("ORDER REJECTED");
        double refundAmount = OrdersFactory.getRefundAmount(venId, orderOption);
      // System.out.println("venId" + venId);
      // System.out.println("orderOption" + orderOption);
      // System.out.println("refundAmount" + refundAmount);
        VendorFactory.updateRefund(refundAmount, venId);
        int cusId = OrdersFactory.getCusId(venId, orderOption);
        int walTranId = OrdersFactory.getWalTransId(orderOption);
        WalletFactory.refundCustomer(refundAmount, cusId, walTranId);
        OrdersFactory.changeTotal(refundAmount, orderOption);
      } else {
        System.out.println("ENTER A VALID OPTION");
        System.exit(0);
      }
    }
  }


/**
* main method is the basic entry point for the application.
* @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}

