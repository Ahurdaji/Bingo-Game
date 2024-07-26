package data.project;

import java.util.LinkedList;
import java.util.Random;

public class AsmaKhourdji_Main {

    public static void main(String[] args) {
        AsmaKhourdji_BingoCard card1 = new AsmaKhourdji_BingoCard();
        card1.generateCard();
        AsmaKhourdji_BingoCard card2 = new AsmaKhourdji_BingoCard();
        card2.generateCard();
        LinkedList<Integer> selectedNumbers = new LinkedList<>(); //to keep trcak numbers that called
        int selectedNumberCount = 0;
        System.out.println("\nStarting the game!");
        while (selectedNumberCount < 100) {

            Random random = new Random();
            System.out.println("-------------------------------------"); // Adding line separator

            int selectedNumber;
            do {
                selectedNumber = random.nextInt(89);
            } while (selectedNumbers.contains(selectedNumber));// Keep generating a new number until it's unique

            System.out.println(" selected random number is " + selectedNumber);

            selectedNumbers.add(selectedNumber);
            if (card1.playGame(selectedNumbers, 1) == 1) {
                System.out.println("player 1 won the game");
                break;
            }
            if (card2.playGame(selectedNumbers, 2) == 1) {
                System.out.println("player 2 won the game");
                break;
            }

            selectedNumberCount++;
        }
        System.out.println("Game Over!");
    }
}
