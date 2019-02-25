package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.Vendor;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

/**
* to test mapper class.
 */
public class VendorMapperTest {
/**
* @param resultSet to set resultSet.
* @throws SQLException to throw exception.
*to test Mapper Method.
 */
  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {
    new Expectations() {
        {
          resultSet.getInt("VEN_ID"); result = 20;
          resultSet.getString("VEN_PHONE"); result = "9915520082";
          resultSet.getString("VEN_ACCOUNT_NO"); result = "34112544";
          resultSet.getDouble("VEN_BALANCE"); result = 3555.0;
      }
    };
    VendorMapper vendorMapper = new VendorMapper();
    Vendor vendor = vendorMapper.map(20, resultSet, null);
    assertEquals(20, vendor.getVendorId());
    assertEquals("9915520082", vendor.getVendorPhone());
    assertEquals("34112544", vendor.getVendorAccNo());
    assertEquals(3555.0, vendor.getVendorBalance(), 0);

    new Verifications() { {
        resultSet.getInt("VEN_ID"); times = 1;
        resultSet.getString("VEN_PHONE"); times = 1;
        resultSet.getString("VEN_ACCOUNT_NO"); times = 1;
        resultSet.getDouble("VEN_BALANCE"); times = 1;
      } };
  }
}
