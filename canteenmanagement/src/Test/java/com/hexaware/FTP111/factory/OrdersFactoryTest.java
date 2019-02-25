package com.hexaware.FTP111.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP111.model.Orders;
import com.hexaware.FTP111.model.OrderItem;
import com.hexaware.FTP111.persistence.OrdersDAO;
import com.hexaware.FTP111.model.OrderStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
/**
* Test for Orders Factory.
 */
@RunWith(JMockit.class)
public class OrdersFactoryTest {
/**
* Test for Get show Orders.
* @param dao to Initialize the dao.
 */
  @Test
    public final void testGetshowOrders(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
            public OrdersDAO dao() {
        return dao;
      }
    };
    List<Orders> list = new ArrayList<Orders>();
    Orders order1 = new Orders(10, 20, 12, 10.00, OrderStatus.PENDING);
    Orders order2 = new Orders(20, 30, 22, 25.12, OrderStatus.APPROVED);
    Orders order3 = new Orders(80, 40, 38, 37.78, OrderStatus.PENDING);
    list.add(order1);
    list.add(order2);
    list.add(order3);

    new Expectations() { {
        List<Orders> list = new ArrayList<Orders>();
        Orders order1 = new Orders(10, 20, 12, 10.00, OrderStatus.PENDING);
        Orders order2 = new Orders(20, 30, 22, 25.12, OrderStatus.APPROVED);
        Orders order3 = new Orders(80, 40, 38, 37.78, OrderStatus.PENDING);
        list.add(order1);
        list.add(order2);
        list.add(order3);
        dao.showOrders(200); result = list;
        }
    };
    List<Orders> orders = OrdersFactory.showOrders(200);
    assertEquals(orders, list);
    assertEquals(orders.isEmpty(), false);
    assertEquals(orders.size(), 3);
    new Verifications() { {
        dao.showOrders(200); times = 1;
        }
    };
  }
/**
* Test for testOrderdetails.
* @param dao to Initialize the dao.
 */
  @Test
  public final void orderDetailsTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
      }
    };
    List<Orders> list = new ArrayList<Orders>();
    Orders order1 = new Orders(10, 20, 12, 90.12, OrderStatus.PENDING);
    Orders order2 = new Orders(20, 30, 22, 30.25, OrderStatus.APPROVED);
    Orders order3 = new Orders(80, 40, 38, 90.99, OrderStatus.PENDING);

    list.add(order1);
    list.add(order2);
    list.add(order3);

    new Expectations() { {
        List<Orders> list = new ArrayList<Orders>();
        Orders order1 = new Orders(10, 20, 12, 90.12, OrderStatus.PENDING);
        Orders order2 = new Orders(20, 30, 22, 30.25, OrderStatus.APPROVED);
        Orders order3 = new Orders(80, 40, 38, 90.99, OrderStatus.PENDING);
        list.add(order1);
        list.add(order2);
        list.add(order3);
        dao.orderDetails(200); result = list;
        }
    };
    List<Orders> orders = OrdersFactory.orderDetails(200);
    assertEquals(orders, list);
    assertEquals(orders.isEmpty(), false);
    assertEquals(orders.size(), 3);
    new Verifications() { {
        dao.orderDetails(200); times = 1;
        }
    };
  }
