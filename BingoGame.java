import java.util.ArrayList;
import java.util.Scanner;
public class BingoGame
{
    public static void demo()
    {
        Scanner in = new Scanner(System.in);
        Tiles t = new Tiles();
        System.out.print("Enter Player Name:  "); 
        String name = in.nextLine(); Player pl = new Player(name);
        System.out.print("Enter Number of Boards:  "); Game g = new Game();
        int numCards = Integer.parseInt(in.nextLine());
        for(int i = 0; i<numCards; i++){pl.addCard(new Card());}
        pl.print();
        while(true)
        {
            System.out.println();
            System.out.print("\nEnter tile value, <enter> for random tile, or \"q\" to quit):  ");
            String input = in.nextLine().toUpperCase();
            System.out.println();
            if(input.equals("Q"))
            {
                System.out.println("Game ended");
                System.exit(0);
            }
            else if(t.contains(input)) 
            {
                System.out.println(input + " has already been called.");
            }
            else if(!t.isValidTile(input))
            {
                System.out.println(input + " is not a valid tile.");
            }
            else
            { 
                String newTile;
                if(input.length()==0){newTile = g.aiGuess();}
                else{newTile = input;}
                System.out.println("The tile called was " + newTile);
                pl.call(newTile);
                t.add(newTile);
                if(pl.win())
                {
                    System.out.println("BINGO!!");
                    pl.print();
                    System.exit(0);
                }
            }
            pl.print();
        }
    }

    public static int averageCallsForWin(int numGames, int numCard)
    {
        int guessCount = 0;
        int hitCount = 0;
        if(numGames == 0){return -1;}
        for(int i = 0; i<numGames; i++)
        {
            boolean pass = true;
            Player pl = new Player("Test");
            Game g = new Game();
            for(int k = 0; k<numCard; k++)
            {
                Card test = new Card();
                pl.addCard(test);
            }
            while(pass)
            {                            
                String guess = g.aiGuess();
                if(pl.call(guess)>0)
                {
                    hitCount++;
                }
                guessCount++;
                if(pl.win()){pass = false;}
            }
        }
        System.out.println("Information");
        System.out.println("Games Simulated: "+numGames);
        System.out.println();
        System.out.println("Total Moves Made: "+guessCount);
        System.out.println("Total Hits: "+hitCount);
        System.out.println();
        System.out.println("Avg Moves Made per Game: "+guessCount/numGames);
        System.out.println("Avg Hits per Game: "+hitCount/numGames);
        return (int)Math.round(guessCount / (double)numGames);
    }
}
