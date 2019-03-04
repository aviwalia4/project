package com.hexaware.FTP111.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
* OrderItem class used to display Order Item information.
* @author hexaware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItem {
  private int cusId;
  private int ordItemId;
  private int menItemId;
  private int venId;
  private int ordId;
  private int orderQuantity;
  private double ordItemPrice;
  private OrderStatus orderStatus;
  private String comments;
/**
* Default Constructor.
 */
  public OrderItem() {
  }
/**
* @param argCusId to intitalize Customer Id.
* @param argVenId to intitalize vendor Id.
* @param argMenItemId to intitalize menu item Id.
* @param argOrderQuantity to initialize OrderQuantity.
* @param argOrdItemPrice to intitalize order item price.
* @param argOrdId to intitalize order Id.
 */
  public OrderItem(final int argCusId, final int argVenId, final int argMenItemId, final int argOrderQuantity,
      final double argOrdItemPrice, final int argOrdId) {
    this.cusId = argCusId;
    this.venId = argVenId;
    this.menItemId = argMenItemId;
    this.orderQuantity = argOrderQuantity;
    this.ordItemPrice = argOrdItemPrice;
    this.ordId = argOrdId;
  }

/**
* @param argCusId to intitalize Customer Id.
* @param argMenItemId to intitalize menu item Id.
* @param argOrdItemId to intitalize order item Id.
* @param argOrdItemPrice to intitalize order item price.
* @param argOrdId to intitalize order Id.
* @param argComments to intitalize comments.
 */
  public OrderItem(final int argCusId, final int argMenItemId, final int argOrdItemId, final double argOrdItemPrice,
                  final int argOrdId, final String argComments) {
    this.cusId = argCusId;
    this.menItemId = argMenItemId;
    this.ordItemId = argOrdItemId;
    this.ordItemPrice = argOrdItemPrice;
    this.ordId = argOrdId;
    this.comments = argComments;

  }


/**
* @param argCusId to intitalize customer Id.
* @param argOrdItemId to intitalize order item Id.
* @param argVenId to intitalize vendor Id.
* @param argOrdItemPrice to intitalize order item price.
* @param argOrderStatus to intitalize order status.
 */
  public OrderItem(final int argOrdItemId, final int argVenId, final int argCusId,
                   final double argOrdItemPrice, final OrderStatus argOrderStatus) {
    this.ordItemId = argOrdItemId;
    this.venId = argVenId;
    this.cusId = argCusId;
    this.ordItemPrice = argOrdItemPrice;
    this.orderStatus = argOrderStatus;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    OrderItem ordit1 = (OrderItem) obj;
    if (Objects.equals(ordItemId, ordit1.getOrdItemId())
        && Objects.equals(menItemId, ordit1.getMenItemId())
        && Objects.equals(ordId, ordit1.getOrdId())
        && Objects.equals(venId, ordit1.getVenId())
        && Objects.equals(orderQuantity, ordit1.getOrderQuantity())
        && Objects.equals(ordItemPrice, ordit1.getOrdItemPrice())
        && Objects.equals(orderStatus, ordit1.getOrderStatus())
        && Objects.equals(comments, ordit1.getComments())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, ordItemId, menItemId, venId, ordId, orderQuantity, ordItemPrice, orderStatus, comments);
  }


/**
* @param argOrdItemId gets the order Item id.
 */
  public final void setOrdItemId(final int argOrdItemId) {
    this.ordItemId = argOrdItemId;
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
* @param argOrdId gets the Order id.
 */
  public final void setOrdId(final int argOrdId) {
    this.ordId = argOrdId;
  }
/**
* @param argOrderQuantity initialize the Order quantity.
 */
  public final void setOrderQuantity(final int argOrderQuantity) {
    this.orderQuantity = argOrderQuantity;
  }
/**
* @param argOrdItemPrice to Intitalize the ord item Price.
 */
  public final void setOrdItemPrice(final double argOrdItemPrice) {
    this.ordItemPrice = argOrdItemPrice;
  }
/**
* @param argOrderStatus initialize the Orderstatus.
 */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }
/**
* @param argComments to Intitalize the comments.
 */
  public final void setComments(final String argComments) {
    this.comments = argComments;
  }
/**
* @param argCusId to Intitalize the customer Id.
 */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }

/**
* @return this ord Item Id.
 */
  public final int getOrdItemId() {
    return this.ordItemId;
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
* @return this ord Id.
 */
  public final int getOrdId() {
    return this.ordId;
  }
/**
* @return this OrderQuantity.
 */
  public final int getOrderQuantity() {
    return this.orderQuantity;
  }
/**
* @return this ord item price
 */
  public final double getOrdItemPrice() {
    return this.ordItemPrice;
  }
/**
* @return this ord status.
 */
  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
  }
/**
* @return this comments.
 */
  public final String getComments() {
    return this.comments;
  }
/**
* @return this cutomer Id.
 */
  public final int getCusId() {
    return this.cusId;
  }
}

