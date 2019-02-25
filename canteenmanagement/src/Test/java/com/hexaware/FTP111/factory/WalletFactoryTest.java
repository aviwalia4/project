package com.hexaware.FTP111.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP111.model.Wallet;
import com.hexaware.FTP111.persistence.WalletDAO;
//import com.hexaware.FTP111.util.Validators;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
//import mockit.internal.mockups.MockClassSetup;
/**
* Test for Wallet Factory.
 */
@RunWith(JMockit.class)
public class WalletFactoryTest {
/**
* Test for find By Order Price Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void findByOrderPriceTest(@Mocked final WalletDAO dao) {
    new MockUp<WalletFactory>() {
      @Mock
      public WalletDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.fetchOrderPrice(200); result = 30;
        }
    };
    double authentication = WalletFactory.findByOrderPrice(200);
    assertEquals(authentication, 30, 0);
    new Verifications() { {
        dao.fetchOrderPrice(200); times = 1;
        }
    };
  }
/**
* Test for showWallet test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void showWalletTest(@Mocked final WalletDAO dao) {
    new MockUp<WalletFactory>() {
      @Mock
      public WalletDAO dao() {
        return dao;
        }
    };
    List<Wallet> list = new ArrayList<Wallet>();
    Wallet o1 = new Wallet(1, 500, "Paypal");
    Wallet o2 = new Wallet(2, 4589, "Cash");
    Wallet o3 = new Wallet(3, 2056, "Paytm");
    list.add(o1);
    list.add(o2);
    list.add(o3);
    new Expectations() { {
        List<Wallet> list = new ArrayList<Wallet>();
        Wallet o1 = new Wallet(1, 500, "Paypal");
        Wallet o2 = new Wallet(2, 4589, "Cash");
        Wallet o3 = new Wallet(3, 2056, "Paytm");
        list.add(o1);
        list.add(o2);
        list.add(o3);
        dao.showWallet(20); result = list;
        }
    };
    List<Wallet> wallet = WalletFactory.showWallet(20);
    assertEquals(wallet, list);
    assertEquals(wallet.isEmpty(), false);
    assertEquals(wallet.size(), 3);
    new Verifications() { {
        dao.showWallet(20); times = 1;
        }
    };
  }
/**
* Test for find By Wallet Id Test.
* @param dao to Initialize the dao.
 */
  @Test
  public final void findByWalletId(@Mocked final WalletDAO dao) {
    new MockUp<WalletFactory>() {
      @Mock
      public WalletDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.fetchWalletId(20, 15); result = 50;
        }
    };
    int authentication = WalletFactory.findByWalletId(20, 15);
    assertEquals(authentication, 50);
    new Verifications() { {
        dao.fetchWalletId(20, 15); times = 1;
        }
    };
  }
/**
* Test for cus Update.
* @param dao to Initialize the dao.
 */
  @Test
    public final void cusUpdate(@Mocked final WalletDAO dao) {
    new MockUp<WalletFactory>() {
        @Mock
        public WalletDAO dao() {
          return dao;
        }
    };
    new Expectations() { {
        dao.cusUpdate(250.50, 10, 15);
        }
    };
    WalletFactory.cusUpdate(250.50, 10, 15);
    new Verifications() { {
        dao.cusUpdate(250.50, 10, 15); times = 1;
        }
    };
  }
/**
* Test method for Wallet Factory Constructor.
 */
  @Test
  public final void testWalletConstructor() {
    assertNotNull(new WalletFactory());
  }
}
