package com.hexaware.FTP111.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import com.hexaware.FTP111.model.OrderItem;
//import com.hexaware.FTP111.model.Customers;
//import com.hexaware.FTP111.model.OrderStatus;
/**
* for object.
 */
public class OrderItemTest {
  private OrderItem ordit;
  private OrderItem ordit2;
  /**
   * for setting Up values.
   */
  @Before
    public final void setUp() {
    ordit = new OrderItem(12, 81, 15, 3, 54.0, 32);
    ordit2 = new OrderItem(14, 81, 12, 54.0, OrderStatus.PENDING);
  }

/**
* for testing 1st Constructor.
 */
  @Test
    public final void testOrderItem() {
    assertEquals(12, ordit.getCusId());
    assertEquals(81, ordit.getVenId());
    assertEquals(15, ordit.getMenItemId());
    assertEquals(3, ordit.getOrderQuantity());
    assertEquals(54.0, ordit.getOrdItemPrice(), 0);
    assertEquals(32, ordit.getOrdId());
  }

/**
* for testing 2nd Constructor.
 */
  @Test
    public final void testOrderItem1() {
    assertEquals(14, ordit2.getOrdItemId());
    assertEquals(81, ordit2.getVenId());
    assertEquals(12, ordit2.getCusId());
    assertEquals(54.0, ordit2.getOrdItemPrice(), 0);
    assertEquals(OrderStatus.PENDING, ordit2.getOrderStatus());
  }

/**
* for testing Order Item Id.
 */
  @Test
    public final void testSetOrdItemId() {
    assertEquals(14, ordit2.getOrdItemId());
    ordit2.setOrdItemId(201);
    assertNotEquals(214, ordit2.getOrdItemId());
  }

/**
* for testing Menu Item Id.
 */
  @Test
    public final void testSetMenItemId() {
    assertEquals(15, ordit.getMenItemId());
    ordit.setMenItemId(541);
    assertNotEquals(214, ordit.getMenItemId());
  }

/**
* for testing Vendor Id.
 */
  @Test
    public final void testSetVenId() {
    assertEquals(81, ordit.getVenId());
    ordit.setVenId(21);
    assertNotEquals(43, ordit.getVenId());
  }

/**
* for testing Order Id.
 */
  @Test
    public final void testSetOrdId() {
    assertEquals(32, ordit.getOrdId());
    ordit.setOrdId(15);
    assertNotEquals(51, ordit.getOrdId());
  }

/**
* for testing Order Item Price.
 */
  @Test
    public final void testSetOrdItemPrice() {
    assertEquals(54, ordit.getOrdItemPrice(), 0);
    ordit.setOrdItemPrice(154);
    assertNotEquals(20, ordit.getOrdItemPrice(), 0);
  }

/**
* for testing Order Status.
 */
  @Test
    public final void testSetOrdStatus() {
    assertEquals(OrderStatus.PENDING, ordit2.getOrderStatus());
    ordit2.setOrderStatus(OrderStatus.PENDING);
    assertNotEquals(OrderStatus.APPROVED, ordit2.getOrderStatus());
  }

/**
* for testing Customer Id.
 */
  @Test
    public final void testSetCusId() {
    assertEquals(12, ordit.getCusId());
    ordit.setCusId(15);
    assertNotEquals(51, ordit.getCusId());
  }
/**
* for testing order quantity.
 */
  @Test
  public final void testSetOrdQuantity() {
    assertEquals(3, ordit.getOrderQuantity());
    ordit.setOrderQuantity(4);
    assertNotEquals(51, ordit.getOrderQuantity());
  }
/**
* for testing Non parameterized constructor.
 */
  @Test
  public final void testNonParamCons() {
    assertNotNull(new OrderItem());
  }

/**
* checking empty objects in equals method.
 */
  @Test
  public final void testEmptyObjs() {
    assertFalse(ordit.equals(null));
  }

/**
* checking get class method.
 */
  @Test
  public final void testGetEmptyClass() {
    Customer cus = new Customer();
    assertFalse(ordit.equals(cus) && cus.equals(ordit));
  }
/**
* Test method for Not Equals .
 */
  @Test
  public final void testNotEquals() {
    OrderItem x = new OrderItem(12, 81, 15, 3, 54.0, 32);
    OrderItem y = new OrderItem(13, 8, 15, 4, 53.0, 31);
    assertFalse(x.equals(y) && y.equals(x));
  }
/**
* Test method for Equals.
 */
  @Test
  public final void testEquals() {
    OrderItem x = new OrderItem(12, 81, 15, 3, 54.0, 32);
    OrderItem y = new OrderItem(12, 81, 15, 3, 54.0, 32);
    assertTrue(x.equals(y) && y.equals(x));
  }
/**
* Test method for Hash Code True.
 */
  @Test
  public final void testHashCodeTrue() {
    OrderItem x = new OrderItem(12, 81, 15, 3, 54.0, 32);
    OrderItem y = new OrderItem(12, 81, 15, 3, 54.0, 32);
    assertTrue(x.hashCode() == y.hashCode());
  }
/**
* Test method for test Hash Code False.
 */
  @Test
  public final void testHashCodeFalse() {
    OrderItem x = new OrderItem(12, 81, 15, 3, 54.0, 32);
    OrderItem y = new OrderItem(13, 8, 15, 4, 54.0, 32);
    assertFalse(x.hashCode() == y.hashCode());
  }

// /**
// * for testing.
//  */

//   @Test
//     public final void testHashcodeMID() {
//     assertTrue(oi1.hashCode() == oi2.hashCode());
//     ordit.setCusId(556);
//     assertFalse(oi1.hashCode() == oi2.hashCode());
//     }

// /**
// * for testing.
//  */

//   @Test
//     public final void testHashcodeMFT() {
//     assertTrue(oi1.hashCode() == oi2.hashCode());
//     oi2.setMenFoodType("chinese");
//     assertFalse(oi1.hashCode() == oi2.hashCode());
//     }

// /**
// * for testing.
//  */

//   @Test
//     public final void testHashcodeMVN() {
//     assertTrue(oi1.hashCode() == oi2.hashCode());
//     oi2.setMenVegNonVeg("mixed");
//     assertFalse(oi1.hashCode() == oi2.hashCode());
//     }

// /**
// * for testing.
//  */

//   @Test
//     public final void testHashcodeMIN() {
//     assertTrue(oi1.hashCode() == oi2.hashCode());
//     oi2.setMenItemName("dal mkh");
//     assertFalse(oi1.hashCode() == oi2.hashCode());
//     }

// /**
// * for testing.
//  */

//   @Test
//     public final void testHashcodeMC() {
//     assertTrue(oi1.hashCode() == oi2.hashCode());
//     oi2.setMenCalories(211);
//     assertFalse(oi1.hashCode() == oi2.hashCode());
//     }


// /**
// * equals for testing.
//  */
//   @Test
//     public final void testEquals() {
//     assertTrue(oi1.equals(oi2) && oi2.equals(oi1));

//     oi2.setMenItemId(51);
//     assertFalse(oi1.equals(oi2) && oi2.equals(oi1));

//     oi2.setMenFoodType("conti");
//     assertFalse(oi1.equals(oi2) && oi2.equals(oi1));

//     oi2.setMenVegNonVeg("mixed");
//     assertFalse(oi1.equals(oi2) && oi2.equals(oi1));

//     oi2.setMenItemName("DAl m");
//     assertFalse(oi1.equals(oi2) && oi2.equals(oi1));

//     oi2.setMenCalories(341);
//     assertFalse(oi1.equals(oi2) && oi2.equals(oi1));

//     }

}

