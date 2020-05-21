import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestPlayer_1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestPlayer_1
{
    /**
     * Default constructor for test class TestPlayer_1
     */
    public TestPlayer_1()
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
