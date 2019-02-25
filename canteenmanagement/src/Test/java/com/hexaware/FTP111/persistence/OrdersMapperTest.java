package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.Orders;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import com.hexaware.FTP111.model.OrderStatus;
/**
* Test Mapper class.
 */
public class OrdersMapperTest {
/**
* @param resultSet to set resultSet.
* @throws SQLException to throw exception.
* to test Mapper Method.
 */
  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() { {
        resultSet.getInt("ORD_ID"); result = 10;
        resultSet.getInt("CUS_ID"); result = 66;
        resultSet.getInt("WAL_TRAN_ID"); result = 88;
        resultSet.getDouble("ORD_TOTAL_PRICE"); result = 500;
        resultSet.getString("ORD_STATUS"); result = "APPROVED";
        }
    };
    OrdersMapper ordersMapper = new OrdersMapper();
    Orders orders = ordersMapper.map(10, resultSet, null);
    assertEquals(10, orders.getOrderId());
    assertEquals(66, orders.getCusId());
    assertEquals(88, orders.getWalTransId());
    assertEquals(500, orders.getOrderTotalPrice(), 0);
    assertEquals(OrderStatus.APPROVED, orders.getOrderStatus());

    new Verifications() { {
        resultSet.getInt("ORD_ID"); times = 1;
        resultSet.getInt("CUS_ID"); times = 1;
        resultSet.getInt("WAL_TRAN_ID"); times = 1;
        resultSet.getDouble("ORD_TOTAL_PRICE"); times = 1;
        resultSet.getString("ORD_STATUS"); times = 1;
        }
    };
  }
}
