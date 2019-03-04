package com.hexaware.FTP111.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
//import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP111.model.Vendor;
import com.hexaware.FTP111.model.Menu;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.OrderStatus;
import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.factory.VendorFactory;
import com.hexaware.FTP111.factory.WalletFactory;
import com.hexaware.FTP111.factory.OrdersFactory;
import java.util.List;
/**
* Root resource (exposed at "myresource" path).
 */
@Path("vendors")
public class VendorController {
/**
* Return vendor details.
* @param venId to Intitalize the menId.
* @return the vendor details.
 */
  @GET
  @Path("/{venId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Vendor> fetchVendorById(@PathParam ("venId") final int venId) {
    Validators.validateVendorId(venId);
    return VendorFactory.vendorDetails(venId);
  }
/**
* Return vendor details.
* @param venId to Intitalize the menId.
* @param orderItem to Intitalize the orderItem.
* @return the vendor details.
 */
  @GET
  @Path("/{venId}/orderItem")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Orders> fetchOrderDetailsByVenId(@PathParam ("venId") final int venId, final OrderItem orderItem) {
    Validators.validateVendorId(venId);
    return OrdersFactory.showOrders(venId);
  }
/**
* Return vendor orders details.
* @param venId to Intitalize the menId.
* @param orders to Intitalize the orders.
* @return the vendor orders details.
 */
  @GET
  @Path("/{venId}/orders")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Orders> showOrdersForVendor(@PathParam ("venId") final int venId, final Orders orders) {
    Validators.validateVendorId(venId);
    return OrdersFactory.showOrdersForVendor(venId);
  }
/**
* Return orders details.
* @param ordId to Intitalize the ordId.
* @param orderItem to Intitalize the order item.
* @param venId to Intitalize the venId.
 */
  @PUT
  @Path("/{venId}/orderItem/{ordItemId}")
  @Consumes(MediaType.APPLICATION_JSON)
  public final void updateOrderStatusApproved(@PathParam ("venId") final int venId, @PathParam ("ordItemId") final int ordId,
                                              final OrderItem orderItem) {
    Validators.validateVendorIdAndOrdId(venId, ordId);
    System.out.println(orderItem.getOrderStatus());
    if (orderItem.getOrderStatus() == OrderStatus.APPROVED) {
      OrdersFactory.updatePendingOrders(ordId, orderItem.getOrderStatus(), orderItem.getComments(), venId);
      // OrdersFactory.updateComments(orderItem.getOrdId(), orderItem.getComments());

    } else if (orderItem.getOrderStatus() == OrderStatus.REJECTED) {
      OrdersFactory.updatePendingOrders(ordId, orderItem.getOrderStatus(), orderItem.getComments(), venId);
      double refundAmount = OrdersFactory.getRefundAmount(venId, ordId);
      VendorFactory.updateRefund(refundAmount, venId);
      int cusId = OrdersFactory.getCusId(venId, ordId);
      int walTranId = OrdersFactory.getWalTransId(ordId);
      WalletFactory.refundCustomer(refundAmount, cusId, walTranId);
      OrdersFactory.changeTotal(refundAmount, ordId);
      // OrdersFactory.updateComments(orderItem.getOrdId(), orderItem.getComments());
    }
    OrdersFactory.updatePendingOrders(ordId, orderItem.getOrderStatus(), orderItem.getComments(), venId);

  }
/**
* @param vendor to Intitalize the vendor.
* @return vendor.
 */
  @POST
  @Path("/auth")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response vendorLogin(final Vendor vendor) {
    int vendorId = vendor.getVendorId();
    String venPass = vendor.getVenPass();
    Validators.validateVenIdandPass(vendorId, venPass);
    return Response.status(Response.Status.OK).build();
  }
/**
* @param menuAdd to Intitalize the menuAdd.
* @return menuAdd.
 */
  @POST
  @Path("/{venId}/menu")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response addFoodItem(final Menu menuAdd) {
    String menFoodType = menuAdd.getMenFoodType();
    String menVegNonVeg = menuAdd.getMenVegNonVeg();
    String menItemName = menuAdd.getMenItemName();
    int menCalories = menuAdd.getMenCalories();
    int menItemId = menuAdd.getMenItemId();
    int vendorId = menuAdd.getVendorId();
    double menVenPrice = menuAdd.getMenVenPrice();
    Menu menuAddIt = new Menu(menFoodType, menVegNonVeg, menItemName, menCalories, menItemId, vendorId, menVenPrice);
    VendorFactory.addFoodItem(menuAddIt);
    VendorFactory.addFoodItem1(menuAddIt);
    return Response.status(Response.Status.OK).build();
  }
}

