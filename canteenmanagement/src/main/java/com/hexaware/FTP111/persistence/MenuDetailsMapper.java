package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP111.model.MenuDetails;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * MenuDetailsMapper class used to fetch menu details data from database.
 * @author hexware
 */
public class MenuDetailsMapper implements ResultSetMapper<MenuDetails> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final MenuDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return MenuDetails
       */
    return new MenuDetails(rs.getInt("MEN_ITEM_ID"), rs.getInt("VEN_ID"),
      rs.getDouble("MEN_VEN_PRICE"), rs.getInt("MEN_VEN_RATING"), rs.getInt("MEN_CALORIES"));
  }
}
