package com.hexaware.FTP111.factory;

import com.hexaware.FTP111.persistence.MenuDAO;
import com.hexaware.FTP111.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP111.model.MenuDetails;
import com.hexaware.FTP111.model.Menu;
/**
* MenuFactory class used to fetch menu data from database.
* @author hexware
 */
public class MenuFactory {
/**
*Protected constructor.
 */
  protected MenuFactory() {
  }
/**
* Call the data base connection.
* @return the connection object.
 */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
/**
* Call the data base connection.
* @return the connection object.
 */
//  public static List showMenu() {
//    List<Menu> menu = dao().show();
//    return menu.toArray(new Menu[menu.size()]);
  public static final List<Menu> showMenu() {
    List<Menu> menu = dao().show();
    return menu;
  }
/**
* Call the data base connection.
* @param menId to Intitalize the menId.
* @return the array of menuDetails object.
 */
  public static final List<MenuDetails> getMenuDetails(final int menId) {
    List<MenuDetails> foodlist = dao().createOrder(menId);
    return foodlist;
  }
/**
* @return the Menu Item Id.
* @param menItemId to Initialize menu Item Id.
 */
  public static int findByMenItemId(final int menItemId) {
    int id = dao().fetchMenItemId(menItemId);
    return id;
  }

/**
* Call the data base connection.
* @param menId to Intitalize the menId.
* @param venId to Intitalize the venId.
* @return the array of orderPrice object.
 */
  public static final double getOrderPrice(final int menId, final int venId) {
    double orderPrice = dao().fetchOrderPrice(menId, venId);
    return orderPrice;
  }
}


