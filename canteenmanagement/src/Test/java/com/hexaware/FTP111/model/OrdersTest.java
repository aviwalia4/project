package com.hexaware.FTP111.test.model;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.Vendor;
import com.hexaware.FTP111.model.OrderStatus;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
/**
*Test class for orders details.
 */
public class OrdersTest {
  private Orders order1;
  private Orders order2;
  private Orders order3;
  private Orders order4;
  private Orders order5;
  private Orders order6;
  private Orders order7;
  private Orders order8;

/**
* setValue method.
 */
  @Before
  public final void setup() {
    order1 = new Orders(1, 2, 3, "hello", 4, 100d, OrderStatus.PENDING);
    order2 = new Orders(1, 2, 3, "hello", 4, 100d, OrderStatus.PENDING);
  }
/**
* setValue1 method.
 */
  @Before
  public final void setup1() {
    order3 = new Orders(3, 15, 4, 100d);
    order4 = new Orders(3, 15, 4, 100d);
  }
/**
* setValue2 method.
 */
  @Before
  public final void setup2() {
    order5 = new Orders(5, 6, 100d, 4);
    order6 = new Orders(5, 6, 100d, 4);
  }
/**
* setValue3 method.
 */
  @Before
  public final void setup3() {
    order7 = new Orders(10, OrderStatus.PENDING, 4);
    order8 = new Orders(10, OrderStatus.PENDING, 4);
  }
/**
* Check 1st constructor.
 */
  @Test
  public final void testOrdersConstructor1() {
    assertEquals(1, order1.getOrderId());
    assertEquals(2, order1.getCusId());
    assertEquals("hello", order1.getVendorName());
    assertEquals(4, order1.getWalTransId());
    assertEquals(100d, order1.getOrderTotalPrice(), 0);
    assertEquals(OrderStatus.PENDING, order1.getOrderStatus());
  }
/**
* Check 2nd constructor.
 */
  @Test
  public final void testOrdersConstructor2() {
    assertEquals(0, order5.getOrderId());
    assertEquals(5, order5.getCusId());
    assertEquals(4, order5.getWalTransId());
    assertEquals(100d, order5.getOrderTotalPrice(), 0);
  }
/**
*Test 3rd constructor.
 */
  @Test
  public final void testOrdersConstructor3() {
    assertEquals(15, order3.getCusId());
    assertEquals(0, order3.getVenId());
    assertEquals(100d, order3.getOrderTotalPrice(), 0);
    assertEquals(4, order3.getWalTransId());
  }
/**
* Check 4th constructor.
 */
  @Test
  public final void testOrdersConstructor4() {
    assertEquals(10, order7.getOrderId());
    assertEquals(OrderStatus.PENDING, order7.getOrderStatus());
    assertEquals(4, order7.getVenId());

  }
/**
*Test for Order Id.
 */
  @Test
  public final void testOrderId() {
    assertEquals(1, order1.getOrderId());
    order1.setOrderId(20);
    assertNotEquals(100, order1.getOrderId());
    assertEquals(20, order1.getOrderId());
  }
/**
*Test for Vendor Name.
 */
  @Test
  public final void testVendorName() {
    assertEquals("hello", order1.getVendorName());
    order1.setVendorName("bye");
    assertNotEquals("gj", order1.getVendorName());
    assertEquals("bye", order1.getVendorName());
  }
/**
*Test for Vendor Id.
 */
  @Test
  public final void testVenId() {
    assertEquals(0, order3.getVenId());
    order3.setVenId(10);
    assertNotEquals(20, order3.getVenId());
    assertEquals(10, order3.getVenId());
  }
/**
*Test for customer Id.
 */
  @Test
  public final void testCusId() {
    assertEquals(15, order3.getCusId());
    order3.setCusId(10);
    assertNotEquals(20, order3.getCusId());
    assertEquals(10, order3.getCusId());
  }
/**
*Test for Wallet Trans Id.
 */
  @Test
  public final void testWalTransId() {
    assertEquals(4, order1.getWalTransId());
    order1.setWalTransId(30);
    assertNotEquals(40, order1.getWalTransId());
    assertEquals(30, order1.getWalTransId());
  }
/**
*Test for Order Status.
 */
  @Test
  public final void testOrderStatus() {
    assertEquals(OrderStatus.PENDING, order1.getOrderStatus());
    order1.setOrderStatus(OrderStatus.APPROVED);
    assertNotEquals(OrderStatus.PENDING, order1.getOrderStatus());
    assertEquals(OrderStatus.APPROVED, order1.getOrderStatus());
  }
/**
*Test for Order Total Price.
 */
  @Test
  public final void testOrderTotalPrice() {
    assertEquals(100d, order1.getOrderTotalPrice(), 0);
    order1.setOrderTotalPrice(200d);
    assertNotEquals(100d, order1.getOrderTotalPrice(), 0);
    assertEquals(200d, order1.getOrderTotalPrice(), 0);
  }
/**
*Test for Not Equals1.
 */
  @Test
  public final void testNotEquals1() {
    Orders ord1 = new Orders(1, 2, 3, "hello", 4, 100d, OrderStatus.PENDING);
    Orders ord2 = new Orders(2, 3, 4, "ghjg", 14, 200d, OrderStatus.APPROVED);
    assertFalse(ord1.equals(ord2) && ord2.equals(ord1));
  }
/**
*Test for Equals1.
 */
  @Test
  public final void testEquals1() {
    Orders ord1 = new Orders(1, 2, 3, "hello", 4, 100d, OrderStatus.PENDING);
    Orders ord2 = new Orders(1, 2, 3, "hello", 4, 100d, OrderStatus.PENDING);
    assertTrue(ord1.equals(ord2) && ord2.equals(ord1));
    assertFalse(ord1.equals(null));
    assertFalse(ord1.equals(new Vendor()));
  }
/**
*Test for Not Equals2.
 */
  @Test
  public final void testNotEquals2() {
    Orders ord3 = new Orders(3, 15, 4, 100d);
    Orders ord4 = new Orders(30, 16, 40, 200d);
    assertFalse(ord3.equals(ord4) && ord4.equals(ord3));
  }
/**
*Test for Equals2.
 */
  @Test
  public final void testEquals2() {
    Orders ord3 = new Orders(3, 15, 4, 100d);
    Orders ord4 = new Orders(3, 15, 4, 100d);
    assertTrue(ord3.equals(ord4) && ord4.equals(ord3));
  }
/**
*Test for HashCode OrdId.
 */
  @Test
  public final void testHashCodeOrdId() {
    assertTrue(order1.hashCode() == order2.hashCode());
    order1.setOrderId(200);
    assertFalse(order1.hashCode() == order2.hashCode());
  }
/**
*Test for HashCode CusId.
 */
  @Test
  public final void testHashCodeCusId() {
    assertTrue(order1.hashCode() == order2.hashCode());
    order1.setCusId(500);
    assertFalse(order1.hashCode() == order2.hashCode());
  }
/**
*Test for HashCode VenId.
 */
  @Test
  public final void testHashCodeVenId() {
    assertTrue(order3.hashCode() == order4.hashCode());
    order3.setVenId(50);
    assertFalse(order3.hashCode() == order4.hashCode());
  }

/**
*Test for HashCode WalTranId.
 */
  @Test
  public final void testHashCodeWalTranId() {
    assertTrue(order1.hashCode() == order2.hashCode());
    order1.setWalTransId(100);
    assertFalse(order1.hashCode() == order2.hashCode());
  }
/**
*Test for HashCode OrderStatus.
 */
  @Test
  public final void testHashCodeOrderStatus() {
    assertTrue(order1.hashCode() == order2.hashCode());
    order1.setOrderStatus(OrderStatus.APPROVED);
    assertFalse(order1.hashCode() == order2.hashCode());
  }
/**
*Test for HashCode Order TotalPrice.
 */
  @Test
  public final void testHashCodeOrderTotalPrice() {
    assertTrue(order1.hashCode() == order2.hashCode());
    order1.setOrderTotalPrice(343);
    assertFalse(order1.hashCode() == order2.hashCode());
  }
/**
*Test for HashCode WalTranId.
 */
  @Test
  public final void testHashCodeVendorName() {
    assertTrue(order1.hashCode() == order2.hashCode());
    order1.setVendorName("fdsf");
    assertFalse(order1.hashCode() == order2.hashCode());
  }
}























