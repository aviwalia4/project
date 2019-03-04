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
  @SqlQuery("select v.ven_id , "
      + " mv.MEN_VEN_PRICE , "
      + " v.VEN_NAME , "
      + " m.MEN_ITEM_ID , "
      + " mv.MEN_VEN_RATING , "
      + " m.MEN_FOOD_TYPE , "
      + " m.MEN_VEG_NON_VEG , "
      + " m.MEN_ITEM_NAME , "
      + " m.MEN_CALORIES from menu as m INNER JOIN"
      + " menu_vendor as mv on m.men_item_id=mv.MEN_ITEM_ID"
      + " inner join vendor as v on v.ven_id=mv.ven_id;")
    @Mapper(MenuMapper.class)
    List<Menu> show();
/**
* @return the create order.
* @param foodId to intialize the menu details.
 */
  @SqlQuery("Select m.MEN_ITEM_ID,"
              + " m.MEN_ITEM_NAME,"
              + " mv.VEN_ID,"
              + " v.VEN_NAME,"
              + " mv.MEN_VEN_PRICE,"
              + " mv.MEN_VEN_RATING,"
              + " m.MEN_CALORIES"
              + " FROM MENU as m INNER JOIN MENU_VENDOR as mv "
              + " ON m.MEN_ITEM_ID = mv.MEN_ITEM_ID "
              + " INNER JOIN VENDOR as v ON v.VEN_ID = mv.VEN_ID "
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
// /**
// * @return the order price.
// * @param menuAdd to intialize the menuAdd.
//  */
//   @SqlUpdate("INSERT INTO menu (MEN_FOOD_TYPE, MEN_VEG_NON_VEG, MEN_ITEM_NAME, MEN_CALORIES)"
//            + "VALUES (:MEN_FOOD_TYPE, :MEN_VEG_NON_VEG, :MEN_ITEM_NAME, :MEN_CALORIES);"
//            + "INSERT INTO menu_vendor (MEN_ITEM_ID, VEN_ID, MEN_VEN_PRICE, MEN_VEN_RATING)"
//            + "VALUES ((SELECT :MEN_ITEM_ID FROM menu WHERE MEN_ITEM_NAME = :MEN_ITEM_NAME), :VEN_ID, :MEN_VEN_PRICE, :MEN_VEN_RATING;")
//      @GetGeneratedKeys
//      int addFoodItem(@BindBean Menu menuAdd);

/**
* @return the Menu Item Id.
* @param menItemId to intialize the menu Item Id.
 */
  @SqlQuery("Select count(*) from MENU where MEN_ITEM_ID = :menItemId")
  int fetchMenItemId(@Bind ("menItemId")int menItemId);
}

