package com.hexaware.FTP111.Models;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.hexaware.FTP111.model.Wallet;
import static org.junit.Assert.assertNotNull;
import com.hexaware.FTP111.model.Customer;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
* for object.
*/
public class WalletTest {
  private Wallet walletDetails;
  /**
  * for object.
   */
  @Before
  public final void setUp() {
    walletDetails = new Wallet(1, 2, 500, "Net_Banking");
    walletDetails.setCustomerId(5);
    walletDetails.setWalletTransStatus("approved");
  }
  /**
  * for testing.
   */
  @Test
  public final void testWalletconstructor() {
    assertEquals(1, walletDetails.getWalletTranId());
    assertEquals(500, walletDetails.getWalletCurrentBalance(), 0);
    assertEquals("Net_Banking", walletDetails.getWalletPaymentMethod());
  }
  /**
  * Test method for Wallet Transaction Id.
   */
  @Test
  public final void testSetWalletTranId() {
    assertEquals(1, walletDetails.getWalletTranId());
    walletDetails.setWalletTranId(200);
    assertNotEquals(135, walletDetails.getWalletTranId());
  }
  /**
  * Test method for Wallet Payment Method.
   */
  @Test
  public final void testSetWalletPaymentMethod() {
    assertEquals("Net_Banking", walletDetails.getWalletPaymentMethod());
    walletDetails.setWalletPaymentMethod("Cash");
    assertNotEquals("ABC", walletDetails.getWalletPaymentMethod());
  }
  /**
  * Test method for Wallet Current Balance.
   */
  @Test
  public final void testSetWalletCurrentBalance() {
    assertEquals(500, walletDetails.getWalletCurrentBalance(), 0);
    walletDetails.setWalletCurrentBalance(158634);
    assertNotEquals(2357795, walletDetails.getWalletCurrentBalance(), 0);
  }
  /**
  * Test method for Wallet Customer Id.
   */
  @Test
  public final void testSetCustomerId() {
    assertEquals(5, walletDetails.getCustomerId());
    walletDetails.setCustomerId(634);
    assertNotEquals(235, walletDetails.getCustomerId());
  }
  /**
  * Test method for Wallet Transaction Status.
   */
  @Test
  public final void testSetWalletTransStatus() {
    assertEquals("approved", walletDetails.getWalletTransStatus());
    walletDetails.setWalletTransStatus("Not paid");
    assertNotEquals("Paid", walletDetails.getWalletTransStatus());
  }

  /**
  * Test method for Customer Constructor.
   */
  @Test
  public final void testWalletConstructor1() {
    assertNotNull(new Wallet());
  }
  /**
  * Test method for Object Is Null.
   */
  @Test
  public final void testObjectIsNull() {
    assertNotEquals(walletDetails, null);
  }
  /**
  * Test method for test Get Class.
   */
  @Test
  public final void testGetClass() {
    Customer customer = new Customer(1, "avi", "1234567890", "aviwalia@gmail.com");
    assertFalse(walletDetails.equals(customer));
  }

  /**
  * Test method for empty objects.
   */
  @Test
  public final void testEmptyObjs() {
    Wallet w1 = new Wallet(2, 2, 35000, "cash");
    Wallet w2 = new Wallet(2, 2, 35000, "cash");
    assertFalse(w2.equals(null));
  }
  /**
  * for testing Hash Code for wallet Id.
   */
  @Test
  public final void testHashWallId() {
    Wallet w1 = new Wallet(2, 2, 35000, "cash");
    Wallet w2 = new Wallet(2, 2, 35000, "cash");
    assertTrue(w1.hashCode() == w2.hashCode());
    w2.setWalletTranId(26);
    assertFalse(w1.hashCode() == w2.hashCode());
  }

  /**
  * for testing Hash Code for wallet Current Balance.
   */
  @Test
  public final void testHashwalletCurrentBalance() {
    Wallet w1 = new Wallet(2, 2, 35000, "cash");
    Wallet w2 = new Wallet(2, 2, 35000, "cash");
    assertTrue(w1.hashCode() == w2.hashCode());
    w2.setWalletCurrentBalance(225386);
    assertFalse(w1.hashCode() == w2.hashCode());
  }

  /**
  * for testing Hash Code for wallet Payment Method.
   */
  @Test
  public final void testHashwalletPaymentMethod() {
    Wallet w1 = new Wallet(2, 2, 35000, "cash");
    Wallet w2 = new Wallet(2, 2, 35000, "cash");
    assertTrue(w1.hashCode() == w2.hashCode());
    w2.setWalletPaymentMethod("paypal");
    assertFalse(w1.hashCode() == w2.hashCode());
  }
  /**
  * Test method for test equals.
   */
  @Test
  public final void testEquals() {
    Wallet w1 = new Wallet(2, 2, 35000, "cash");
    Wallet w2 = new Wallet(2, 2, 35000, "cash");
    assertTrue(w1.equals(w2) && w2.equals(w1));
  }
  /**
  * Test method for test not equals.
   */
  @Test
  public final void testNotEquals() {
    Wallet w1 = new Wallet(5, 2, 354500, "paypal");
    Wallet w2 = new Wallet(2, 2, 35000, "cash");
    assertFalse(w1.equals(w2) && w2.equals(w1));
  }
}
