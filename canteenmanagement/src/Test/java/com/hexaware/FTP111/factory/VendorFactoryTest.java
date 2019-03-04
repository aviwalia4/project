package com.hexaware.FTP111.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP111.model.Vendor;
import com.hexaware.FTP111.persistence.VendorDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

/**
* to test vendor Factory class.
* @param dao to Initialize the dao.
 */

@RunWith(JMockit.class)
public class VendorFactoryTest {
/**
* test class for testvenUpdate.
* @param dao to Initialize the dao.
 */
  @Test
  public final void testvenUpdate(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
        @Mock
        public VendorDAO dao() {
            return dao;
        }
    };
    new Expectations() { {
        dao.venUpdate(20.0, 20);
      } };
    VendorFactory.venUpdate(20.0, 20);
    new Verifications() { {
        dao.venUpdate(20.0, 20); times = 1;
      } };
  }
/**
* Test for Update Vendor Balance.
* @param dao to initialize the dao.
 */
  @Test
  public final void testupdateVenBal(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
          @Mock
          public VendorDAO dao() {
        return dao;
          }
    };
    new Expectations() { {
        dao.updateVenBal(22.2, 2);
      } };
    VendorFactory.updateVenBal(22.2, 2);
    new Verifications() { {
        dao.updateVenBal(22.2, 2); times = 1;
      } };
  }
/**
* Test for find By vendor Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void testFetchVenBalance(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
    public VendorDAO dao() {
        return dao;
      } };
    new Expectations() { {
        dao.fetchVenBalance(20); result = 50.00;
      } };
    double authentication = VendorFactory.fetchVenBalance(20);
    assertEquals(authentication, 50.00, 0);
    new Verifications() { {
        dao.fetchVenBalance(20); times = 1;
      } };
  }
/**
* Test for find By Wallet Id Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void testfindByVendorId(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
    public VendorDAO dao() {
        return dao;
      } };
    new Expectations() { {
        dao.fetchVendorId(20); result = 50;
      } };
    int authentication = VendorFactory.findByVendorId(20);
    assertEquals(authentication, 50);
    new Verifications() { {
        dao.fetchVendorId(20); times = 1;
      } };
  }
/**
* Test method for Vendor Factory Constructor.
 */
  @Test
  public final void testVendorFactoryConstructor2() {
    assertNotNull(new VendorFactory());
  }
/**
* Test for show vendor test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void testVendorShow(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
    public VendorDAO dao() {
        return dao;
      } };
    List<Vendor> list = new ArrayList<Vendor>();
    Vendor o1 = new Vendor(1, "jaga", "Bye", "Hey", 20.0, "jaga@gmail.com");
    Vendor o2 = new Vendor(2, "gaga", "Nope", "Wow", 30.0, "gaga@gmail.com");
    Vendor o3 = new Vendor(3, "heya", "Sia", "Yo", 40.0, "heya@gmail.com");
    list.add(o1);
    list.add(o2);
    list.add(o3);
    new Expectations() { {
        List<Vendor> list = new ArrayList<Vendor>();
        Vendor o1 = new Vendor(1, "jaga", "Bye", "Hey", 20.0, "jaga@gmail.com");
        Vendor o2 = new Vendor(2, "gaga", "Nope", "Wow", 30.0, "gaga@gmail.com");
        Vendor o3 = new Vendor(3, "heya", "Sia", "Yo", 40.0, "heya@gmail.com");
        list.add(o1);
        list.add(o2);
        list.add(o3);
        dao.show(2); result = list;
      } };
    List<Vendor> vendor = VendorFactory.vendorDetails(2);
    assertEquals(vendor, list);
    assertEquals(vendor.isEmpty(), false);
    assertEquals(vendor.size(), 3);
    new Verifications() { {
        dao.show(2); times = 1;
      } };
  }
/**
* Test for find By Vendor.
* @param dao to Initialize the dao.
 */
  @Test
  public final void testfindByVendor(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
      public VendorDAO dao() {
        return dao;
      } };
    new Expectations() { {
        dao.validateVendor(20, "GOOD123"); result = 50;
      } };
    int authentication = VendorFactory.findByVendor(20, "GOOD123");
    assertEquals(authentication, 50);
    new Verifications() { {
        dao.validateVendor(20, "GOOD123"); times = 1;
      } };
  }
}
