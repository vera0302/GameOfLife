import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest
{
	// Test 1: Pinning test to ensure that the modified method "toString" returns the expected value with an alive.
	@Test
	public void CellTest1()
	{
		Cell c = new Cell();
		c.setAlive(true);
		assertTrue(c.toString().equals("X"));
	}

	// Test 2: Pinning test to ensure that the modified method "toString" returns the expected value with a dead.
	@Test
	public void CellTest2()
	{
		Cell c = new Cell();
		c.setAlive(false);
		assertTrue(c.toString().equals("."));
	}

	// Test 3: Pinning test to ensure that the modified method "toString" returns the expected value with a cell that is dead now,
	// but were once alive during the previous run.
	@Test
	public void CellTest3()
	{
		Cell c = new Cell();
		c.setAlive(true);
		c.setAlive(false);
		assertTrue(c.toString().equals("."));
	}

}
