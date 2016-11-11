import static org.junit.Assert.*;

import org.junit.Test;

public class MainPanelTest
{
	
	// ConvertInt test
	// Test 1: Pinning test to ensure that the modified method "convertToInt" do not change the functionality.
	// The method I defined in the MainPanel.java is used to get the returned value of the modified method.
	// Based on this way, there follows some tests below:

	@Test
	public void ConvertTest1()
	{
		MainPanel M = new MainPanel(15);
		assertEquals(M.intConvert(8), 8);
	}

	// Test 2: Pinning test to ensure that the modified method "convertToInt" works with the value 0(edge case)
	@Test
	public void ConvertTest2()
	{
		MainPanel M = new MainPanel(15);
		assertEquals(M.intConvert(0), 0);
	}

	// Test 3: Pinning test to ensure that the modified method "convertToInt" works with the MAXINT(edge case)
	@Test
	public void ConvertTest3()
	{
		MainPanel M = new MainPanel(15);
		assertEquals(M.intConvert(Integer.MAX_VALUE), Integer.MAX_VALUE);
	}

	// BackupCell test
	// Test 1: Pinning test to ensure that the modified method "backup" keeps the functionality as before
	// after refactored the way of creating new cells.

	@Test
	public void Backuptest1()
	{
		MainPanel M = new MainPanel(15);
		Cell[][] c = new Cell[15][15];
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				// edge case
				if((i+j) % 2 == 0)
				{
					c[i][j] = new Cell(true);
				}
				else
				{
					c[i][j] = new Cell(false);
				}
			}
		}
		M.setCells(c);
		M.backup();
		assertTrue(M.backupTest());
	}

	// Test 2: Pinning test to ensure that the modified method "backup" keeps the functionality after refactored.

	@Test
	public void Backuptest2()
	{
		MainPanel M = new MainPanel(15);
		Cell[][] c = new Cell[15][15];
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
                c[i][j] = new Cell(true);
			}
		}
		M.setCells(c);
		M.backup();
		assertTrue(M.backupTest());
	}

	// Test 3: Pinning test to ensure that the modified method "backup" keeps the functionality after refactored.

	@Test
	public void Backuptest3()
	{
		MainPanel M = new MainPanel(15);
		Cell[][] c = new Cell[15][15];
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
			    c[i][j] = new Cell(false);
			}
		}
		// Set alive cells
		c[0][0].setAlive(true);
		c[14][14].setAlive(true);
		M.setCells(c);
		M.backup();
		assertTrue(M.backupTest());
	}

}
