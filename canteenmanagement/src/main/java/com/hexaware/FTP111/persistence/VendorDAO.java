package com.hexaware.FTP111.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP111.model.Vendor;
import com.hexaware.FTP111.model.Menu;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.BindBean;

//import com.hexaware.FTP111.persistence.VendorMapper;
/**
* VendorDAO class used to fetch data from data base.
* @author hexware
 */
public interface VendorDAO {
/**
* @return the all the Vendor record.
* @param venId to intialize the vendor details.
 */
  @SqlQuery("Select * from Vendor where ven_id = :venId;")
    @Mapper(VendorMapper.class)
    List<Vendor> show(@Bind("venId")int venId);
// /**
// * @return the create order.
// * @param vendorId to intialize the vendorId.
//  */
//   @SqlQuery("Select ven_id, ven_phone, ven_account, ven_balance from vendor;")
//     @Mapper(VendorMapper.class)
//     List<Vendor> vendor(@Bind ("vendorId")int vendorId);
/**
* @return the create order.
* @param venId to intialize the vendorId.
 */
  @SqlQuery(" Select VEN_ID"
          + " from VENDOR"
          + " where VEN_ID = :venId;")
    int fetchVendorId(@Bind("venId")int venId);
/**
* @return the validate vendorId and Password.
* @param venId to intialize the vendorId.
* @param venPass to intialize the vendorPaasword.
 */
  @SqlQuery("Select count(*) from vendor where ven_Id = :venId and ven_Password = :venPass;")
  int validateVendor(@Bind ("venId")int venId, @Bind ("venPass")String venPass);
/**
* @return the validate vendorId and menItemId.
* @param venId to intialize the vendorId.
* @param menItemId to intialize the menItemId.
 */
  @SqlQuery("Select count(*) from menu_vendor where ven_Id = :venId and men_item_id = :menItemId;")
  int validateMenVenId(@Bind ("venId")int venId, @Bind ("menItemId")int menItemId);
/**
* @param venId to initialize venId.
* @return venId.
 */
  @SqlQuery("Select VEN_BALANCE from vendor where ven_Id = :venId;")
  int fetchVenBalance(@Bind ("venId")int venId);
/**
* @param venId to initialize vendor Id.
* @param vendorAmount to initialize vendor total price.
 */
  @SqlUpdate("update vendor SET VEN_BALANCE = :vendorAmount where VEN_ID = :venId;")
  void updateVenBal(@Bind ("vendorAmount")double vendorAmount, @Bind ("venId")int venId);
/**
* @return the added item.
* @param menuAdd to intialize the menuAdd.
 */
  @SqlUpdate("INSERT INTO menu (MEN_FOOD_TYPE, MEN_VEG_NON_VEG, MEN_ITEM_NAME, MEN_CALORIES)"
           + "VALUES (:menFoodType, :menVegNonVeg, :menItemName, :menCalories);")
     @GetGeneratedKeys
     int addFoodItem(@BindBean Menu menuAdd);
/**
* @param menuAdd to intialize the menuAdd.
* @return menuAdd.
 */
  @SqlUpdate("INSERT INTO menu_vendor (MEN_ITEM_ID, VEN_ID, MEN_VEN_PRICE)"
           + " VALUES ((SELECT MEN_ITEM_ID FROM menu WHERE MEN_ITEM_NAME = :menItemName), :vendorId, :menVenPrice);")
     @GetGeneratedKeys
     int addFoodItem1(@BindBean Menu menuAdd);
/**
* @param updateVenBal to initialize update vendor balance.
* @param venId to initialize vendor Id.
* @return updateVenBal and venId.
 */
  @SqlUpdate(" update VENDOR set VEN_BALANCE = :updateVenBal where VEN_ID = :venId;")
    int venUpdate(@Bind("updateVenBal") double updateVenBal, @Bind("venId") int venId);

/**
* @param updateVenBal2 to initialize order option.
* @param venId to initialize vendor id.
 */
  @SqlUpdate("update vendor set VEN_BALANCE = VEN_BALANCE - :refundAmount where VEN_ID = :venId;")
    void venDeductAmount(@Bind("refundAmount")double updateVenBal2, @Bind("venId")int venId);

/**
* @return venId and ordId.
* @param venId to intialize the vendorId.
* @param ordId to intialize the order id.
 */
  @SqlQuery("Select count(*) from orders where ven_Id = :venId and ord_Id = :ordId;")
  int validateVendorIdAndOrdId(@Bind ("venId")int venId, @Bind ("ordId")int ordId);

/**
* @return venId.
* @param updateVenBal to update vendor balance.
* @param venId to initialize vendor Id.
 */
  @SqlUpdate("update VENDOR set VEN_BALANCE = :updateVenBal where VEN_ID = :venId")
    int venUpdate2(@Bind("updateVenBal") double updateVenBal, @Bind("venId") int venId);


}


