import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.HashSet;

public class Game {
    private Random r = new Random();
    public Tiles t = new Tiles();

    public static void main() throws Exception {
        display.main(0);
        Scanner keys = new Scanner(System.in);
        System.out.print("Enter Player Name:  ");
        String name = keys.next();
        System.out.print("Enter Number of Boards:  ");
        int num = keys.nextInt();
        Player pl = new Player(name);
        for (int i = 0; i < num; i++) {
            pl.addCard(new Card());
        }
        pl.print();
        Game g = new Game();
        while (true) {
            String guess = g.aiGuess();
            try {
                bar.main();
            } catch (Exception e) {
            }
            if (pl.call(guess) > 0)
                JOptionPane.showMessageDialog(null, "Lisa Pulled - Hit: " + guess.charAt(0) + " " + guess.substring(1));
            else
                JOptionPane.showMessageDialog(null,
                        "Lisa Pulled - Missed: " + guess.charAt(0) + " " + guess.substring(1));
            if (pl.win()) {
                break;
            }
            pl.print();
        }
        display.main(1);
        System.out.println("BINGO!");
        pl.print();
    }

    private HashSet<String> set = new HashSet<String>();

    public String aiGuess() {
        while (true) {
            int digit = r.nextInt(75) + 1;
            String assemble = "";
            if (digit >= 1 && digit <= 15) {
                assemble += "B" + digit;
            }
            if (digit >= 16 && digit <= 30) {
                assemble += "I" + digit;
            }
            if (digit >= 31 && digit <= 45) {
                assemble += "N" + digit;
            }
            if (digit >= 46 && digit <= 60) {
                assemble += "G" + digit;
            }
            if (digit >= 61 && digit <= 75) {
                assemble += "O" + digit;
            }
            if (set.add(assemble) == true) {
                return assemble;
            }

        }
    }
}

class bar extends JPanel {
    JProgressBar pbar;
    static final int MY_MINIMUM = 0;
    static final int MY_MAXIMUM = 40;

    public bar() {
        pbar = new JProgressBar();
        pbar.setMinimum(MY_MINIMUM);
        pbar.setMaximum(MY_MAXIMUM);
        add(pbar);
    }

    public void updateBar(int newValue) {
        pbar.setValue(newValue);
    }

    public static void main() throws MalformedURLException {
        final bar it = new bar();
        JFrame frame = new JFrame("Guessing . . . ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(it);
        frame.pack();
        frame.setVisible(true);
        //////////////////// UPDATE LOCATION //////////////////////
        URL url = new URL("file://localhost/Users"); //lisa gif
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
            final int percent = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        it.updateBar(percent);
                        if (percent == 40) {
                            frame.setVisible(false);
                        }
                    }
                });
                java.lang.Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}


///////////// UPDATE LOCATION 2 ///////////////
class display {
    public static void main(int in) throws MalformedURLException {
        String str = "";
        if (in == 0) {
            str = ("file://localhost/Users"); //loading gif
        } else {
            str = ("file://localhost/Users"); //winning gif
        }
        URL url = new URL(str);
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        JFrame f = new JFrame("Animation");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        try {
            java.lang.Thread.sleep(3700);
        } catch (InterruptedException e) {
        }
        f.setVisible(false);
    }
}
