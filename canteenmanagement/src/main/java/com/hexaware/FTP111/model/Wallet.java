package com.hexaware.FTP111.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* Wallet class used to display class information.
* @author hexaware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wallet {
  private int walletTranId;
  private String walletPaymentMethod;
  private double walletCurrentBalance;
  private String walletTransStatus;
  private int customerId;

/**
* Default Constructor.
 */
  public Wallet() {

  }
/**
* @param argWalletTranId to Initialize Wallet Transaction Id.
* @param argcustomerId to Initialize customer Id.
* @param argWalletCurrentBalance to Initialize Wallet Current Balance.
* @param argWalletPaymentMethod to Initialize wallet payment method.
 */
  public Wallet(final int argWalletTranId, final int argcustomerId, final double argWalletCurrentBalance, final String argWalletPaymentMethod) {
    this.walletTranId = argWalletTranId;
    this.customerId = argcustomerId;
    this.walletCurrentBalance = argWalletCurrentBalance;
    this.walletPaymentMethod = argWalletPaymentMethod;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wallet wal = (Wallet) obj;
    if (Objects.equals(walletTranId, wal.getWalletTranId())
        && Objects.equals(walletPaymentMethod, wal.getWalletPaymentMethod())
        && Objects.equals(walletCurrentBalance, wal.getWalletCurrentBalance())
        && Objects.equals(walletTransStatus, wal.getWalletTransStatus())
        && Objects.equals(customerId, wal.getCustomerId())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(walletTranId, walletPaymentMethod, walletCurrentBalance, walletTransStatus, customerId);
  }

/**
* @param argWalletTranId to Initialize wallet tran id.
 */
  public final void setWalletTranId(final int argWalletTranId) {
    this.walletTranId = argWalletTranId;
  }
/**
* @param argWalletPaymentMethod to Initialize wallet Payment Method.
 */
  public final void setWalletPaymentMethod(final String argWalletPaymentMethod) {
    this.walletPaymentMethod = argWalletPaymentMethod;
  }
/**
* @param argWalletTransStatus to Initialize wallet Trans Status.
 */
  public final void setWalletTransStatus(final String argWalletTransStatus) {
    this.walletTransStatus = argWalletTransStatus;
  }
/**
* @param argWalletCurrentBalance to Initialize Wallet Current Balance.
 */
  public final void setWalletCurrentBalance(final double argWalletCurrentBalance) {
    this.walletCurrentBalance = argWalletCurrentBalance;
  }
/**
* @param argCustomerId to Initialize customer Id.
 */
  public final void setCustomerId(final int argCustomerId) {
    this.customerId = argCustomerId;
  }
/**
* @return this to wallettranid.
 */
  public final int getWalletTranId() {
    return this.walletTranId;
  }
/**
* @return this to wallet payment method.
 */
  public final String getWalletPaymentMethod() {
    return this.walletPaymentMethod;
  }
/**
* @return this to wallet tran status.
 */
  public final String getWalletTransStatus() {
    return this.walletTransStatus;
  }
/**
* @return this to wallet current balance.
 */
  public final double getWalletCurrentBalance() {
    return this.walletCurrentBalance;
  }
/**
* @return this to customer id.
 */
  public final int getCustomerId() {
    return this.customerId;
  }
}
