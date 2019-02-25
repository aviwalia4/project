package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.Customer;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
/**
* to test CustomerMapper class.
 */
public class CustomerMapperTest {
/**
* @param resultSet to set resultSet.
* @throws SQLException to throw exception.
* to test Mapper Method.
 */
  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
      {
        resultSet.getInt("CUS_ID"); result = 1;
        resultSet.getString("CUS_NAME"); result = "avi";
        resultSet.getString("CUS_PHONE"); result = "1234567890";
        resultSet.getString("CUS_EMAIL"); result = "aviwalia@gmail.com";
      }
        };
    CustomerMapper customerMapper = new CustomerMapper();
    Customer customer = customerMapper.map(0, resultSet, null);
    assertEquals(1, customer.getCustomerId());
    assertEquals("avi", customer.getCustomerName());
    assertEquals("1234567890", customer.getCustomerPhone());
    assertEquals("aviwalia@gmail.com", customer.getCustomerEmail());

    new Verifications() {
      {
        resultSet.getInt("CUS_ID"); times = 1;
        resultSet.getString("CUS_NAME"); times = 1;
        resultSet.getString("CUS_PHONE"); times = 1;
        resultSet.getString("CUS_EMAIL"); times = 1;
      }
    };
  }
}
