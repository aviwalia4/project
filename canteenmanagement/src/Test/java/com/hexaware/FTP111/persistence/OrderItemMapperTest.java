package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.OrderItem;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
  /**
    *to test mapper class.
    */

public class OrderItemMapperTest {
      /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */

  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
        {
          resultSet.getInt("ORD_ITEM_ID"); result = 33;
          resultSet.getInt("VEN_ID"); result = 54;
          resultSet.getInt("CUS_ID"); result = 42;
          resultSet.getDouble("ORD_ITEM_PRICE"); result = 40.0;
          resultSet.getString("ORD_STATUS"); result = "REJECTED";
      }
        };
    OrderItemMapper orderItemMapper = new OrderItemMapper();
    OrderItem orderItem = orderItemMapper.map(33, resultSet, null);
    assertEquals(33, orderItem.getOrdItemId());
    assertEquals(54, orderItem.getVenId());
    assertEquals(42, orderItem.getCusId(), 0);
    assertEquals(40.0, orderItem.getOrdItemPrice(), 0);
    assertEquals("REJECTED", orderItem.getOrdStatus());

    new Verifications() { {
          resultSet.getInt("ORD_ITEM_ID"); times = 1;
          resultSet.getInt("VEN_ID"); times = 1;
          resultSet.getInt("CUS_ID"); times = 1;
          resultSet.getDouble("ORD_ITEM_PRICE"); times = 1;
          resultSet.getString("ORD_STATUS"); times = 1;
        } };

  }
}

