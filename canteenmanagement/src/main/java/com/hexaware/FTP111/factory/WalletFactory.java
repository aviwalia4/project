package com.hexaware.FTP111.factory;

import com.hexaware.FTP111.persistence.WalletDAO;
//mport com.sun.javafx.image.impl.IntArgb;
import com.hexaware.FTP111.persistence.DbConnection;
import java.util.List;

import com.hexaware.FTP111.model.Wallet;
/**
* Vendor Factory class used to fetch Vendor data from database.
* @author hexware
 */
public class WalletFactory {
/**
*Protected constructor.
 */
/**
*empty method.
 */
  protected WalletFactory() {
  }
/**
* Call the data base connection.
* @return the connection object.
 */
  private static WalletDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(WalletDAO.class);
  }
/**
* @param cusId to Initialize the cusId.
* @return the array of showWallet object.
 */
  public static final List<Wallet> showWallet(final int cusId) {
    List<Wallet> walletList = dao().showWallet(cusId);
    return walletList;
  }
/**
* Call the data base connection.
* @param walletId to Initialize the walletId.
* @return the array of vendorDetails object.
 */
  public static final double findByOrderPrice(final int walletId) {
    double wallAmount = dao().fetchOrderPrice(walletId);
    return wallAmount;
  }
/**
* @param walletId to Initialize the walletId.
* @param cusId to Initialize the customer Id.
* @return id.
 */
  public static final int findByWalletId(final int walletId, final int cusId) {
    int id = dao().fetchWalletId(walletId, cusId);
    return id;
  }
/**
* @param updateCusBal to update the customer balance.
* @param cusId to Initialize the customerId.
* @param walletId to Initialize the walletId.
 */
  public static final void cusUpdate(final double updateCusBal, final int cusId, final int walletId) {
    dao().cusUpdate(updateCusBal, cusId, walletId);
  }

// /**
// * @param ordPrice to Initialize the ordPrice.
// * @param cusId to Initialize the cusId.
// * @param wallId to Initialize the walletId.
//  */
//   public static final void updateBal(final double ordPrice, final int cusId, final int wallId) {
//     dao().updateBal(ordPrice, cusId, wallId);
//   }
/**
* @param walTranId to Initialize the walletId.
* @param cusId to Initialize the customer Id.
* @param refundAmount to initialize refund amount.
 */
  public static final void refundCustomer(final double refundAmount, final int cusId, final int walTranId) {
    dao().refundCustomer(refundAmount, cusId, walTranId);
  }
}


