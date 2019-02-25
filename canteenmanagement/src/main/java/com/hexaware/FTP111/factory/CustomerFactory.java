package com.hexaware.FTP111.factory;

import com.hexaware.FTP111.persistence.CustomerDAO;
import com.hexaware.FTP111.persistence.DbConnection;
import java.util.List;

import com.hexaware.FTP111.model.Customer;
//import com.hexaware.FTP111.util.Validator;

/**
* CustomerFactory class used to fetch customer data from database.
* @author hexware
 */
public class CustomerFactory {
/**
*Protected constructor.
 */
/**
*empty method.
 */
  protected CustomerFactory() {
  }
/**
* Call the data base connection.
* @return the connection object.
 */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
/**
* Call the data base connection.
* @param cusId to intialize the customer details.
* @return the array of menu object.
 */
  public static List<Customer> customerDetails(final int cusId) {
    List<Customer> customerlist = dao().show(cusId);
    return customerlist;
  }
/**
* @param cusId to intialize the customer details.
* @param cusPass to Initialize the customer Password.
* @return the array of findByCustomerId object.
 */
  public static int findByCustomerId(final int cusId, final String cusPass) {
    int id = dao().fetchCustomerId(cusId, cusPass);
    return id;
  }
/**
* @param cusId to intialize the customer details.
* @return the array of findByCustomerId object.
 */
  public static int findByCusId(final int cusId) {
    int id = dao().fetchCusId(cusId);
    return id;
  }
}


