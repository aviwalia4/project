package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.model.OrderStatus;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * OrderItemMapper class used to fetch Order Item data from database.
 * @author hexaware
 */
public class OrderItemMapper implements ResultSetMapper<OrderItem> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final OrderItem map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
     /**
       * @return Pending Orders to vendor.
       */
    OrderItem orders = new OrderItem(rs.getInt("CUS_ID"),
        rs.getInt("MEN_ITEM_ID"),
        rs.getInt("ORD_ITEM_ID"),
        rs.getDouble("ORD_ITEM_PRICE"),
        rs.getInt("ORD_ID"),
        rs.getString("COMMENTS"));
    orders.setOrderStatus(OrderStatus.valueOf(rs.getString("ORD_STATUS")));
    return orders;
  }
}
