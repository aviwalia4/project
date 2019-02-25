package com.hexaware.FTP111.model;

//import com.hexaware.FTP111.persistence.DbConnection;
//import com.hexaware.FTP111.persistence.CustomerDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;
//import java.util.List;
/**
* Customer class used to display class information.
* @author hexaware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
  private int customerId;
  private String customerName;
  private String customerPass;
  private String customerPhone;
  private String customerEmail;
/**
* Default Constructor.
 */
  public Customer() {

  }

/**
* @param argCustomerId to initialize Customer Id.
* @param argCustomerName to initialize customerName.
* @param argCustomerPhone to initialize customerPhone.
* @param argCustomerEmail to initialize customerEmail.
* used to get details through constructor.
 */
  public Customer(final int argCustomerId, final String argCustomerName, final String argCustomerPhone,
      final String argCustomerEmail) {
    this.customerId = argCustomerId;
    this.customerName = argCustomerName;
    this.customerPhone = argCustomerPhone;
    this.customerEmail = argCustomerEmail;
  }
/**
* @param argCustomerId to initialize CustomerId.
 */
  public final void setCustomerId(final int argCustomerId) {
    this.customerId = argCustomerId;
  }
/**
* @return CustomerId to get CustomerId.
 */
  public final int getCustomerId() {
    return this.customerId;
  }
/**
* @param argCustomerName to initialize CustomerName.
 */
  public final void setCustomerName(final String argCustomerName) {
    this.customerName = argCustomerName;
  }
/**
* @return CustomerName to get CustomerName.
 */
  public final String getCustomerName() {
    return this.customerName;
  }
/**
* @param argCustomerPass to initialize CustomerPass.
 */
  public final void setCustomerPass(final String argCustomerPass) {
    this.customerPass = argCustomerPass;
  }
/**
* @return CustomerPass to get CustomerPass.
 */
  public final String getCustomerPass() {
    return this.customerPass;
  }
/**
* @param argCustomerPhone to initialize CustomerPhone.
 */
  public final void setCustomerPhone(final String argCustomerPhone) {
    this.customerPhone = argCustomerPhone;
  }
/**
* @return CustomerPhone to get CustomerPhone.
 */
  public final String getCustomerPhone() {
    return this.customerPhone;
  }
/**
* @param argCustomerEmail to initialize CustomerEmail.
 */
  public final void setCustomerEmail(final String argCustomerEmail) {
    this.customerEmail = argCustomerEmail;
  }
/**
* @return CustomerEmail to get CustomerEmail.
 */
  public final String getCustomerEmail() {
    return this.customerEmail;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(customerId, customer.getCustomerId())
        && Objects.equals(customerName, customer.getCustomerName())
        && Objects.equals(customerPass, customer.getCustomerPass())
        && Objects.equals(customerPhone, customer.getCustomerPhone())
        && Objects.equals(customerEmail, customer.getCustomerEmail())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(customerId, customerName, customerPass, customerPhone, customerEmail);
  }
}
