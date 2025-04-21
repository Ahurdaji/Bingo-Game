
package datastructure_project1;


import java.util.Random;


public class MultiLinkedList {
    private Node[] heads; // Array of head pointers for each row
    private final int rows = 3;
    private final int cols = 9;

 Node head;
  public MultiLinkedList() {
        heads = new Node[rows];
    }
// public MultiLinkedList(){
//     this.head=null;
// }
//   // Method to insert random numbers into the card
  public void insertRandomNumbers() {
      Random random = new Random();

        // Fill the linked list with numbers (1-9 in first row, 10-19 in second, etc.)
        for (int col = 0; col < cols; col++) {
            int startNumber = (col * 10) + 1; // Starting number for each row
            for (int row = 0; row < rows; row++) {
                addNode(row, col, startNumber + row);
            }
        }
       
    }

    public void addNode(int row, int col, int number) {
        Node newNode = new Node(number, row, col);
        if (heads[row] == null) {
            heads[row] = newNode;
        } else {
            Node current = heads[row];
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void printCard() {
        for (int col = 0; col < cols; col++) {
            Node current = heads[col];
            while (current != null) {
                System.out.print(current.getNumber() + " ");
                current = current.getNext();
            }
            System.out.println();
        }
    }
  
//        Random random = new Random();
//        //Node newNode = new Node( data);
//        for (int row = 0; row < 9; row++) {
//            Node Rstart= null;
//            Node prev = null;
//        int randomNumber = random.nextInt(90) + 1; // Generate a random number between 1 and 90
//                Node newNode = new Node(randomNumber);
//                if (Rstart == null) {
//                    Rstart = newNode;
//                } else {
//                    prev.right = newNode;
//                }
//                prev = newNode;
//            
//            if (head == null) {
//                head = Rstart;
//            } else {
//                Node temp = head;
//                while (temp.down != null) {
//                    temp = temp.down;
//                }
//                temp.down = Rstart;
//            }
//        }
//    }
//  // Method to print the multi-linked list (card)
//    public void printCard() {
//        Node Row_temp = head;
//        while (Row_temp != null) {
//            Node col_temp = Row_temp;
//            while (col_temp  != null) {
//                System.out.print(col_temp .data + " ");
//                col_temp  = col_temp .right;
//            }
//            System.out.println();
//            Row_temp = Row_temp.down;
//        }
//    }
//
    public static void main(String[] args) {
        MultiLinkedList card = new MultiLinkedList();
        card.insertRandomNumbers();
        card.printCard();
    }
}