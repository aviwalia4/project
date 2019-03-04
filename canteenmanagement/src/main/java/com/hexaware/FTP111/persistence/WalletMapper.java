package com.hexaware.FTP111.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP111.model.Wallet;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
* WalletMapper used to fetch details from walet database.
* @author hexaware
 */
public class WalletMapper implements ResultSetMapper<Wallet> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Wallet map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Wallet
       */
    return new Wallet(rs.getInt("WAL_TRAN_ID"), rs.getInt("CUS_ID"), rs.getDouble("WAL_CURRENT_BALANCE"), rs.getString("WAL_PAYMENT_METHOD"));
  }
}

