
package com.hexaware.FTP111.model;

//import com.hexaware.FTP111.persistence.DbConnection;
//import com.hexaware.FTP111.persistence.MenuDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;
//import java.util.List;

/**
* Menu class used to display menu information.
* @author hexware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu {
/**
* MenItemId to store MenItemId.
 */
  private int menItemId;
  private String menFoodType;
  private String menVegNonVeg;
  private String menItemName;
  private int menCalories;



/**
* Default Constructor.
 */
  public Menu() {

  }
/**
* @param argMenItemID to intitalize menu Item Id.
* @param argMenFoodType to intitalize menu Food Type.
* @param argMenVegNonVeg to intitalize menu Veg NonVeg.
* @param argMenItemName to intitalize menu Item Name.
* @param argMenCalories to intitalize menu Calories.
 */
  public Menu(final int argMenItemID, final String argMenFoodType, final String argMenVegNonVeg,
      final String argMenItemName, final int argMenCalories) {
    this.menItemId = argMenItemID;
    this.menFoodType = argMenFoodType;
    this.menVegNonVeg = argMenVegNonVeg;
    this.menItemName = argMenItemName;
    this.menCalories = argMenCalories;
  }
/**
* @param argMenuItemId to initialize menu item id.
* used to get details through constructor.
 */

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(menItemId, menu.getMenItemId())
        && Objects.equals(menFoodType, menu.getMenFoodType())
        && Objects.equals(menVegNonVeg, menu.getMenVegNonVeg())
        && Objects.equals(menItemName, menu.getMenItemName())
        && Objects.equals(menCalories, menu.getMenCalories())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(menItemId, menFoodType, menVegNonVeg, menItemName, menCalories);
  }
// /**
// * Call the data base connection.
// * @return the connection object.
//  */
//   private static MenuDAO dao() {
//     DbConnection db = new DbConnection();
//     return db.getConnect().onDemand(MenuDAO.class);
//   }
// /**
// * Call the data base connection.
// * @return the array of menu object.
//  */
//   public static Menu[] showMenu() {
//     List<Menu> menu = dao().show();
//     return menu.toArray(new Menu[menu.size()]);
//   }
/**
* @param argMenItemID to intitalize the menu Id.
 */
  public final void setMenItemId(final int argMenItemID) {
    this.menItemId = argMenItemID;
  }
/**
* @param argMenFoodType to intitalize the menu Food Type.
 */
  public final void setMenFoodType(final String argMenFoodType) {
    this.menFoodType = argMenFoodType;
  }
/**
* @param argMenVegNonVeg to intitalize the menu Veg or Non Veg.
 */
  public final void setMenVegNonVeg(final String argMenVegNonVeg) {
    this.menVegNonVeg = argMenVegNonVeg;
  }
/**
* @param argMenItemName to intitalize the menu item name.
 */
  public final void setMenItemName(final String argMenItemName) {
    this.menItemName = argMenItemName;
  }
/**
* @param argMenCalories to intitalize the menu calories.
 */
  public final void setMenCalories(final int argMenCalories) {
    this.menCalories = argMenCalories;
  }
/**
* @return this menu id.
 */
  public final int getMenItemId() {
    return this.menItemId;
  }
/**
* @return this menu food type.
 */
  public final String getMenFoodType() {
    return this.menFoodType;
  }
/**
* @return this menu Veg or Non Veg.
 */
  public final String getMenVegNonVeg() {
    return this.menVegNonVeg;
  }
/**
* @return this menu item name.
 */
  public final String getMenItemName() {
    return this.menItemName;
  }
/**
* @return this menu Calories.
 */
  public final int getMenCalories() {
    return this.menCalories;
  }
}
