package in.shabhushan.algo_trials.algorithms.chapter1.webassignment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PercolationTest {

  private static final int GRID_SIZE = 5;
  private Percolation percolation;

  @Before
  public void setUp() {
    percolation = new Percolation(GRID_SIZE);
  }

  @Test
  public void testOneSiteOpen() {
    // given
    assertFalse(percolation.isOpen(1, 1));

    // when
    percolation.open(1, 1);

    // then
    assertTrue(percolation.isOpen(1, 1));
  }

  @Test
  public void testPercolation() {
    // when
    percolation.open(1, 2);
    percolation.open(2, 2);
    percolation.open(3, 2);
    percolation.open(4, 2);
    percolation.open(5, 2);

    // then
    assertTrue(percolation.percolates());
  }

  @Test
  public void testNoPercolate() {
    // when
    percolation.open(1, 1);
    percolation.open(1, 2);
    percolation.open(1, 4);
    percolation.open(1, 5);

    // then
    assertFalse(percolation.percolates());
  }

  @Test
  public void testIsSiteBlueDot() {
    // when
    percolation.open(1, 1);
    percolation.open(1, 2);

    // then
    assertTrue(percolation.isFull(1, 2));
  }

  @Test
  public void testIsSiteNotBlueDot() {
    // when
    percolation.open(3, 2);

    // then
    assertFalse(percolation.isFull(3, 2));

    percolation.open(3, 3);

    assertFalse(percolation.isFull(3, 3));
  }

  @Test
  public void shouldNotBeFilled() {
    // when
    percolation.open(1, 3);
    percolation.open(2, 3);
    percolation.open(3, 3);
    percolation.open(4, 3);
    percolation.open(5, 3);
    percolation.open(5, 5);

    // then
    assertTrue(percolation.isFull(1, 3));
    assertTrue(percolation.isFull(2, 3));
    assertTrue(percolation.isFull(3, 3));
    assertTrue(percolation.isFull(4, 3));
    assertTrue(percolation.isFull(5, 3));
    assertFalse(percolation.isFull(5, 5));
    assertEquals(6, percolation.numberOfOpenSites());
  }

  @Test
  public void testPercolationInSizeOneGrid() {
    Percolation percolation = new Percolation(1);
    assertFalse(percolation.percolates());
    percolation.open(1, 1);
    assertTrue(percolation.percolates());
    assertEquals(1, percolation.numberOfOpenSites());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGridSizeIsZero() {
    new Percolation(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGridSizeIsNegative() {
    new Percolation(-5);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testOpenIsCalledWithZero() {
    percolation.open(0, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testOpenIsCalledWithFieldOutsideTheGrid() {
    percolation.open(GRID_SIZE + 1, GRID_SIZE + 1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIsOpenIsCalledWithZero() {
    percolation.isOpen(0, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIsOpenIsCalledWithFieldOutsideTheGrid() {
    percolation.isOpen(GRID_SIZE + 1, GRID_SIZE + 1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIsFullIsCalledWithZero() {
    percolation.isFull(0, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIsCalledWithFieldOutsideTheGrid() {
    percolation.isFull(GRID_SIZE + 1, GRID_SIZE + 1);
  }

}
