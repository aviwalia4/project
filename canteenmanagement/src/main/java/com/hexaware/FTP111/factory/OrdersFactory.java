package com.hexaware.FTP111.factory;

import com.hexaware.FTP111.persistence.OrdersDAO;
import com.hexaware.FTP111.persistence.DbConnection;
import java.util.List;
//import com.hexaware.FTP111.util.Validators;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.model.OrderStatus;
/**
* ordersFactory class used to fetch orders data from database.
* @author hexaware
 */
public class OrdersFactory {
/**
* Protected constructor.
 */
/**
* empty method.
 */
  protected OrdersFactory() {
  }
/**
* Call the data base connection.
* @return the connection object.
 */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
/**
* Call the data base connection.
* @param venId to intialize the venId.
* @return the array of showOrders object.
*/
  public static final List<Orders> showOrders(final int venId) {
    List<Orders> orderList = dao().showOrders(venId);
    return orderList;
  }
/**
* Call the data base connection.
* @param venId to intialize the venId.
* @return the array of showOrders object.
*/
  public static final List<Orders> showOrdersForVendor(final int venId) {
    List<Orders> orderList = dao().showOrdersForVendor(venId);
    return orderList;
  }
/**
* Call the data base connection.
* @param orderId to Intitalize the orderId.
* @return the array of ordersDetails object.
 */
  public static final List<Orders> orderDetails(final int orderId) {
    List<Orders> orderlist = dao().orderDetails(orderId);
    return orderlist;
  }
/**
* Call the data base connection.
* @param orders to Intitalize the Orders order.
* @return the array of setPlaceOrder object.
 */
  public static final int setPlaceOrder(final Orders orders) {
    int orderPrice = dao().setPlaceOrder(orders);
    return orderPrice;
  }
/**
* Call the data base connection.
* @param orderItem to Intitalize the orderItem.
 */
  public static final void updateOrderItems(final OrderItem orderItem) {
    dao().updateOrderItems(orderItem);
  }
// /**
// * Call the data base connection.
// * @param orderId to Intitalize the orderId.
// * @param comments to Intitalize the comments.
//  */
//   public static final void updateComment(final int orderId, final String comments) {
//     dao().updateComment(orderId, comments);
//   }
/**
* Call the data base connection.
* @param cusId to Intitalize the cusId.
* @return the List of getOrderDetails object.
 */
  public static final List<Orders> getOrderDetails(final int cusId) {
    //Validators.validateCustomerId(cusId);
    List<Orders> orderlist = dao().getOrderDetails(cusId);
    return orderlist;
  }
/**
* @param orderOption to initialize order option.
* @param orderstat to Intitalize the order status.
* @param venId to initialize vendor id.
* @param comments to initialize comments.
 */
  public static final void updatePendingOrders(final int orderOption, final OrderStatus orderstat, final String comments, final int venId) {
    dao().updatePendingOrders(orderOption, orderstat, comments, venId);
  }
/**
* @param orderOption to initialize order option.
* @param venId to initialize vendor id.
* @return refundAmount.
 */
  public static final double getRefundAmount(final int venId, final int orderOption) {
    double refundAmount = dao().refundAmount(venId, orderOption);
    return refundAmount;
  }

/**
* @param orderOption to initialize order option.
* @param venId to initialize vendor id.
* @return cusId.
 */
  public static final int getCusId(final int venId, final int orderOption) {
    int cusId = dao().getCusId(venId, orderOption);
    return cusId;
  }
/**
* @param orderOption to initialize order option.
* @return wallId.
 */
  public static final int getWalTransId(final int orderOption) {
    int wallId = dao().getWalTransId(orderOption);
    return wallId;
  }
/**
* @param orderOption to initialize order option.
* @param refundAmount to initialize refund amount.
 */
  public static final void changeTotal(final double refundAmount, final int orderOption) {
    dao().updateTotal(refundAmount, orderOption);
  }
}