/**
* Test for get Order Details.
* @param dao to Initialize the dao.
 */
  @Test
  public final void getOrderDetailsTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
        }
    };
    List<Orders> list = new ArrayList<Orders>();
    Orders order1 = new Orders(10, 20, 12, 10.00, OrderStatus.PENDING);
    Orders order2 = new Orders(20, 30, 22, 25.12, OrderStatus.APPROVED);
    Orders order3 = new Orders(80, 40, 38, 37.78, OrderStatus.PENDING);


    list.add(order1);
    list.add(order2);
    list.add(order3);

    new Expectations() { {
        List<Orders> list = new ArrayList<Orders>();
        Orders order1 = new Orders(10, 20, 12, 10.00, OrderStatus.PENDING);
        Orders order2 = new Orders(20, 30, 22, 25.12, OrderStatus.APPROVED);
        Orders order3 = new Orders(80, 40, 38, 37.78, OrderStatus.PENDING);

        list.add(order1);
        list.add(order2);
        list.add(order3);

        dao.getOrderDetails(200); result = list;
        }
    };
    List<Orders> orders = OrdersFactory.getOrderDetails(200);
    assertEquals(orders, list);
    assertEquals(orders.isEmpty(), false);
    assertEquals(orders.size(), 3);
    new Verifications() { {
        dao.getOrderDetails(200); times = 1;
        }
    };
  }
/**
* Test for set PlaceOrder.
* @param dao to Initialize the dao.
 */
  @Test
  public final void setPlaceOrderTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
        }
      };
    new Expectations() { {
        dao.setPlaceOrder(new Orders(10, 20, 10.00, 90)); result = 10;
        }
    };
    int result = OrdersFactory.setPlaceOrder(new Orders(10, 20, 10.00, 90));
    assertEquals(result, 10);
    new Verifications() { {
        dao.setPlaceOrder(new Orders(10, 20, 10.00, 90)); times = 1;
        }
    };
  }
/**
* Test for update Order Items.
* @param dao to Initialize the dao.
 */
  @Test
  public final void updateOrderItemsTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
        }
      };
    new Expectations() { {
        dao.updateOrderItems(new OrderItem(10, 20, 12, 11, 10.00, 90));

        }
    };
    OrdersFactory.updateOrderItems(new OrderItem(10, 20, 12, 11, 10.00, 90));
    new Verifications() { {
        dao.updateOrderItems(new OrderItem(10, 20, 12, 11, 10.00, 90)); times = 1;
        }
    };
  }
/**
* Test for update Pending Orders.
* @param dao to Initialize the dao.
 */
  @Test
  public final void updatePendingOrdersTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
        }
    };
    new Expectations() { {
        dao.updatePendingOrders(11, OrderStatus.APPROVED, 20);
        }
    };
    OrdersFactory.updatePendingOrders(11, OrderStatus.APPROVED, 20);
    new Verifications() { {
            dao.updatePendingOrders(11, OrderStatus.APPROVED, 20); times = 1;
        }
    };
  }
/**
* Test method for Orders Factory Constructor.
 */
  @Test
  public final void testOrdersFactoryConstructor2() {
    assertNotNull(new OrdersFactory());
  }
/**
* Test for find By Orders Id Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void getRefundAmount(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.refundAmount(20, 1); result = 50;
        }
    };
    double authentication = OrdersFactory.getRefundAmount(20, 1);
    assertEquals(authentication, 50, 0);
    new Verifications() { {
        dao.refundAmount(20, 1); times = 1;
        }
    };
  }

/**
* Test for find By Customer Id Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void getCusId(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.getCusId(2, 1); result = 50;
        }
    };
    int authentication = OrdersFactory.getCusId(2, 1);
    assertEquals(authentication, 50);
    new Verifications() { {
        dao.getCusId(2, 1); times = 1;
        }
    };
  }
/**
* Test for find By Orders Id Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void getWalTransId(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.getWalTransId(1); result = 1;
        }
    };
    int authentication = OrdersFactory.getWalTransId(1);
    assertEquals(authentication, 1);
    new Verifications() { {
        dao.getWalTransId(1); times = 1;
        }
    };
  }

/**
* Test for update Total Orders price.
* @param dao to Initialize the dao.
 */
  @Test
  public final void changeTotal(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
      public OrdersDAO dao() {
        return dao;
        }
    };
    new Expectations() { {
        dao.updateTotal(120d, 2);
        }
    };
    OrdersFactory.changeTotal(120d, 2);
    new Verifications() { {
            dao.updateTotal(120d, 2); times = 1;
        }
    };
  }
}
