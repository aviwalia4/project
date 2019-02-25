package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.MenuDetails;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
  /**
    *to test mapper class.
    */

public class MenuDetailsMapperTest {
      /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */

  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
        {
          resultSet.getInt("MEN_ITEM_ID"); result = 23;
          resultSet.getInt("VEN_ID"); result = 14;
          resultSet.getDouble("MEN_VEN_PRICE"); result = 45.00;
          resultSet.getInt("MEN_VEN_RATING"); result = 4;
          resultSet.getInt("MEN_CALORIES"); result = 19;
      }
        };
    MenuDetailsMapper menudetailsMapper = new MenuDetailsMapper();
    MenuDetails menudetails = menudetailsMapper.map(23, resultSet, null);
    assertEquals(23, menudetails.getMenItemId());
    assertEquals(14, menudetails.getVenId());
    assertEquals(45.00, menudetails.getMenVenPrice(), 0);
    assertEquals(4, menudetails.getMenVenRating());
    assertEquals(19, menudetails.getMenCalories());

    new Verifications() { {
          resultSet.getInt("MEN_ITEM_ID"); times = 1;
          resultSet.getInt("VEN_ID"); times = 1;
          resultSet.getDouble("MEN_VEN_PRICE"); times = 1;
          resultSet.getInt("MEN_VEN_RATING"); times = 1;
          resultSet.getInt("MEN_CALORIES"); times = 1;
        } };

  }
}

