package data.project;


public class AsmaKhourdji_Node<T> {
    
    T data;
    AsmaKhourdji_Node<T> next;
    AsmaKhourdji_Node<T> prev;

    public AsmaKhourdji_Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

