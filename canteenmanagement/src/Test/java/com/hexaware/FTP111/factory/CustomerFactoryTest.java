package com.hexaware.FTP111.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP111.model.Customer;
import com.hexaware.FTP111.persistence.CustomerDAO;
//import com.hexaware.FTP111.util.Validators;

import org.junit.Test;
//import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
//import mockit.integration.junit4.JMockit;
//import mockit.internal.mockups.MockClassSetup;
/**
* to test Customer Factory class.
 */
public class CustomerFactoryTest {
/**
* test class for GetCustomerDetails.
* @param dao int to initalize customer.
 */
  @Test
    public final void testGetCustomerDetails(@Mocked final CustomerDAO dao) {

    new MockUp<CustomerFactory>() {
        @Mock
            public CustomerDAO dao() {
            return dao;
        }
        };

    List<Customer> customerDetailsList = new ArrayList();
    customerDetailsList.add(new Customer(1, "avi", "1234567890", "aviwalia@gmail.com"));
    customerDetailsList.add(new Customer(2, "ram", "1234567892", "ramwalia@gmail.com"));

    new Expectations() { {
        List<Customer> customerDetailsList2 = new ArrayList();
        customerDetailsList2.add(new Customer(1, "avi", "1234567890", "aviwalia@gmail.com"));
        customerDetailsList2.add(new Customer(2, "ram", "1234567892", "ramwalia@gmail.com"));
        dao.show(2); result = customerDetailsList2;
      } };

    List<Customer> list = CustomerFactory.customerDetails(2);

    assertEquals(2, list.size());
    new Verifications() { {
        dao.show(2); times = 1;
      } };
  }
  /**
* Test method for Customer factory Constructor.
 */
  @Test
  public final void testCusfactoryConstructor() {
    assertNotNull(new CustomerFactory());
  }
/**
* Test for find By Customer Id Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void findByCustomerId(@Mocked final CustomerDAO dao) {
    new MockUp<CustomerFactory>() {
      @Mock
      public CustomerDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.fetchCustomerId(20, "ok"); result = 50;
        }
    };
    int authentication = CustomerFactory.findByCustomerId(20, "ok");
    assertEquals(authentication, 50);
    new Verifications() { {
        dao.fetchCustomerId(20, "ok"); times = 1;
        }
    };
  }
}
