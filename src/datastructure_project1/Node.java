
package datastructure_project1;

public class Node {
    int numbers[];
  int data;
 Node right;
 Node down;
 Node Up;
 private int number;
        private int row;
        private int col;
        private Node next;
  
public Node(int data){
    numbers = new int[9];
    this.data=data;
    right=null;
    down=null;
}

        public Node(int number, int row, int col) {
            this.number = number;
            this.row = row;
            this.col = col;
        }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }


}