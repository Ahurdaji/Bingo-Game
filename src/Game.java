import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

class BingoCard {
    int number;
    BingoCard next;
    ArrayList<Integer> labels;

    BingoCard(int number, ArrayList<Integer> labels) {
        this.number = number;
        this.labels = labels;
        this.next = null;
    }
}

  public class Game extends JFrame {
    private JPanel cardsPanel;

    public Game() {
        setTitle("Tombola Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        cardsPanel = new JPanel();
        add(cardsPanel);

        generateCards(3); // Generate 3 bingo cards
    }

    private void generateCards(int numCards) {
        cardsPanel.setLayout(new GridLayout(numCards, 1));

        for (int i = 1; i <= numCards; i++) {
            ArrayList<Integer> labels = new ArrayList<>();
            for (int j = 1; j <= 9; j++) {
                labels.add(j + (i - 1) * 9); // Generate labels for the card
            }
            Collections.shuffle(labels);
            BingoCard card = new BingoCard(i, labels);
            displayCard(card);
        }
    }

    private void displayCard(BingoCard card) {
        JPanel cardPanel = new JPanel(new GridLayout(1, 5));
        JLabel cardLabel = new JLabel("Card " + card.number);
        cardPanel.add(cardLabel);
        for (Integer label : card.labels) {
            JLabel labelComponent = new JLabel(label.toString());
            cardPanel.add(labelComponent);
        }
        cardsPanel.add(cardPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
