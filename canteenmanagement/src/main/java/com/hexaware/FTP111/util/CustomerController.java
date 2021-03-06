package com.hexaware.FTP111.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP111.model.Customer;
import com.hexaware.FTP111.factory.CustomerFactory;
import com.hexaware.FTP111.factory.MenuFactory;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.factory.OrdersFactory;
import com.hexaware.FTP111.factory.VendorFactory;
import com.hexaware.FTP111.model.Wallet;
import com.hexaware.FTP111.factory.WalletFactory;
import java.util.List;
import javax.ws.rs.core.Response;

/**
* Root resource (exposed at "myresource" path).
 */
@Path("customers")
public class CustomerController {
/**
* Return customer details.
* @param cusId to Intitalize the customer Id.
* @return the customer details.
 */
  @GET
  @Path("/{cusId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Customer> findByCusId(@PathParam ("cusId") final int cusId) {
    Validators.validateCusId(cusId);
    return CustomerFactory.customerDetails(cusId);
  }
/**
* Return wallet details.
* @param cusId to Intitalize the customer Id.
* @param wallet to Intitalize the wallet.
* @return the wallet details.
 */
  @GET
  @Path("/{cusId}/wallets")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Wallet> showWalletById(@PathParam ("cusId") final int cusId, final Wallet wallet) {
    Validators.validateCusId(cusId);
    return WalletFactory.showWallet(cusId);
  }
/**
* Return customer details.
* @param cusId to Intitalize the customer Id.
* @return the customer details.
 */
  @GET
  @Path("/{cusId}/orders")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Orders> findOrderDetails(@PathParam ("cusId") final int cusId) {
    Validators.validateCusId(cusId);
    return OrdersFactory.getOrderDetails(cusId);
  }
/**
* Return customer details.
* @param menItemId to Intitalize the menItemId.
* @param orders to Intitalize the order.
* @param orderQuantity to Intitalize the order quantity.
* @return ordId.
 */
  @POST
  @Path("/{menItemId}/orders/{orderQuantity}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final int placeOrder(@PathParam ("menItemId") final int menItemId, final Orders orders,
      @PathParam ("orderQuantity") final int orderQuantity) {
    Validators.validateMenuItemId(menItemId);
    Validators.validateMenVenId(orders.getVenId(), menItemId);
    double orderPrice = MenuFactory.getOrderPrice(menItemId, orders.getVenId());
    orders.setOrderTotalPrice(orderPrice * orderQuantity);
    double totalOrderPrice = orders.getOrderTotalPrice();
    int ordId = OrdersFactory.setPlaceOrder(orders);
    OrderItem ordit1 = new OrderItem(orders.getCusId(), orders.getVenId(), menItemId, orderQuantity, orderPrice, ordId);
    OrdersFactory.updateOrderItems(ordit1);
    double venAmount = VendorFactory.fetchVenBalance(orders.getVenId());
    double wallAmount = WalletFactory.findByOrderPrice(orders.getWalTransId());
    double updateCusBal = wallAmount - totalOrderPrice;
    double updateVenBal = venAmount + totalOrderPrice;
    WalletFactory.cusUpdate(updateCusBal, orders.getCusId(), orders.getWalTransId());
    VendorFactory.venUpdate(updateVenBal, orders.getVenId());
    return ordId;
  }

/**
* @param customer to Intitalize the customer.
* @return response.
 */
  @POST
  @Path("/auth")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response customerLogin(final Customer customer) {
    int customerId = customer.getCustomerId();
    String customerPass = customer.getCustomerPass();
    Validators.validateCustomerId(customerId, customerPass);
    return Response.status(Response.Status.OK).build();
  }
}
