package com.hexaware.FTP111.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
* Vendor class used to display Vendor information.
* @author hexaware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {
  private int vendorId;
  private String vendorName;
  private String venPass;
  private String vendorFeedback;
  private String vendorPhone;
  private String vendorAccNo;
  private double vendorBalance;
  private String vendorEmail;
/**
* Default Constructor.
*/
  public Vendor() {

  }
/**
* @param argVendorId
* @param argVendorName
* @param argVenPass
* @param argVendorFeedback
* @param argVendorPhone
* @param argVendorAccNo
* @param argVendorBalance
* @param argVendorEmail
 */
/**
* @param argVendorId to initialize vendor id used to get details through constructor.
* @param argVendorName to initialize vendor name used to get details through constructor.
* @param argVendorPhone to initialize vendor Phone used to get details through constructor.
* @param argVendorAccNo to initialize vendor Acc. No. used to get details through constructor.
* @param argVendorBalance to initialize vendor Balance used to get details through constructor.
* @param argVendorEmail to initialize vendor email through constructor.
 */
  public Vendor(final int argVendorId, final String argVendorName, final String argVendorPhone,
      final String argVendorAccNo, final double argVendorBalance, final String argVendorEmail) {
    this.vendorId = argVendorId;
    this.vendorName = argVendorName;
    this.vendorPhone = argVendorPhone;
    this.vendorAccNo = argVendorAccNo;
    this.vendorBalance = argVendorBalance;
    this.vendorEmail = argVendorEmail;
  }
// /**
// * @param argVendorId to initialize vendor id used to get details through constructor.
// * @param argVendorPhone to initialize vendor Phone used to get details through constructor.
// * @param argVendorAccNo to initialize vendor Acc. No. used to get details through constructor.
// * @param argVendorBalance to initialize vendor Balance used to get details through constructor.
// * @param argVendorEmail to initialize vendor email through constructor.
//  */
//   public Vendor(final int argVendorId, final String argVendorPhone,
//       final String argVendorAccNo, final double argVendorBalance, final String argVendorEmail) {
//     this.vendorId = argVendorId;
//     this.vendorPhone = argVendorPhone;
//     this.vendorAccNo = argVendorAccNo;
//     this.vendorBalance = argVendorBalance;
//     this.vendorEmail = argVendorEmail;
//   }

/**
* @param argVendorId Initialize the vendor id.
 */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
/**
* @param argVendorName Initialize the vendor Name.
 */
  public final void setVendorName(final String argVendorName) {
    this.vendorName = argVendorName;
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
* @param argVendorEmail Initialize the vendor Email.
 */
  public final void setVendorEmail(final String argVendorEmail) {
    this.vendorEmail = argVendorEmail;
  }
/**
* @return this vendor id.
 */
  public final int getVendorId() {
    return this.vendorId;
  }
/**
* @return this vendor Name.
 */
  public final String getVendorName() {
    return this.vendorName;
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
/**
* @return this vendor email.
 */
  public final String getVendorEmail() {
    return this.vendorEmail;
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
        && Objects.equals(vendorName, vendor.getVendorName())
         && Objects.equals(venPass, vendor.getVenPass())
        && Objects.equals(vendorFeedback, vendor.getVendorFeedback())
        && Objects.equals(vendorPhone, vendor.getVendorPhone())
        && Objects.equals(vendorAccNo, vendor.getVendorAccNo())
        && Objects.equals(vendorBalance, vendor.getVendorBalance())
        && Objects.equals(vendorEmail, vendor.getVendorEmail())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(vendorId, vendorName, venPass, vendorFeedback, vendorPhone, vendorAccNo, vendorBalance, vendorEmail);
  }
}
