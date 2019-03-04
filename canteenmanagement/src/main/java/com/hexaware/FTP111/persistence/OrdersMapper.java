package com.hexaware.FTP111.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.OrderStatus;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrdersMapper class used to fetch Orders data from database.
 * @author hexaware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
/**
* @return Orders
 */
    Orders orders = new Orders(rs.getInt("ORD_ID"), rs.getInt("CUS_ID"),
        rs.getInt("WAL_TRAN_ID"),
        rs.getDouble("ORD_TOTAL_PRICE"));
    orders.setVenId(rs.getInt("VEN_ID"));
    orders.setOrderStatus(OrderStatus.valueOf(rs.getString("ORD_STATUS")));
    orders.setOrderDate(rs.getDate("ORD_DATE_TIME"));
    orders.setVendorName(rs.getString("VEN_NAME"));
    return orders;
  }
}
