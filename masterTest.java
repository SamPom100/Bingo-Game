import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class TestCard_1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class masterTest
{
    /**
     * Default constructor for test class TestCard_1
     */
    public masterTest()
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

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Test1()
    {
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card card1 = new Card(temp);
        assertEquals("B\tI\tN\tG\tO\n9\t30\t38\t51\t70\n1\t22\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62", card1.toString());
        card1.print();
    }
    @Test
    public void Test2()
    {
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card card1 = new Card(temp);
        assertEquals("B\tI\tN\tG\tO\n9\t30\t38\t51\t70\n1\t22\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62", card1.toString());
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("B9"));
        assertEquals(true, card1.call("I22"));
        assertEquals(false, card1.call("B2"));
        assertEquals(false, card1.call("N22"));
        java.lang.String string1 = card1.toString();
        assertEquals("B\tI\tN\tG\tO\nx\t30\t38\t51\t70\n1\tx\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62", string1);
        assertEquals(true, card1.call("N33"));
        assertEquals(true, card1.call("G46"));
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("O67"));
        assertEquals(false, card1.win());
        card1.print();
    }
    @Test
    public void verticalWin()
    {
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card card1 = new Card(temp);
        assertEquals("B\tI\tN\tG\tO\n9\t30\t38\t51\t70\n1\t22\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62", card1.toString());
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("I30"));
        assertEquals(true, card1.call("I22"));
        assertEquals(true, card1.call("I27"));
        assertEquals(true, card1.call("I18"));
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("I25"));
        assertEquals(true, card1.win());
    }
    
    @Test
    public void horizontalWinWithFreeSpace()
    {
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card card1 = new Card(temp);
        assertEquals("B\tI\tN\tG\tO\n9\t30\t38\t51\t70\n1\t22\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62", card1.toString());
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("B6"));
        assertEquals(true, card1.call("I27"));
        assertEquals(true, card1.call("G55"));
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("O71"));
        assertEquals(true, card1.win());
    }
    
    @Test
    public void diagonalWinTopRightToBottomLeft()
    {
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card card1 = new Card(temp);
        assertEquals("B\tI\tN\tG\tO\n9\t30\t38\t51\t70\n1\t22\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62", card1.toString());
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("O70"));
        assertEquals(true, card1.call("G46"));
        assertEquals(true, card1.call("I18"));
        assertEquals(false, card1.win());
        assertEquals(true, card1.call("B5"));
        assertEquals(true, card1.win());
        card1.print();
    }
       @Test
    public void testConstructorAndToStringNoCards()
    {
        Player p1 = new Player("Mrs. Bar");
        assertEquals("Mrs. Bar", p1.toString());        
    }
    @Test
    public void testAddCardAndToStringWithCards()
    {
        Player p1 = new Player("Mrs. Bar");
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card c1 = new Card(temp);
        int[][] temp2 = {{1,16,31,46,61}, {2,17,32,47,62}, {3,18,48,63}, {4,19,34,49,64}, {5,20,45,50,65}};
        Card c2 = new Card(temp2);        
        p1.addCard(c1);
        String expectedResult = "Mrs. Bar\nB\tI\tN\tG\tO\n9\t30\t38\t51\t70\n1\t22\t33\t46\t67\n6\t27\tfree\t55\t71\n13\t18\t34\t52\t69\n5\t25\t45\t50\t62";
        assertEquals(expectedResult, p1.toString());                
        p1.addCard(c2);
        expectedResult += "\nB\tI\tN\tG\tO\n1\t16\t31\t46\t61\n2\t17\t32\t47\t62\n3\t18\tfree\t48\t63\n4\t19\t34\t49\t64\n5\t20\t45\t50\t65";
        assertEquals(expectedResult, p1.toString());
    }
    @Test
    public void testCall()
    {
        Player p1 = new Player("Mrs. Bar");
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card c1 = new Card(temp);
        int[][] temp2 = {{1,16,31,46,61}, {2,17,32,47,62}, {3,18,48,63}, {4,19,34,49,64}, {5,20,45,50,65}};
        Card c2 = new Card(temp2);
        p1.addCard(c1);
        p1.addCard(c2);        
        // calls 3 numbers and checks the number of hits  
        assertEquals(2, p1.call("b1"));
        assertEquals(1, p1.call("B13"));
        assertEquals(0, p1.call("I21"));        
        // checks to make sure the calls above put x's in the appropriate spots.
        String expectedResult = "Mrs. Bar\nB\tI\tN\tG\tO\n9\t30\t38\t51\t70\nx\t22\t33\t46\t67\n6\t27\tfree\t55\t71\nx\t18\t34\t52\t69\n5\t25\t45\t50\t62";
        expectedResult += "\nB\tI\tN\tG\tO\nx\t16\t31\t46\t61\n2\t17\t32\t47\t62\n3\t18\tfree\t48\t63\n4\t19\t34\t49\t64\n5\t20\t45\t50\t65";
        assertEquals(expectedResult, p1.toString());
    }
    @Test
    public void testWin()
    {
        Player p1 = new Player("Mrs. Bar");
        int[][] temp = {{9,30,38,51,70}, {1,22,33,46,67}, {6,27,55,71}, {13,18,34,52,69}, {5,25,45,50,62}};
        Card c1 = new Card(temp);
        int[][] temp2 = {{1,16,31,46,61}, {2,17,32,47,62}, {3,18,48,63}, {4,19,34,49,64}, {5,20,45,50,65}};
        Card c2 = new Card(temp2);
        p1.addCard(c1);
        p1.addCard(c2);       
        // wins on card2 diagonally from top left to bottom right with a free space.
        assertEquals(false, p1.win());
        p1.call("b1");
        p1.call("I17");
        p1.call("G49");
        assertEquals(false, p1.win());
        p1.call("O65");
        assertEquals(true, p1.win());        
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
        assertEquals(36, bg.averageCallsForWin(15000,2)); 
        assertEquals(36, bg.averageCallsForWin(20000,2)); 
    }
    
    @Test
    public void test3cards()
    {
        BingoGame bg = new BingoGame();
        assertEquals(33, bg.averageCallsForWin(15000,3));
        assertEquals(33, bg.averageCallsForWin(20000,3)); 
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
        boolean pass = true;
        try
        {
            int mynum = bg.averageCallsForWin(0,1);
        }
        catch(Exception e)
        {
            pass = false;
        }        
        assertTrue(pass);
    }
}

