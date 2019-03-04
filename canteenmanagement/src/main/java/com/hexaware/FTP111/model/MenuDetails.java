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
  private String menItemName;
  private int venId;
  private String vendorName;
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
* @param argMenItemName to intitalize menu Item name.
* @param argVenId to intitalize ven Id.
* @param argVendorName to initialize vendor name used to get details through constructor.
* @param argMenVenPrice to intitalize men ven Price.
* @param argMenVenRating to intitalize menu ven Rating.
* @param argMenCalories to intitalize menu calories.
 */
  public MenuDetails(final int argMenItemId, final String argMenItemName, final int argVenId, final String argVendorName, final double argMenVenPrice,
      final int argMenVenRating, final int argMenCalories) {
    this.menItemId = argMenItemId;
    this.menItemName = argMenItemName;
    this.venId = argVenId;
    this.vendorName = argVendorName;
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
        && Objects.equals(menItemName, menu.getMenItemName())
        && Objects.equals(venId, menu.getVenId())
        && Objects.equals(vendorName, menu.getVendorName())
        && Objects.equals(menVenPrice, menu.getMenVenPrice())
        && Objects.equals(menVenRating, menu.getMenVenRating())
        && Objects.equals(menCalories, menu.getMenCalories())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(menItemId, menItemName, venId, vendorName, menVenPrice, menVenRating, menCalories);
  }
/**
* @param argMenItemId gets the Menu Item id.
 */
  public final void setMenItemId(final int argMenItemId) {
    this.menItemId = argMenItemId;
  }
/**
* @param argMenItemName gets the Menu Item name.
 */
  public final void setMenItemName(final String argMenItemName) {
    this.menItemName = argMenItemName;
  }
/**
* @param argVenId to Intitalize the venId.
 */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
/**
* @param argVendorName Initialize the vendor Name.
 */
  public final void setVendorName(final String argVendorName) {
    this.vendorName = argVendorName;
  }
// /**
// * @param argVenId to Intitalize the venId.
//  */
//   public final void setVenId(final int argVenId) {
//     this.venId = argVenId;
//   }
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
* @return this men Item name.
 */
  public final String getMenItemName() {
    return this.menItemName;
  }
/**
* @return this ven Id.
 */
  public final int getVenId() {
    return this.venId;
  }
/**
* @return this vendor Name.
 */
  public final String getVendorName() {
    return this.vendorName;
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

