package com.hexaware.FTP111.test.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import com.hexaware.FTP111.model.Vendor;
import com.hexaware.FTP111.model.Customer;

/**
* Test class for Vendor.
 */
public class VendorTest {
  private Vendor vendor;
/**
* setup method for Vendor.
 */
  @Before
    public final void setUp() {
    vendor = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
  }
/**
* Test method for Vendor.
 */
  @Test
    public final void testVendor() {
    assertEquals(2, vendor.getVendorId());
    assertEquals("jwala", vendor.getVendorName());
    assertEquals("9915542252", vendor.getVendorPhone());
    assertEquals("35448744452", vendor.getVendorAccNo());
    assertEquals(35000, vendor.getVendorBalance(), 0);
    assertEquals("jwala@gmail.com", vendor.getVendorEmail());
  }
/**
* Test method for vendor id.
 */
  @Test
  public final void testVenId() {
    assertEquals(2, vendor.getVendorId());
    vendor.setVendorId(6);
    assertNotEquals(20, vendor.getVendorId());
  }
  /**
* Test method for vendor Name.
 */
  @Test
  public final void testVenName() {
    assertEquals("jwala", vendor.getVendorName());
    vendor.setVendorName("lalal");
    assertNotEquals("kullu", vendor.getVendorName());
  }

/**
* Test method for vendor password.
 */
  @Test
  public final void testVenPass() {
    vendor.setVenPass("225!Fc2");
    assertEquals("225!Fc2", vendor.getVenPass());
    vendor.setVenPass("226!fC3");
    assertNotEquals("222!Fc5", vendor.getVenPass());
  }
/**
* Test method for vendor feedback.
 */
  @Test
  public final void testVenFeedback() {
    vendor.setVendorFeedback("WOW Food");
    assertEquals("WOW Food", vendor.getVendorFeedback());
    vendor.setVendorFeedback("BAD Food");
    assertNotEquals("WOW Foo", vendor.getVendorFeedback());
  }
/**
* Test method for vendor Phone number.
 */
  @Test
  public final void testVenPhone() {
    assertEquals("9915542252", vendor.getVendorPhone());
    vendor.setVendorPhone("5574412258");
    assertNotEquals("4415520098", vendor.getVendorPhone());
  }
/**
* Test method for vendor account number.
 */
  @Test
  public final void testVenAccNo() {
    assertEquals("35448744452", vendor.getVendorAccNo());
    vendor.setVendorAccNo("35448574452");
    assertNotEquals("3544874442", vendor.getVendorAccNo());
  }
/**
* Test method for vendor Balance.
*/
  @Test
  public final void testVenBalance() {
    assertEquals(35000, vendor.getVendorBalance(), 0);
    vendor.setVendorBalance(25000);
    assertNotEquals(35000, vendor.getVendorBalance(), 0);
  }
    /**
* Test method for vendor Email.
 */
  @Test
  public final void testVenEmail() {
    assertEquals("jwala@gmail.com", vendor.getVendorEmail());
    vendor.setVendorEmail("lalal@gmail.com");
    assertNotEquals("kullu@gmail.com", vendor.getVendorEmail());
  }

/**
* Test method for non parameterized vendor.
 */
  @Test
  public final void vendorDefault() {
    vendor = new Vendor();
    int vendorId = 0;
    assertEquals(vendorId, vendor.getVendorId());
    String vendorName = null;
    assertEquals(vendorName, vendor.getVendorName());
    String vendorPhone = null;
    assertEquals(vendorPhone, vendor.getVendorPhone());
    String vendorAccNo = null;
    assertEquals(vendorAccNo, vendor.getVendorAccNo());
    double vendorBalance = 0.0;
    assertEquals(vendorBalance, vendor.getVendorBalance(), 0);
    String vendorEmail = null;
    assertEquals(vendorEmail, vendor.getVendorEmail());
  }
/**
* Test method for empty objects.
 */
  @Test
  public final void testEmptyObjs() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertFalse(v2.equals(null));
  }
/**
* checking another class method.
 */
  @Test
  public final void testCusEmptyObjs() {
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Customer cus = new Customer();
    assertFalse(v2.equals(cus) && cus.equals(v2));
  }
/**
* for testing Hash Code for vendor Id.
 */
  @Test
  public final void testHashVenId() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.hashCode() == v2.hashCode());
    v2.setVendorId(26);
    assertFalse(v1.hashCode() == v2.hashCode());
  }
/**
* for testing Hash Code for vendor Name.
 */
  @Test
  public final void testHashVenName() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.hashCode() == v2.hashCode());
    v2.setVendorName("jaga");
    assertFalse(v1.hashCode() == v2.hashCode());
  }
/**
* for testing Hash Code for vendor Phone number.
 */
  @Test
  public final void testHashVenPhn() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.hashCode() == v2.hashCode());
    v2.setVendorPhone("5520015597");
    assertFalse(v1.hashCode() == v2.hashCode());
  }
/**
* for testing Hash Code for vendor Account number.
 */
  @Test
  public final void testHashVenAccNo() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.hashCode() == v2.hashCode());
    v2.setVendorAccNo("25994100055");
    assertFalse(v1.hashCode() == v2.hashCode());
  }
/**
* for testing Hash Code for vendor balance.
 */
  @Test
  public final void testHashVenBalance() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.hashCode() == v2.hashCode());
    v2.setVendorBalance(25000);
    assertFalse(v1.hashCode() == v2.hashCode());
  }
  /**
* for testing Hash Code for vendor Email.
 */
  @Test
  public final void testHashVenEmail() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.hashCode() == v2.hashCode());
    v2.setVendorEmail("gagaga@gmail.com");
    assertFalse(v1.hashCode() == v2.hashCode());
  }
/**
* Test method for test equals.
 */
  @Test
  public final void testEquals() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    assertTrue(v1.equals(v2) && v2.equals(v1));
  }
/**
* Test method for test not equals.
 */
  @Test
  public final void testNotEquals() {
    Vendor v1 = new Vendor(2, "jwala", "9915542252", "35448744452", 35000, "jwala@gmail.com");
    Vendor v2 = new Vendor(3, "jwa", "995542252", "354484452", 3000, "jwaa@gmail.com");
    assertFalse(v1.equals(v2) && v2.equals(v1));
  }
}

