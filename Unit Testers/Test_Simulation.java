import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestPlayer_1.
 *
 * @author  (Sam Pomerantz)
 *
 */
public class Test_Simulation
{
    public Test_Simulation()
    {
    }

    @Before
    public void setUp()
    {
    }
    
    @Test
    public void test1card()
    {
        BingoGame bg = new BingoGame();
        assertEquals(41, bg.averageCallsForWin(15000,1)); 
        assertEquals(41, bg.averageCallsForWin(20000,1)); 
    }
    
    @Test
    public void test2cards()
    {
        BingoGame bg = new BingoGame();
        assertEquals(35, bg.averageCallsForWin(15000,2)); 
        assertEquals(35, bg.averageCallsForWin(20000,2)); 
    }
    
    @Test
    public void test3cards()
    {
        BingoGame bg = new BingoGame();
        assertEquals(32, bg.averageCallsForWin(15000,3));
        assertEquals(32, bg.averageCallsForWin(20000,3)); 
    }
    
    @Test
    public void onetoone()
    {
        BingoGame bg = new BingoGame();
        int i = bg.averageCallsForWin(1,1);
        assertTrue(4 <= i && i <= 75);
    }
    
    @Test
    public void error()
    {
        BingoGame bg = new BingoGame();
        boolean pass = false;
        try
        {
            int mynum = bg.averageCallsForWin(0,1);
        }
        catch(Exception e)
        {
            pass = true;
        }        
        assertTrue(pass);
    }

    @After
    public void tearDown()
    {
    }
}
