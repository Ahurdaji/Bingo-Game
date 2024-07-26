package data.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class AsmaKhourdji_BingoCard {
    //instance variable
     AsmaKhourdji_DLinkList<Integer>[] rows;

    //Constructor
    public AsmaKhourdji_BingoCard() {
        rows = new AsmaKhourdji_DLinkList[3];
        for (int i = 0; i < 3; i++) {
            rows[i] = new AsmaKhourdji_DLinkList<>();
        }

    }
    public void generateCard() {
        Random random = new Random();
        for (int col = 0; col < 9; col++) {
            List<Integer> numbers = new ArrayList<>();
            int min = col * 10 + 1;
            int max = col * 10 + 10;
            for (int i = min; i < max; i++) {
                numbers.add(i);
            }
            for (int row = 0; row < 3; row++) {
                int random_num = random.nextInt(numbers.size());
                rows[row].addLast(numbers.remove(0));
            }
        }

         // Randomly block out 4 boxes per line
        for (int i = 0; i < 3; i++) {
            List<Integer> positions = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                positions.add(j);
            }
         //loop to block 4 possition
            for (int j = 0; j < 4; j++) {
                int random_num = random.nextInt(positions.size());
                int position = positions.get(random_num);
                positions.remove(random_num); // Remove selected position to avoid duplication
                AsmaKhourdji_Node<Integer> current = rows[i].head;
                for (int k = 0; k < position && current != null; k++) {
                    current = current.next;
                }
                if (current != null) {
                    current.data = -1; // Blocked out box
                }
            }
        }
        System.out.println("Bingo Card Generated:");
        printCard(new LinkedList<>());
    }
    
        boolean bingo1 = false;
        boolean bingo2 = false;
        boolean bingo3 = false;
    public int playGame(LinkedList<Integer> selectedNumbers, int n) {
        int m = 0;//used to indicate whether a full Bingo (three rows) has been achieved.
       
        if (n == 1) //first player
        {
            System.out.println("Bingo Card for the first player:");
            printCard(selectedNumbers);
        } else {
            System.out.println("Bingo Card for the second player:");
            printCard(selectedNumbers);
        }

        if (!bingo1 && checkBingo1(selectedNumbers)) {
            if (n == 1) {
                System.out.println("first player Bingo1 (birinci çinko)!");
            } else {
                System.out.println("second player Bingo1 (birinci çinko)!");

            }
            bingo1 = true;
        }
        if (!bingo2 && checkBingo2(selectedNumbers)) {
            if (n == 1) {
                System.out.println("first player Bingo2 (ikinciçinko)!");
            } else {
                System.out.println("second player Bingo2 (ikinciçinko)!");
            }
            bingo2 = true;
        }
        if (!bingo3 && checkBingo3(selectedNumbers)) {
            bingo3 = true;
            m = 1;
            if (n == 1) {

                System.out.println("first player Bingo3 (Tombala)!");

            } else {

                System.out.println("second player Bingo3 (Tombala)!");

            }
            return m;

        }
        return 0;
    }

    public boolean checkBingo1(LinkedList<Integer> selectedNumbers) {
        for (AsmaKhourdji_DLinkList<Integer> row : rows) {
            AsmaKhourdji_Node<Integer> current = row.head;
            int count = 0;
            while (current != null) {
                if (current.data != -1 && selectedNumbers.contains(current.data)) {
                    count++;
                }
                current = current.next;
            }
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBingo2(LinkedList<Integer> selectedNumbers) {
        int matchingRows = 0;
        for (AsmaKhourdji_DLinkList<Integer> row : rows) {
            AsmaKhourdji_Node<Integer> current = row.head;
            int count = 0;
            while (current != null) {
                if (current.data != -1 && selectedNumbers.contains(current.data)) {
                    count++;
                }
                current = current.next;
            }
            if (count == 5) {
                matchingRows++;
            }
        }
        return matchingRows == 2;
    }

    public boolean checkBingo3(LinkedList<Integer> selectedNumbers) {
        int matchingRows = 0;
        for (AsmaKhourdji_DLinkList<Integer> row : rows) {
            AsmaKhourdji_Node<Integer> current = row.head;
            int count = 0;
            while (current != null) {
                if (current.data != -1 && selectedNumbers.contains(current.data)) {
                    count++;
                }
                current = current.next;
            }
            if (count == 5) {
                matchingRows++;
            }
        }
        return matchingRows == 3;
    }

    public void printCard(LinkedList<Integer> selectedNumbers) {
        for (int i = 0; i < 3; i++) {
            AsmaKhourdji_Node<Integer> current = rows[i].head;
            while (current != null) {
                if (selectedNumbers.contains(current.data)) {
                    System.out.print("  0 ");
                } else if (current.data == -1) {
                    System.out.print("  X ");
                } else {
                    System.out.printf("%3d ", current.data);
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

