package com.hexaware.FTP111.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP111.model.MenuDetails;
import com.hexaware.FTP111.model.Menu;

/**
* MenuDAO class used to fetch data from data base.
* @author hexaware
 */
public interface MenuDAO {
/**
* @return the all the Menu record.
 */
  @SqlQuery("Select * from Menu;")
    @Mapper(MenuMapper.class)
    List<Menu> show();
/**
* @return the create order.
* @param foodId to intialize the menu details.
 */
  @SqlQuery("Select m.MEN_ITEM_ID,"
              + " m.MEN_ITEM_NAME,"
              + " mv.VEN_ID,"
              + " mv.MEN_VEN_PRICE,"
              + " mv.MEN_VEN_RATING,"
              + " m.MEN_CALORIES"
              + " FROM MENU as m INNER JOIN MENU_VENDOR as mv "
              + " ON m.MEN_ITEM_ID = mv.MEN_ITEM_ID "
              + " AND m.MEN_ITEM_ID = :foodId;")
    @Mapper(MenuDetailsMapper.class)
    List<MenuDetails> createOrder(@Bind ("foodId")int foodId);

/**
* @return the order price.
* @param venId to intialize the venId.
* @param menId to intialize the menId.
 */
  @SqlQuery(" Select MEN_VEN_PRICE "
           + " from MENU_VENDOR "
           + " where MEN_ITEM_ID = :menId and VEN_ID = :venId;")
double fetchOrderPrice(@Bind ("menId")int menId, @Bind ("venId")int venId);

/**
* @return the Menu Item Id.
* @param menItemId to intialize the menu Item Id.
 */
  @SqlQuery("Select count(*) from MENU where MEN_ITEM_ID = :menItemId")
int fetchMenItemId(@Bind ("menItemId")int menItemId);

}
