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
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.factory.VendorFactory;
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
* @param ordId to Intitalize the ord Id.
* @return the vendor details.
 */
  @GET
  @Path("/{venId}/orders/{ordId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Orders> fetchOrderDetailsByVenId(@PathParam ("venId") final int venId,  @PathParam ("ordId") final int ordId) {
    Validators.validateVendorId(venId);
    return OrdersFactory.showOrders(venId);
  }
/**
* Return orders details.
* @param ordId to Intitalize the ordId.
* @param orders to Intitalize the orders.
* @param venId to Intitalize the venId.
 */
  @PUT
  @Path("/{venId}/orders/{ordId}")
  @Consumes(MediaType.APPLICATION_JSON)
  public final void updateOrderStatusApproved(@PathParam ("venId") final int venId, @PathParam ("ordId") final int ordId, final Orders orders) {
    Validators.validateVendorIdAndOrdId(venId, ordId);
    System.out.println(orders.getOrderStatus());
    OrdersFactory.updatePendingOrders(ordId, orders.getOrderStatus(), venId);

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
    int venId = vendor.getVendorId();
    String venPass = vendor.getVenPass();
    Validators.validateVenIdandPass(venId, venPass);
    return Response.status(Response.Status.OK).entity("valid").build();
  }
}

