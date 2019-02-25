package com.hexaware.FTP111.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
// import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
* for object.
 */
public class MenuTest {
  private Menu menu;
  /**
   * for setup.
   */
  @Before
    public final void setUp() {
    menu = new Menu(12, "continental", "non veg", "dal makhni", 25);
  }

  // MenuDAO dao = new MenuDAO();
  // assertNotNull(dao);
/**
* for testing.
 */
  @Test
    public final void testMenu() {
    assertEquals(12, menu.getMenItemId());
    assertEquals("continental", menu.getMenFoodType());
    assertEquals("non veg", menu.getMenVegNonVeg());
    assertEquals("dal makhni", menu.getMenItemName());
    assertEquals(25, menu.getMenCalories());
  }
/**
* for testing.
 */
  @Test
    public final void testSetMenItemId() {
    assertEquals(12, menu.getMenItemId());
    menu.setMenItemId(201);
    assertNotEquals(214, menu.getMenItemId());
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenFoodType() {
    assertEquals("continental", menu.getMenFoodType());
    menu.setMenFoodType("CONTI");
    assertNotEquals("CNtin", menu.getMenFoodType());
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenVegNonVeg() {
    assertEquals("non veg", menu.getMenVegNonVeg());
    menu.setMenVegNonVeg("NV");
    assertNotEquals("non v", menu.getMenVegNonVeg());
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenItemName() {
    assertEquals("dal makhni", menu.getMenItemName());
    menu.setMenItemName("DM");
    assertNotEquals("d MAkhni", menu.getMenItemName());
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenCalories() {
    assertEquals(25, menu.getMenCalories());
    menu.setMenCalories(154);
    assertNotEquals(20, menu.getMenCalories());
  }




/**
* for testing non parametarised constructor.
 */
  @Test
    public final void testNonParamMenu() {
    menu = new Menu();
    int menItemId = 0;
    assertEquals(menItemId, menu.getMenItemId());
    String menFoodType = null;
    assertEquals(menFoodType, menu.getMenFoodType());
    String menVegNonVeg = null;
    assertEquals(menVegNonVeg, menu.getMenVegNonVeg());
    String menItemName = null;
    assertEquals(menItemName, menu.getMenItemName());
    int menCalories = 0;
    assertEquals(menCalories, menu.getMenCalories());
  }


/**
* checking empty objects in equals method.
 */
  @Test
  public final void testEmptyObjs() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertFalse(m2.equals(null));
  }


/**
* checking get class in equals method.
 */
  @Test
  public final void testGetEmptyObjs() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Customer cus = new Customer();
    assertFalse(m2.equals(cus) && cus.equals(m2));
  }


/**
* for testing.
 */

  @Test
    public final void testHashcodeMID() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertTrue(m1.hashCode() == m2.hashCode());
    m2.setMenItemId(556);
    assertFalse(m1.hashCode() == m2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMFT() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertTrue(m1.hashCode() == m2.hashCode());
    m2.setMenFoodType("chinese");
    assertFalse(m1.hashCode() == m2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMVN() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertTrue(m1.hashCode() == m2.hashCode());
    m2.setMenVegNonVeg("mixed");
    assertFalse(m1.hashCode() == m2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMIN() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertTrue(m1.hashCode() == m2.hashCode());
    m2.setMenItemName("dal mkh");
    assertFalse(m1.hashCode() == m2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMC() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertTrue(m1.hashCode() == m2.hashCode());
    m2.setMenCalories(211);
    assertFalse(m1.hashCode() == m2.hashCode());
  }


/**
* equals for testing.
 */
  @Test
    public final void testEquals() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    assertTrue(m1.equals(m2) && m2.equals(m1));

    m2.setMenItemId(51);
    assertFalse(m1.equals(m2) && m2.equals(m1));

    m2.setMenFoodType("conti");
    assertFalse(m1.equals(m2) && m2.equals(m1));

    m2.setMenVegNonVeg("mixed");
    assertFalse(m1.equals(m2) && m2.equals(m1));

    m2.setMenItemName("DAl m");
    assertFalse(m1.equals(m2) && m2.equals(m1));

    m2.setMenCalories(341);
    assertFalse(m1.equals(m2) && m2.equals(m1));

  }

/**
* Test method for test not equals.
 */
  @Test
  public final void testNotEquals() {
    Menu m1 = new Menu(12, "continental", "non veg", "dal makhni", 25);
    Menu m2 = new Menu(16, "continl", "n veg", "dal makh", 5);
    assertFalse(m1.equals(m2) && m2.equals(m1));
  }

}

