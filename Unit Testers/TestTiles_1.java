import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestTiles_1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestTiles_1
{
    /**
     * Default constructor for test class TestTiles_1
     */
    public TestTiles_1()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    @Test
    public void testAddAndContains()
    {
        Tiles t1 = new Tiles();
        t1.add("B1");
        t1.add("I16");
        t1.add("N35");
        t1.add("G49");
        t1.add("O70");
        assertEquals(true, t1.contains("B1"));
        assertEquals(true, t1.contains("G49"));
        assertEquals(true, t1.contains("O70"));
        assertEquals(false, t1.contains("B9"));
        assertEquals(false, t1.contains("I18"));
    }
    @Test
    public void testGetTile()
    {
        Tiles t1 = new Tiles();
        ArrayList<String> randomTiles = new ArrayList<String>();
        // generates 2000 random tiles with the getTile() method
        for(int i = 0; i < 2000; i++)
        {
            String temp = t1.getTile();
            randomTiles.add(temp);
        }
        // checks to make sure the following 8 valid BINGO values are represented in the 2000 random attempts
        assertEquals(true, randomTiles.contains("B1"));
        assertEquals(true, randomTiles.contains("B15"));
        assertEquals(true, randomTiles.contains("I16"));
        assertEquals(true, randomTiles.contains("I30"));
        assertEquals(true, randomTiles.contains("G46"));
        assertEquals(true, randomTiles.contains("G60"));
        assertEquals(true, randomTiles.contains("O61"));
        assertEquals(true, randomTiles.contains("O75"));
        
        // checks to see that if B is the first letter of the random tile, that the only numbers associated with it are nubmers between 1 and 15.
        boolean isValidNum = true;
        for(int i = 0; i < 2000; i++)
        {
            if(randomTiles.get(i).substring(0, 1).equals("B"))
            {
                int num = Integer.parseInt(randomTiles.get(i).substring(1));
                if(num < 0 || num > 15)
                {
                    isValidNum = false;
                }
            }
        }
        assertEquals(true, isValidNum);
    }
    @Test
    public void testIsValidTile()
    {
        Tiles t1 = new Tiles();
        
        assertTrue(t1.isValidTile("B1")); // valid
        assertTrue(t1.isValidTile("b1"));  // valid
        assertFalse(t1.isValidTile("B50"));  // not valid
        assertTrue(t1.isValidTile("I16"));  // valid
        assertTrue(t1.isValidTile("N35"));  // valid
        assertFalse(t1.isValidTile("G4"));   // not valid
        assertTrue(t1.isValidTile("O75"));  // valid
        assertFalse(t1.isValidTile("O76"));  // not valid
        assertFalse(t1.isValidTile("A7"));  // not valid
        
        
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
