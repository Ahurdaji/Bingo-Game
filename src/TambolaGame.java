

//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Collections;
//
//class Node {
//
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//class Column {
//
//    Node first;
//
//    Column() {
//        first = null;
//    }
//
//    void add(int data) {
//        Node newNode = new Node(data);
//        if (first == null) {
//            first = newNode;
//        } else {
//            Node temp = first;
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//            temp.next = newNode;
//        }
//    }
//}
//
//class TambolaCard {
//
//    Column[] columns;
//
//    TambolaCard() {
//        columns = new Column[9];
//        for (int i = 0; i < 9; i++) {
//            columns[i] = new Column();
//        }
//        initializeNumbers();
//    }
//
//    private void initializeNumbers() {
//        int start = 1;
//        int end = 9;
//        for (int colIndex = 0; colIndex < 9; colIndex++) {
//            for (int num = start; num <= end; num++) {
//                columns[colIndex].add(num);
//            }
//            start += 10;
//            end += 10;
//        }
//    }
//}
//
//public class TambolaGame extends JFrame {
//
//    private TambolaCard[] playerCards;
//    private int currentPlayer;
//    private ArrayList<Integer> calledNumbers;
//
//    public TambolaGame() {
//        setTitle("Tambola Game");
//        setSize(800, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        currentPlayer = 0;
//        playerCards = new TambolaCard[2];
//        playerCards[0] = new TambolaCard();
//        playerCards[1] = new TambolaCard();
//
//        calledNumbers = new ArrayList<>();
//
//        JPanel player1Panel = new JPanel();
//        player1Panel.setLayout(new GridLayout(3, 9));
//        JPanel player2Panel = new JPanel();
//        player2Panel.setLayout(new GridLayout(3, 9));
//
//        displayPlayerCard(playerCards[0], player1Panel);
//        displayPlayerCard(playerCards[1], player2Panel);
//
//        add(player1Panel, BorderLayout.WEST);
//        add(player2Panel, BorderLayout.EAST);
//
//        JButton callNumberButton = new JButton("Call Number");
//        callNumberButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                callNumber();
//            }
//        });
//        add(callNumberButton, BorderLayout.SOUTH);
//
//        setVisible(true);
//    }
//
//    private void displayPlayerCard(TambolaCard card, JPanel panel) {
//        for (int col = 0; col < 9; col++) {
//            for (int row = 0; row < 3; row++) {
//                String text = "";
//                Node current = card.columns[col].first;
//                for (int i = 0; i < row; i++) {
//                    if (current != null) {
//                        current = current.next;
//                    }
//                }
//                if (current != null) {
//                    text = String.valueOf(current.data);
//                    current = current.next;
//                }
//                JButton button = new JButton(text);
//                button.setEnabled(false);
//                panel.add(button);
//            }
//        }
//    }
//
//    private void callNumber() {
//        if (calledNumbers.size() >= 90) {
//            JOptionPane.showMessageDialog(this, "All numbers called!");
//            return;
//        }
//
//        int number;
//        do {
//            number = (int) (Math.random() * 90) + 1;
//        } while (calledNumbers.contains(number));
//
//        calledNumbers.add(number);
//        JOptionPane.showMessageDialog(this, "Number called: " + number);
//
//        int currentPlayerIndex = currentPlayer % 2;
//
//        TambolaCard card = playerCards[currentPlayerIndex];
//        for (int col = 0; col < 9; col++) {
//            for (int row = 0; row < 3; row++) {
//                Node current = card.columns[col].first;
//                for (int i = 0; i < row; i++) {
//                    if (current != null) {
//                        current = current.next;
//                    }
//                }
//                if (current != null && current.data == number) {
//                    current.data = 0; // Mark the number as called
//
//                    // Find the JButton corresponding to the called number
//                    Component[] components = getContentPane().getComponents();
//                    for (Component component : components) {
//                        if (component instanceof JPanel) {
//                            Component[] buttons = ((JPanel) component).getComponents();
//                            for (Component button : buttons) {
//                                if (button instanceof JButton) {
//                                    JButton btn = (JButton) button;
//                                    if (btn.getText().equals(String.valueOf(number))) {
//                                        btn.setOpaque(true); // Ensure button is opaque
//                                        btn.setBackground(Color.RED); // Change background color to red
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//
//        currentPlayer++;
//    }
//
//    public static void main(String[] args) {
//        new TambolaGame();
//    }
//}
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Column {
    Node first;

    Column() {
        first = null;
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}

class TambolaCard {
    Column[] columns;

    TambolaCard() {
        columns = new Column[9];
        for (int i = 0; i < 9; i++) {
            columns[i] = new Column();
        }
        initializeNumbers();
    }

    private void initializeNumbers() {
        int start = 1;
        int end = 9;
        for (int colIndex = 0; colIndex < 9; colIndex++) {
            for (int num = start; num <= end; num++) {
                columns[colIndex].add(num);
            }
            start += 10;
            end += 10;
        }
    }
}

public class TambolaGame {
    private TambolaCard[] playerCards;
    private int currentPlayer;
    private Set<Integer> calledNumbers;

    public TambolaGame() {
        currentPlayer = 0;
        playerCards = new TambolaCard[2];
        playerCards[0] = new TambolaCard();
        playerCards[1] = new TambolaCard();

        calledNumbers = new HashSet<>();

        playGame();
    }

    private void playGame() {
        while (calledNumbers.size() < 90) {
            callNumber();
        }
        System.out.println("All numbers called!");
    }

    private void callNumber() {
        int number;
        do {
            number = (int) (Math.random() * 90) + 1;
        } while (calledNumbers.contains(number));

        calledNumbers.add(number);
        System.out.println("Number called: " + number);

        int currentPlayerIndex = currentPlayer % 2;

        TambolaCard card = playerCards[currentPlayerIndex];
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 3; row++) {
                Node current = card.columns[col].first;
                for (int i = 0; i < row; i++) {
                    if (current != null) {
                        current = current.next;
                    }
                }
                if (current != null && current.data == number) {
                    current.data = 0; // Mark the number as called
                    break;
                }
            }
        }

        currentPlayer++;
    }

    public static void main(String[] args) {
        new TambolaGame();
    }
}
