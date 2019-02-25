package com.hexaware.FTP111.util;
import com.hexaware.FTP111.factory.CustomerFactory;
import com.hexaware.FTP111.factory.WalletFactory;
import com.hexaware.FTP111.factory.MenuFactory;
import com.hexaware.FTP111.factory.VendorFactory;
/**
* Validator class used to validate.
* @author hexaware
 */
public final class Validators {
  private Validators() {

  }
/**
* @param venId to intialize the Vendor Id details.
* @param venPass to intialize the Vendor Password.
 */
  public static void validateVendor(final int venId, final String venPass) {
    int vendor = VendorFactory.findByVendor(venId, venPass);
    if (vendor == 0) {
      throw new IllegalArgumentException("Invalid vendorId or Password");
    }
  }
/**
* @param cusId to intialize the Customer Id.
* @param cusPass to intialize the Customer Password.
 */
  public static void validateCustomerId(final int cusId, final String cusPass) {
    int customer = CustomerFactory.findByCustomerId(cusId, cusPass);
    if (customer == 0) {
      throw new IllegalArgumentException("Invalid customer Id or Password");
    }
  }

/**
* @param cusId to intialize the Customer Id.
 */
  public static void validateCusId(final int cusId) {
    int customer = CustomerFactory.findByCusId(cusId);
    if (customer == 0) {
      throw new IllegalArgumentException("Invalid customer Id");
    }
  }


/**
* @param walletId to intialize the wallet Id.
* @param cusId to intialize the Customer Id.
 */
  public static void validateWalletId(final int walletId, final int cusId) {
    int wallet = WalletFactory.findByWalletId(walletId, cusId);
    if (wallet == 0) {
      throw new IllegalArgumentException("Invalid Wallet Id");
    }
  }
    // public static void validateVendorId(int venId) {
    //     int vendor = VendorFactory.findByVenId(venId);
    //     if (vendor == 0) {
    //         throw new IllegalArgumentException("Invalid Vendor Id");
    //     }
    // }
/**
* @param menItemId to intialize the menu item Id.
 */
  public static void validateMenuItemId(final int menItemId) {
    int menu = MenuFactory.findByMenItemId(menItemId);
    if (menu == 0) {
      throw new IllegalArgumentException("Invalid Menu Item Id");
    }
  }

/**
* @param venId to intialize the vendor Id.
 */
  public static void validateVendorId(final int venId) {
    int vendorId = VendorFactory.findByVendorId(venId);
    if (vendorId == 0) {
      throw new IllegalArgumentException("Invalid vendor");
    }
  }
/**
* @param venId to intialize the vendor Id.
* @param venPass to intialize the vendor Id.
 */
  public static void validateVenIdandPass(final int venId, final String venPass) {
    int vendorId = VendorFactory.findByVendor(venId, venPass);
    if (vendorId == 0) {
      throw new IllegalArgumentException("Invalid vendor Id or password");
    }
  }
/**
* @param walletId to intialize the Wallet Id.
 */
  public static void validateOrderPrice(final int walletId) {
    double wallet = WalletFactory.findByOrderPrice(walletId);
    if (wallet == 0) {
      throw new IllegalArgumentException("Invalid Wallet Id");
    }
  }

/**
* @param venId to intialize the Vendor Id details.
* @param ordId to intialize the order Id.
 */
  public static void validateVendorIdAndOrdId(final int venId, final int ordId) {
    int vendor = VendorFactory.validateVendorIdAndOrdId(venId, ordId);
    if (vendor == 0) {
      throw new IllegalArgumentException("Invalid vendorId or orderId");
    }
  }
}

