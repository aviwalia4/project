package com.hexaware.FTP111.test.models;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import com.hexaware.FTP111.model.Customer;
import com.hexaware.FTP111.model.Wallet;

/**
* Test class for customer.
 */
public class CustomerTest {
  private Customer testingCus;
/**
* Test class for customer.
 */
  @Before
    public final void setup() {
    testingCus = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
  }
/**
* Test method for Customer Constructor.
 */
  @Test
  public final void testCusConstructor() {
    assertEquals(1, testingCus.getCustomerId());
    assertEquals("avi", testingCus.getCustomerName());
    assertEquals("1234567890", testingCus.getCustomerPhone());
    assertEquals("aviwalia@gmail.com", testingCus.getCustomerEmail());
  }
/**
* Test method for Customer Constructor.
 */
  @Test
  public final void testCusConstructor2() {
    assertNotNull(new Customer());
  }
/**
* Test method for Customer ID.
 */
  @Test
  public final void testSetCustomerId() {
    assertEquals(1, testingCus.getCustomerId());
    testingCus.setCustomerId(10);
    assertEquals(10, testingCus.getCustomerId());
    assertNotEquals(5, testingCus.getCustomerId());
  }
/**
* Test method for Customer Name.
 */
  @Test
  public final void testSetCustomerName() {
    assertEquals("avi", testingCus.getCustomerName());
    testingCus.setCustomerName("Ram");
    assertEquals("Ram", testingCus.getCustomerName());
    assertNotEquals("sham", testingCus.getCustomerName());
  }
  /**
* Test method for Customer phone.
 */
  @Test
  public final void testSetCustomerPass() {
    testingCus.setCustomerPass("1234567890");
    assertEquals("1234567890", testingCus.getCustomerPass());
    testingCus.setCustomerPass("1234567891");
    assertEquals("1234567891", testingCus.getCustomerPass());
    assertNotEquals("1234567842", testingCus.getCustomerPass());
  }
/**
* Test method for Customer phone.
 */
  @Test
  public final void testSetCustomerPhone() {
    assertEquals("1234567890", testingCus.getCustomerPhone());
    testingCus.setCustomerPhone("1234567891");
    assertEquals("1234567891", testingCus.getCustomerPhone());
    assertNotEquals("1234567842", testingCus.getCustomerPhone());
  }
/**
* Test method for Customer Email.
 */
  @Test
  public final void testCustomerEmail() {
    assertEquals("aviwalia@gmail.com", testingCus.getCustomerEmail());
    testingCus.setCustomerEmail("aviwalia1@gmail.com");
    assertEquals("aviwalia1@gmail.com", testingCus.getCustomerEmail());
    assertNotEquals("aviwal1@gmail.com", testingCus.getCustomerEmail());
  }
/**
* Test method for Object Is Null.
 */
  @Test
  public final void testObjectIsNull() {
    assertNotEquals(testingCus, null);
  }
/**
* Test method for test Get Class.
 */
  @Test
  public final void testGetClass() {
    Wallet wallet = new Wallet(1, 10.00, "hirir");
    assertFalse(testingCus.equals(wallet));
  }
/**
* Test method for test Get Class.
 */
  @Test
  public final void testHashCodeTrue() {
    Customer x = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    Customer y = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    assertTrue(x.hashCode() == y.hashCode());
  }
/**
* Test method for test Hash Code False.
 */
  @Test
  public final void testHashCodeFalse() {
    Customer x = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    Customer y = new Customer(2, "avi5", "11234567890", "asviwalia@gmail.com");
    assertFalse(x.hashCode() == y.hashCode());
  }
  /**
* Test method for test test Empty Object.
 */
  @Test
  public final void testEmptyObject() {
    assertFalse(testingCus.equals(null));
  }
/**
* Test method for test Hash Code False.
 */
  @Test
  public final void testNotEquals() {
    Customer x = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    Customer y = new Customer(2, "avi5", "11234567890", "asviwalia@gmail.com");
    assertFalse(x.equals(y) && y.equals(x));
  }
/**
* Test method for test Hash Code False.
 */
  @Test
  public final void testEquals() {
    Customer x = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    Customer y = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    assertTrue(x.equals(y) && y.equals(x));
  }
}
