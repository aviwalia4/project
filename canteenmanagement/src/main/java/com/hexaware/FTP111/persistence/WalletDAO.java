package com.hexaware.FTP111.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP111.model.Wallet;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
* WalletDAO class used to fetch data from data base.
* @author hexaware
 */
public interface WalletDAO {
/**
* @return the all the Wallet record.
* @param cusId to intialize the wallet details.
 */
  @SqlQuery(" Select wal_tran_id,"
            + " wal_current_balance,"
            + " wal_payment_method"
            + " from wallet"
            + " where cus_Id = :cusId order by wal_tran_id;")
    @Mapper(WalletMapper.class)
    List<Wallet> showWallet(@Bind("cusId")int cusId);
/**
* @return the Wallet Details.
* @param walletId to intialize the Wallet Id.
 */
  @SqlQuery(" Select wal_current_balance"
          + " from wallet"
          + " where wal_tran_id = :walletId;")
    double fetchOrderPrice(@Bind("walletId")int walletId);
/**
* @return the Wallet Details.
* @param walletId to intialize the Wallet Id.
* @param cusId to intialize the customer Id.
 */
  @SqlQuery(" Select count(*)"
          + " from wallet"
          + " where wal_tran_id = :walletId and cus_Id = :cusId;")
    int fetchWalletId(@Bind("walletId")int walletId, @Bind("cusId")int cusId);
/**
* @return the Wallet Details.
* @param updateCusBal to update Customer Balance.
* @param cusId to intialize the Cus Id.
* @param walletId to intialize the Wallet Id.
 */
  @SqlUpdate(" update wallet set WAL_CURRENT_BALANCE = :updateCusBal where CUS_ID = :cusId and WAL_TRAN_ID = :walletId;")
    int cusUpdate(@Bind("updateCusBal") double updateCusBal, @Bind("cusId") int cusId, @Bind("walletId") int walletId);
/**
* @param refundAmount to initialize refund amount.
* @param cusId to intialize the Cus Id.
* @param walTranId to intialize the Wallet Id.
 */
  @SqlUpdate("update WALLET set WAL_CURRENT_BALANCE = WAL_CURRENT_BALANCE + :refundAmount where cus_id = :cusId and WAL_TRAN_ID = :walTranId;")
   void refundCustomer(@Bind("refundAmount")double refundAmount, @Bind("cusId")int cusId, @Bind("walTranId")int walTranId);
}

