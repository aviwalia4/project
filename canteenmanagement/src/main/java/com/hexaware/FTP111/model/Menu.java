
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
  private int vendorId;
  private String vendorName;
  private double menVenPrice;
  private int menVenRating;


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
* @param argMenFoodType to intitalize menu Food Type.
* @param argMenVegNonVeg to intitalize menu Veg NonVeg.
* @param argMenItemName to intitalize menu Item Name.
* @param argMenCalories to intitalize menu Calories.
* @param argMenItemID to intitalize menu Item Id.
* @param argVendorId to intitalize menu vendor Id.
* @param argMenVenPrice to intitalize menu vendor price.
 */
  public Menu(final String argMenFoodType, final String argMenVegNonVeg,
      final String argMenItemName, final int argMenCalories, final int argMenItemID, final int argVendorId,
       final double argMenVenPrice) {
    this.menFoodType = argMenFoodType;
    this.menVegNonVeg = argMenVegNonVeg;
    this.menItemName = argMenItemName;
    this.menCalories = argMenCalories;
    this.menItemId = argMenItemID;
    this.vendorId = argVendorId;
    this.menVenPrice = argMenVenPrice;
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
        && Objects.equals(menCalories, menu.getMenCalories())
        && Objects.equals(vendorId, menu.getVendorId())
        && Objects.equals(vendorName, menu.getVendorName())
        && Objects.equals(menVenPrice, menu.getMenVenPrice())
        && Objects.equals(menVenRating, menu.getMenVenRating())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(menItemId, menFoodType, menVegNonVeg, menItemName, menCalories);
  }
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
  public final int getMenCalories() {
    return this.menCalories;
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
* @return this menu id.
 */
  public final int getMenItemId() {
    return this.menItemId;
  }
/**
* @param argVendorId to intitalize the menu item name.
 */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }

/**
* @return this menu Calories.
 */
  public final int getVendorId() {
    return this.vendorId;
  }
/**
* @param argVendorName to intitalize the menu item name.
 */
  public final void setVendorName(final String argVendorName) {
    this.vendorName = argVendorName;
  }
/**
* @return this menu Calories.
 */
  public final String getVendorName() {
    return this.vendorName;
  }
/**
* @param argMenVenPrice to intitalize the menu item name.
 */
  public final void setMenVenPrice(final double argMenVenPrice) {
    this.menVenPrice = argMenVenPrice;
  }
/**
* @return this menu Calories.
 */
  public final double getMenVenPrice() {
    return this.menVenPrice;
  }
/**
* @param argMenVenRating to intitalize the menu vendor rating.
 */
  public final void setMenVenRating(final int argMenVenRating) {
    this.menVenRating = argMenVenRating;
  }
/**
* @return this menu rating.
 */
  public final int getMenVenRating() {
    return this.menVenRating;
  }

}
