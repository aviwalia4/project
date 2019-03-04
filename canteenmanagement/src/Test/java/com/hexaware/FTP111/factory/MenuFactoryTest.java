package com.hexaware.FTP111.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP111.model.MenuDetails;
import com.hexaware.FTP111.model.Menu;
import com.hexaware.FTP111.persistence.MenuDAO;
//import com.hexaware.FTP111.util.Validators;
import org.junit.Test;
//import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
// import mockit.integration.junit4.JMockit;
// import mockit.internal.mockups.MockClassSetup;
/**
* to test Menu Factory class.
 */

public class MenuFactoryTest {

/**
* to test Menu Details method.
* @param dao to initialize DAO.
 */

  @Test
  public final void testGetMenuDetails(@Mocked final MenuDAO dao) {

    new MockUp<MenuFactory>() {
        @Mock
        public MenuDAO dao() {
            return dao;
        }
    };

    List<MenuDetails> menuDetailsList = new ArrayList();
    menuDetailsList.add(new MenuDetails(15, "DOSA", 21, "HARI STALLS", 54.0, 4, 45));
    menuDetailsList.add(new MenuDetails(25, "DOSA", 29, "HARI STALLS", 49.0, 2, 87));

    new Expectations() { {
        List<MenuDetails> menuDetailsList2 = new ArrayList();
        menuDetailsList2.add(new MenuDetails(15, "DOSA", 21, "HARI STALLS", 54.0, 4, 45));
        menuDetailsList2.add(new MenuDetails(25, "DOSA", 29, "HARI STALLS", 49.0, 2, 87));
        dao.createOrder(1); result = menuDetailsList2;
        }
    };

    List<MenuDetails> list = MenuFactory.getMenuDetails(1);
    assertEquals(2, list.size());
    new Verifications() { {

        dao.createOrder(1); times = 1;
        } };
  }

/**
* Test for find By Menu Item Id.
* @param dao to Initialize the dao.
 */
  @Test
  public final void findByMenItemId(@Mocked final MenuDAO dao) {
    new MockUp<MenuFactory>() {
      @Mock
      public MenuDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.fetchMenItemId(20); result = 50;
        }
    };
    int authentication = MenuFactory.findByMenItemId(20);
    assertEquals(authentication, 50);
    new Verifications() { {
        dao.fetchMenItemId(20); times = 1;
        }
    };
  }

  /**
* Test for find By Menu Item Id.
* @param dao to Initialize the dao.
 */
  @Test
  public final void getOrderPrice(@Mocked final MenuDAO dao) {
    new MockUp<MenuFactory>() {
      @Mock
      public MenuDAO dao() {
        return dao;
      }
    };
    new Expectations() { {
        dao.fetchOrderPrice(2120, 14); result = 50;
        }
    };
    double authentication = MenuFactory.getOrderPrice(2120, 14);
    assertEquals(authentication, 50, 0);
    new Verifications() { {
        dao.fetchOrderPrice(2120, 14); times = 1;
        }
    };
  }
/**
* Test method for Menu Factory Constructor.
 */
  @Test
  public final void testMenuFactoryConstructor2() {
    assertNotNull(new MenuFactory());
  }
/**
* test class for GetMenuDetails.
* @param dao int to initalize menu.
 */
  @Test
    public final void testMenuDetails(@Mocked final MenuDAO dao) {

    new MockUp<MenuFactory>() {
        @Mock
            public MenuDAO dao() {
            return dao;
        }
        };

    List<Menu> menuDetailsList = new ArrayList();
    menuDetailsList.add(new Menu(1, "continental", "non veg", "dal makhni", 25));
    menuDetailsList.add(new Menu(2, "continental", "non veg", "dal makhni", 25));

    new Expectations() { {
        List<Menu> menuDetailsList2 = new ArrayList();
        menuDetailsList2.add(new Menu(1, "continental", "non veg", "dal makhni", 25));
        menuDetailsList2.add(new Menu(2, "continental", "non veg", "dal makhni", 25));
        dao.show(); result = menuDetailsList2;
      } };

    List<Menu> list = MenuFactory.showMenu();

    assertEquals(2, list.size());
    new Verifications() { {
        dao.show(); times = 1;
      } };
  }
}


