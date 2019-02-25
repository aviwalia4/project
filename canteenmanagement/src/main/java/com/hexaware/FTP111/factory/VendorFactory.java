package com.hexaware.FTP111.factory;

import com.hexaware.FTP111.persistence.VendorDAO;
import com.hexaware.FTP111.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP111.model.Vendor;
/**
* Vendor Factory class used to fetch Vendor data from database.
* @author hexware
 */
public class VendorFactory {
/**
*Protected constructor.
 */
/**
*empty method.
 */
  protected VendorFactory() {
  }
/**
* Call the data base connection.
* @return the connection object.
 */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
/**
* Call the data base connection.
* @param venId to Intitalize the orderId.
* @param venPass to Initialize the Vendor Password.
* @return the array of validateVendor object.
 */
  public static final int findByVendor(final int venId, final String venPass) {
    int validate = dao().validateVendor(venId, venPass);
    return validate;
  }
/**
* Call the data base connection.
* @param venId to Intitalize the orderId.
* @return the array of vendorDetails object.
 */
  public static final List<Vendor> vendorDetails(final int venId) {
    List<Vendor> vendorlist = dao().show(venId);
    return vendorlist;
  }
/**
* @param venId t initialize Vendor Id.
* @return venBal.
 */
  public static final double fetchVenBalance(final int venId) {
    double venBal = dao().fetchVenBalance(venId);
    return venBal;
  }
/**
* @param vendorAmount to initialize Vendor Amount.
* @param venId to initialize Vendor Id.
 */
  public static final void updateVenBal(final double vendorAmount, final int venId) {
    dao().updateVenBal(vendorAmount, venId);
  }
/**
* @return vendor Id.
* @param venId to initialize Vendor Id.
 */
  public static int findByVendorId(final int venId) {
    int id = dao().fetchVendorId(venId);
    return id;
  }
/**
* @param updateVenBal to update Vendor Balance.
* @param venId to initialize Vendor Id.
 */
  public static final void venUpdate(final double updateVenBal, final int venId) {
    dao().venUpdate(updateVenBal, venId);
  }
/**
* @param refundAmount to initialize refund amount.
* @param venId to initialize vendor id.
 */
  public static final void updateRefund(final double refundAmount, final int venId) {
    dao().venDeductAmount(refundAmount, venId);
  }
/**
* Call the data base connection.
* @param venId to Intitalize the ven id.
* @param ordId to Initialize the order id.
* @return the array of validateVendor object.
 */
  public static final int validateVendorIdAndOrdId(final int venId, final int ordId) {
    int validate = dao().validateVendorIdAndOrdId(venId, ordId);
    return validate;
  }
}
