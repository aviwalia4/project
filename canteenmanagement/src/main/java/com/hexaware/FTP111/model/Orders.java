package com.hexaware.FTP111.model;

//import com.hexaware.FTP111.persistence.DbConnection;
//import com.hexaware.FTP111.persistence.MenuDAO;
import java.util.Objects;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;

//import java.util.List;

/**
* Orders class used to display orders information.
* @author hexware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Orders {
/**
* Default constructor.
*/
  public Orders() {

  }
/**
* OrderID to store OrderId.
 */
  private int orderId;
  private int cusId;
  private int venId;
  private String vendorName;
  private int walTransId;
  private double orderTotalPrice;
  private OrderStatus orderStatus;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
  private Date orderDate;

/**
* @param argOrderId to initialize Order id.
* @param argVenId to initialize Vendor id.
* @param argCusId to initialize Customer Id.
* @param argVendorName to initialize vendor name used to get details through constructor.
* @param argWalTransId to initialize WalTransId id.
* @param argOrderTotalPrice to initialize OrderTotalPrice.
* @param argOrderStatus to initialize Orderstatus.
* used to get details through constructor.
 */
  public Orders(final int argOrderId, final int argCusId, final int argVenId, final String argVendorName, final int argWalTransId,
      final double argOrderTotalPrice, final OrderStatus argOrderStatus) {
    this.orderId = argOrderId;
    this.venId = argVenId;
    this.cusId = argCusId;
    this.vendorName = argVendorName;
    this.walTransId = argWalTransId;
    this.orderTotalPrice = argOrderTotalPrice;
    this.orderStatus = argOrderStatus;
  }
/**
* @param argOrderId to initialize Order id.
* @param argVenId to initialize Vendor id.
* @param argCusId to initialize Customer Id.
* @param argWalTransId to initialize WalTransId id.
* @param argOrderTotalPrice to initialize OrderTotalPrice.
* @param argOrderStatus to initialize Orderstatus.
* used to get details through constructor.
 */
  public Orders(final int argOrderId, final int argCusId, final int argVenId, final int argWalTransId,
      final double argOrderTotalPrice, final OrderStatus argOrderStatus) {
    this.orderId = argOrderId;
    this.cusId = argCusId;
    this.venId = argVenId;
    this.walTransId = argWalTransId;
    this.orderTotalPrice = argOrderTotalPrice;
    this.orderStatus = argOrderStatus;
  }
/**
* @param argOrderId to initialize Order id.
* @param argCusId to initialize Customer Id.
* @param argWalTransId to initialize WalTransId id.
* @param argOrderTotalPrice to initialize OrderTotalPrice.
* used to get details through constructor.
 */
  public Orders(final int argOrderId, final int argCusId, final int argWalTransId,
      final double argOrderTotalPrice) {
    this.orderId = argOrderId;
    this.cusId = argCusId;
    this.walTransId = argWalTransId;
    this.orderTotalPrice = argOrderTotalPrice;
  }
/**
* @param argCusId to initialize Customer Id.
* @param argVenId to initialize Vendor Id.
* @param argOrderTotalPrice to initialize Order Total Price.
* @param argWalTransId to initialize Wallet Transaction Id.
* used to get details through constructor.
 */
  public Orders(final int argCusId, final int argVenId,
      final double argOrderTotalPrice, final int argWalTransId) {
    this.cusId = argCusId;
    this.venId = argVenId;
    this.orderTotalPrice = argOrderTotalPrice;
    this.walTransId = argWalTransId;
  }
/**
* @param argOrderId to initialize Order id.
* @param argVenId to initialize Vendor Id.
* @param argOrderStatus to initialize Orderstatus.
* used to get details through constructor.
 */
  public Orders(final int argOrderId, final OrderStatus argOrderStatus, final int argVenId) {
    this.orderId = argOrderId;
    this.orderStatus = argOrderStatus;
    this.venId = argVenId;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (Objects.equals(orderId, orders.getOrderId())
        && Objects.equals(cusId, orders.getCusId())
         && Objects.equals(vendorName, orders.getVendorName())
        && Objects.equals(walTransId, orders.getWalTransId())
        && Objects.equals(orderTotalPrice, orders.getOrderTotalPrice())
        && Objects.equals(orderStatus, orders.getOrderStatus())
        && Objects.equals(orderDate, orders.getOrderDate())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId, cusId, venId, vendorName, walTransId, orderTotalPrice, orderStatus, orderDate);
  }
/* setting up the setters for orders */
/**
* @param argOrderId Initialize the Order id.
 */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
/**
* @param argCusId Initialize the Customer id.
 */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
/**
* @param argVenId Initialize the Vendor id.
 */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
/**
* @param argWalTransId initialize the WalTransId id.
 */
  public final void setWalTransId(final int argWalTransId) {
    this.walTransId = argWalTransId;
  }
/**
* @param argOrderTotalPrice initialize the  OrderTotalPrice.
 */
  public final void setOrderTotalPrice(final double argOrderTotalPrice) {
    this.orderTotalPrice = argOrderTotalPrice;
  }
/**
* @param argOrderStatus initialize the Orderstatus.
 */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }
/**
* @param argVendorName Initialize the vendor Name.
 */
  public final void setVendorName(final String argVendorName) {
    this.vendorName = argVendorName;
  }
  /**
* @param argOrderDate initialize the Orderstatus.
 */
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }
/* setting up the getters for orders */
/**
* @return this Order ID.
 */
  public final int getOrderId() {
    return this.orderId;
  }
/**
* @return this Customer ID.
 */
  public final int getCusId() {
    return this.cusId;
  }
/**
* @return this Vendor ID.
 */
  public final int getVenId() {
    return this.venId;
  }
/**
* @return this WalTransId ID.
 */
  public final int getWalTransId() {
    return this.walTransId;
  }
/**
* @return this Order ID.
 */
  public final double getOrderTotalPrice() {
    return this.orderTotalPrice;
  }
/**
* @return this OrderStatus.
 */
  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
  }
/**
* @return this OrderDate.
 */
  public final Date getOrderDate() {
    return this.orderDate;
  }
/**
* @return this vendor Name.
 */
  public final String getVendorName() {
    return this.vendorName;
  }
}






