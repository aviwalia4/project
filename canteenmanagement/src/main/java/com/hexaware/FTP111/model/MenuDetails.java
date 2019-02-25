package com.hexaware.FTP111.model;

//import com.hexaware.FTP111.persistence.DbConnection;
//import com.hexaware.FTP111.persistence.MenuDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
* MenuDetails class used to display menu details information.
* @author hexware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDetails {
  private int menItemId;
  private int venId;
  private double menVenPrice;
  private int menVenRating;
  private int menCalories;
/**
* Default Constructor.
 */
  public MenuDetails() {

  }
/**
* @param argMenItemId to intitalize menu Item Id.
* @param argVenId to intitalize ven Id.
* @param argMenVenPrice to intitalize men ven Price.
* @param argMenVenRating to intitalize menu ven Rating.
* @param argMenCalories to intitalize menu calories.
 */
  public MenuDetails(final int argMenItemId, final int argVenId, final double argMenVenPrice,
      final int argMenVenRating, final int argMenCalories) {
    this.menItemId = argMenItemId;
    this.venId = argVenId;
    this.menVenPrice = argMenVenPrice;
    this.menVenRating = argMenVenRating;
    this.menCalories = argMenCalories;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MenuDetails menu = (MenuDetails) obj;
    if (Objects.equals(menItemId, menu.getMenItemId())
        && Objects.equals(venId, menu.getVenId())
        && Objects.equals(menVenPrice, menu.getMenVenPrice())
        && Objects.equals(menVenRating, menu.getMenVenRating())
        && Objects.equals(menCalories, menu.getMenCalories())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(menItemId, venId, menVenPrice, menVenRating, menCalories);
  }
/**
* @param argMenItemId gets the Menu Item id.
 */
  public final void setMenItemId(final int argMenItemId) {
    this.menItemId = argMenItemId;
  }
/**
* @param argVenId to Intitalize the venId.
 */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
/**
* @param argMenVenPrice to Intitalize the Men Ven Price.
 */
  public final void setMenVenPrice(final double argMenVenPrice) {
    this.menVenPrice = argMenVenPrice;
  }
/**
* @param argMenVenRating to Intitalize the Men Ven Rating.
 */
  public final void setMenVenRating(final int argMenVenRating) {
    this.menVenRating = argMenVenRating;
  }
/**
* @param argMenCalories to Intitalize the Men Calories.
 */
  public final void setMenCalories(final int argMenCalories) {
    this.menCalories = argMenCalories;
  }
/**
* @return this men Item Id.
 */
  public final int getMenItemId() {
    return this.menItemId;
  }
/**
* @return this ven Id.
 */
  public final int getVenId() {
    return this.venId;
  }
/**
* @return this men ven price
 */
  public final double getMenVenPrice() {
    return this.menVenPrice;
  }
/**
* @return this menu item rating.
 */
  public final int getMenVenRating() {
    return this.menVenRating;
  }
/**
* @return this menu item calories.
 */
  public final int getMenCalories() {
    return this.menCalories;
  }
}

