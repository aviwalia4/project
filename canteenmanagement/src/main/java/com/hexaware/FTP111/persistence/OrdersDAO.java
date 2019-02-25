package com.hexaware.FTP111.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.model.OrderStatus;

/**
* OrdersDAO class used to fetch data from data base.
* @author hexaware
 */
public interface OrdersDAO {
/**
* @return the all the Orders record.
* @param orderId to intialize the order Id.
 */
  @SqlQuery("Select o.ord_Id, o.cus_id, o.wal_tran_id, o.ord_total_price,"
      + "o.ord_status, o.ord_date_time " + "FROM orders o where o.ord_Id = :orderId;")
    @Mapper(OrdersMapper.class)
    List<Orders> orderDetails(@Bind ("orderId")int orderId);
/**
* @return the all the Orders record.
* @param venId to intialize the vendor id.
 */
  @SqlQuery("Select o.ord_Id, o.wal_tran_id, t.ORD_QUANTITY, o.ORD_TOTAL_PRICE, o.ORD_DATE_TIME, t.ord_item_id,t.ven_id,o.cus_id,"
             + " ord_item_price,t.ord_status"
             + " from (orders o inner join order_Item t on o.ord_Id = t.ord_Id)"
             + " Where t.ord_status = 'Pending' and t.ven_id = :venId;")
     @Mapper(OrdersMapper.class)
     List<Orders> showOrders(@Bind ("venId")int venId);
/**
* @return the all the updating order by customer.
* @param order to initialize Orders object.
 */
  @SqlUpdate(" insert into ORDERS(CUS_ID , VEN_ID , ORD_TOTAL_PRICE , WAL_TRAN_ID)"
      + " VALUES(:cusId, :venId, :orderTotalPrice, :walTransId);")
    @GetGeneratedKeys
    int setPlaceOrder(@BindBean Orders order);
/**
* @return the all the updating order by customer.
* @param orderItem to initialize OrderItem object.
 */
  @SqlUpdate(" insert into ORDER_ITEM(CUS_ID, VEN_Id, Men_Item_Id, ORD_QUANTITY, ORD_ITEM_PRICE, ORD_ID) "
      + " VALUES(:cusId, :venId, :menItemId, :orderQuantity, :ordItemPrice, :ordId);")
  @GetGeneratedKeys
    int updateOrderItems(@BindBean OrderItem orderItem);
/**
* @return the all the updating order by customer.
* @param cusId to initialize customer Id.
*/
  @SqlQuery("Select o.ord_Id,"
              + " o.cus_id,"
              + " o.wal_tran_id,"
              + " o.ord_total_price,"
              + " o.ord_status,"
              + " o.ord_date_time "
              + " FROM orders o "
              + " where o.cus_Id = :cusId;")
    @Mapper(OrdersMapper.class)
    List<Orders> getOrderDetails(@Bind ("cusId")int cusId);
/**
* @param orderstat to initialize order status.
* @param orderOption to initialize order option.
* @param venId to initialize vendor id.
 */
  @SqlUpdate("update order_item oi inner join orders o on oi.ord_id = o.ord_id"
           + " set oi.ord_status =:orderstat,"
          + "o.ord_status = :orderstat where o.ord_Id =:orderOption and o.ven_id = :venId;")
    void updatePendingOrders(@Bind("orderOption")int orderOption, @Bind("orderstat")OrderStatus orderstat, @Bind("venId")int venId);

/**
* @param orderOption to initialize order option.
* @param venId to initialize vendor id.
* @return refundAmount.
 */
  @SqlQuery("select ord_total_price from orders where ven_id = :venId and Ord_Id = :orderOption;")
    double refundAmount(@Bind("venId")int venId, @Bind("orderOption")int orderOption);

/**
* @param venId to initialize vendor id.
* @param orderOption to initialize order option.
* @return customer id.
 */
  @SqlQuery("select o.cus_id from order_Item oi, orders o"
        + " where o.ord_id = oi.ord_id and o.ven_Id = :venId and o.ord_id = :orderOption;")
    int getCusId(@Bind("venId")int venId, @Bind("orderOption")int orderOption);
/**
* @param orderOption to initialize order option.
* @return wallet tranaction Id.
 */
  @SqlQuery("select wal_tran_id from orders o, order_item oi"
        + " where o.ord_id = oi.ord_id and o.ord_id = :orderOption;")
    int getWalTransId(@Bind("orderOption")int orderOption);
/**
* @param orderOption to initialize order option.
* @param refundAmount to initialize refund amount.
 */
  @SqlUpdate("update orders o inner join order_item oi on o.ord_id = oi.ord_id"
          + " set o.ord_total_price = o.ord_total_price - :refundAmount where oi.ord_item_id = :orderOption")
    void updateTotal(@Bind("refundAmount")double refundAmount, @Bind("orderOption")int orderOption);
}

