import java.util.ArrayList;
public class Player
{
    private String name;
    ArrayList<Card> cards = new ArrayList<Card>();    
    public Player(String in)
    {
        name = in;
    }
    public void addCard(Card newCard)
    {
        cards.add(newCard);
    }
    public boolean win()
    {
        for(Card name: cards){if(name.win()){return true;}}
        return false;
    }
    public void print()
    {
        for(Card name: cards){name.print();System.out.println();}
    }
    public int call(String title)
    {
        int count = 0;for(Card name: cards){if(name.call(title)){count++;}}
        return count;
    }
    public String toString()
    {
       String assemble = name;
       for(Card name: cards){assemble += "\n"+name.toString();}
       return assemble;
    }
}
