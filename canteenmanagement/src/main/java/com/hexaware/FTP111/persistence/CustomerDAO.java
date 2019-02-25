package com.hexaware.FTP111.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP111.model.Customer;
/**
* CustomerDAO class used to fetch data from data base.
* @author hexware
 */
public interface CustomerDAO {
/**
* @return the all the Customer record.
* @param cusId to intialize the customer details.
* @Mapper(CustomerMapper.class)
 */
  @SqlQuery("Select cus_id, cus_name, cus_phone, cus_email from customer where cus_id = :cusId;")
    @Mapper(CustomerMapper.class)
    List<Customer> show(@Bind("cusId")int cusId);
/**
* @return the all the Customer record.
* @param cusId to intialize the customer details.
* @param cusPass to intialize the customerPaasword.
 */
//   @SqlQuery("select cus_id from customer where cus_id = :cusId;")
//  @Mapper(CustomerMapper.class)
//     int fetchCustomerId(@Bind("cusId")int cusId);
  @SqlQuery("select count(cus_id) from customer where cus_id = :cusId and cus_pwd = :cusPass;")
    int fetchCustomerId(@Bind("cusId")int cusId, @Bind ("cusPass")String cusPass);
/**
* @return the all the Customer record.
* @param cusId to intialize the customer details.
 */
  @SqlQuery("select count(cus_id) from customer where cus_id = :cusId;")
    int fetchCusId(@Bind("cusId")int cusId);
}



