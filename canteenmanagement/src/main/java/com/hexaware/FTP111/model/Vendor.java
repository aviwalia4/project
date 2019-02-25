package com.hexaware.FTP111.model;

//import com.hexaware.FTP111.persistence.DbConnection;
//import com.hexaware.FTP111.persistence.OrdersDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;
//import java.util.List;

/**
* Vendor class used to display Vendor information.
* @author hexaware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {
  private int vendorId;
  private String venPass;
  private String vendorFeedback;
  private String vendorPhone;
  private String vendorAccNo;
  private double vendorBalance;
/**
* Default Constructor.
*/
  public Vendor() {

  }
/**
* @param argVendorId
* @param argVenPass
* @param argVendorFeedback
* @param argVendorPhone
* @param argVendorAccNo
* @param argVendorBalance
 */
/**
* @param argVendorId to initialize vendor id used to get details through constructor.
* @param argVendorPhone to initialize vendor Phone used to get details through constructor.
* @param argVendorAccNo to initialize vendor Acc. No. used to get details through constructor.
* @param argVendorBalance to initialize vendor Balance used to get details through constructor.
 */
  public Vendor(final int argVendorId, final String argVendorPhone, final String argVendorAccNo, final double argVendorBalance) {
    this.vendorId = argVendorId;
    this.vendorPhone = argVendorPhone;
    this.vendorAccNo = argVendorAccNo;
    this.vendorBalance = argVendorBalance;
  }
/**
* @param argVendorId Initialize the vendor id.
 */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
/**
* @param argVenPass Initialize the vendor pass.
 */
  public final void setVenPass(final String argVenPass) {
    this.venPass = argVenPass;
  }
/**
* @param argVendorFeedback Initialize the vendor Feedback.
 */
  public final void setVendorFeedback(final String argVendorFeedback) {
    this.vendorFeedback = argVendorFeedback;
  }
/**
* @param argVendorPhone Initialize the vendor phone.
 */
  public final void setVendorPhone(final String argVendorPhone) {
    this.vendorPhone = argVendorPhone;
  }
/**
* @param argVendorAccNo Initialize the vendor acc.no.
 */
  public final void setVendorAccNo(final String argVendorAccNo) {
    this.vendorAccNo = argVendorAccNo;
  }
/**
* @param argVendorBalance Initialize the vendor Balance.
 */
  public final void setVendorBalance(final double argVendorBalance) {
    this.vendorBalance = argVendorBalance;
  }
/**
* @return this vendor id.
 */
  public final int getVendorId() {
    return this.vendorId;
  }
/**
* @return this vendor pass.
 */
  public final String getVenPass() {
    return this.venPass;
  }
/**
* @return this vendor Feedback.
 */
  public final String getVendorFeedback() {
    return this.vendorFeedback;
  }
/**
* @return this vendor phone.
 */
  public final String getVendorPhone() {
    return this.vendorPhone;
  }
/**
* @return this vendor acc.no.
 */
  public final String getVendorAccNo() {
    return this.vendorAccNo;
  }
/**
* @return this vendor balance.
 */
  public final double getVendorBalance() {
    return this.vendorBalance;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(vendorId, vendor.getVendorId())
        && Objects.equals(venPass, vendor.getVenPass())
        && Objects.equals(vendorFeedback, vendor.getVendorFeedback())
        && Objects.equals(vendorPhone, vendor.getVendorPhone())
        && Objects.equals(vendorAccNo, vendor.getVendorAccNo())
        && Objects.equals(vendorBalance, vendor.getVendorBalance())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(vendorId, venPass, vendorFeedback, vendorPhone, vendorAccNo, vendorBalance);
  }
}
