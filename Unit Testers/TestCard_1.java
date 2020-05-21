import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCard_1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCard_1
{
    /**
     * Default constructor for test class TestCard_1
     */
    public TestCard_1()
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
}

