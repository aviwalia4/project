package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.Wallet;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
  /**
    *to test mapper class.
    */

public class WalletMapperTest {
      /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */

  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
        {
          resultSet.getInt("WAL_TRAN_ID"); result = 5;
          resultSet.getDouble("WAL_CURRENT_BALANCE"); result = 7755757.0;
          resultSet.getString("WAL_PAYMENT_METHOD"); result = "Paypal";
      }
        };
    WalletMapper walletMapper = new WalletMapper();
    Wallet wallet = walletMapper.map(0, resultSet, null);
    assertEquals(5, wallet.getWalletTranId());
    assertEquals(7755757.0, wallet.getWalletCurrentBalance(), 0);
    assertEquals("Paypal", wallet.getWalletPaymentMethod());

    new Verifications() { {
          resultSet.getInt("WAL_TRAN_ID"); times = 1;
          resultSet.getDouble("WAL_CURRENT_BALANCE"); times = 1;
          resultSet.getString("WAL_PAYMENT_METHOD"); times = 1;
        } };

  }
}


