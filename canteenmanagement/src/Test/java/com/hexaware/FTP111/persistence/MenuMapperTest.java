package com.hexaware.FTP111.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP111.model.Menu;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
  /**
    *to test mapper class.
    */

public class MenuMapperTest {
      /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */

  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
        {
          resultSet.getInt("MEN_ITEM_ID"); result = 56;
          resultSet.getString("MEN_FOOD_TYPE"); result = "CONTINENTAL";
          resultSet.getString("MEN_VEG_NON_VEG"); result = "EGGITARIAN";
          resultSet.getString("MEN_ITEM_NAME"); result = "YEllow Dal";
          resultSet.getInt("MEN_CALORIES"); result = 19;
      }
        };
    MenuMapper menuMapper = new MenuMapper();
    Menu menu = menuMapper.map(0, resultSet, null);
    assertEquals(56, menu.getMenItemId());
    assertEquals("CONTINENTAL", menu.getMenFoodType());
    assertEquals("EGGITARIAN", menu.getMenVegNonVeg());
    assertEquals("YEllow Dal", menu.getMenItemName());
    assertEquals(19, menu.getMenCalories());

    new Verifications() { {
          resultSet.getInt("MEN_ITEM_ID"); times = 1;
          resultSet.getString("MEN_FOOD_TYPE"); times = 1;
          resultSet.getString("MEN_VEG_NON_VEG"); times = 1;
          resultSet.getString("MEN_ITEM_NAME"); times = 1;
          resultSet.getInt("MEN_CALORIES"); times = 1;
        } };

  }
}
