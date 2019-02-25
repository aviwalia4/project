package com.hexaware.FTP111.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
* for object.
 */
public class MenuDetailsTest {
  private MenuDetails mend;
  /**
   * for setup.
   */
  @Before
    public final void setUp() {
    mend = new MenuDetails(12, 1, 12.0, 4, 23);
  }

/**
* for testing.
 */
  @Test
    public final void testMenD() {
    assertEquals(12, mend.getMenItemId());
    assertEquals(1, mend.getVenId());
    assertEquals(12.0, mend.getMenVenPrice(), 0);
    assertEquals(4, mend.getMenVenRating());
    assertEquals(23, mend.getMenCalories());
  }
/**
* for testing.
 */
  @Test
    public final void testSetMenItemId() {
    assertEquals(12, mend.getMenItemId());
    mend.setMenItemId(201);
    assertNotEquals(214, mend.getMenItemId());
  }

/**
* for testing.
 */
  @Test
    public final void testSetVenId() {
    assertEquals(1, mend.getVenId());
    mend.setVenId(54);
    assertNotEquals(12, mend.getVenId());
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenVenPrice() {
    assertEquals(12.0, mend.getMenVenPrice(), 0);
    mend.setMenVenPrice(113.0);
    assertNotEquals(151.0, mend.getMenVenPrice(), 0);
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenVenRating() {
    assertEquals(4, mend.getMenVenRating());
    mend.setMenVenRating(1);
    assertNotEquals(3, mend.getMenVenRating());
  }

/**
* for testing.
 */
  @Test
    public final void testSetMenCalories() {
    assertEquals(23, mend.getMenCalories());
    mend.setMenCalories(154);
    assertNotEquals(20, mend.getMenCalories());
  }


  // MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
  // MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);


/**
* for testing non parametarised constructor.
 */
  @Test
    public final void testNonParamMenD() {
    mend = new MenuDetails();
    int menItemId = 0;
    assertEquals(menItemId, mend.getMenItemId(), 0);
    int venId = 0;
    assertEquals(venId, mend.getVenId(), 0);
    double menVenPrice = 0.0;
    assertEquals(menVenPrice, mend.getMenVenPrice(), 0.0);
    int menVenRating = 0;
    assertEquals(menVenRating, mend.getMenVenRating(), 0);
    int menCalories = 0;
    assertEquals(menCalories, mend.getMenCalories(), 0);
  }


/**
* checking empty objects in equals method.
 */
  @Test
  public final void testEmptyObjs() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertFalse(md2.equals(null));
  }


/**
* checking get class in equals method.
 */
  @Test
  public final void testGetClass() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    Customer cus = new Customer();
    assertFalse(md2.equals(cus) && cus.equals(md2));
  }


/**
* for testing.
 */

  @Test
    public final void testHashcodeMDID() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertTrue(md1.hashCode() == md2.hashCode());
    md2.setMenItemId(556);
    assertFalse(md1.hashCode() == md2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMDVI() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertTrue(md1.hashCode() == md2.hashCode());
    md2.setVenId(121);
    assertFalse(md1.hashCode() == md2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMDVP() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertTrue(md1.hashCode() == md2.hashCode());
    md2.setMenVenPrice(215);
    assertFalse(md1.hashCode() == md2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMDVR() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertTrue(md1.hashCode() == md2.hashCode());
    md2.setMenVenRating(45);
    assertFalse(md1.hashCode() == md2.hashCode());
  }

/**
* for testing.
 */

  @Test
    public final void testHashcodeMDC() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertTrue(md1.hashCode() == md2.hashCode());
    md2.setMenCalories(211);
    assertFalse(md1.hashCode() == md2.hashCode());
  }

/**
* equals for testing.
 */
  @Test
    public final void testEquals() {
    MenuDetails md1 = new MenuDetails(12, 1, 12.0, 4, 23);
    MenuDetails md2 = new MenuDetails(12, 1, 12.0, 4, 23);
    assertTrue(md1.equals(md2) && md2.equals(md1));

    md2.setMenItemId(51);
    assertFalse(md1.equals(md2) && md2.equals(md1));

    md2.setVenId(154);
    assertFalse(md1.equals(md2) && md2.equals(md1));

    md2.setMenVenPrice(125.0);
    assertFalse(md1.equals(md2) && md2.equals(md1));

    md2.setMenVenRating(489);
    assertFalse(md1.equals(md2) && md2.equals(md1));

    md2.setMenCalories(341);
    assertFalse(md1.equals(md2) && md2.equals(md1));

  }
}

