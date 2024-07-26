package data.project;

class AsmaKhourdji_DLinkList<T> {

    AsmaKhourdji_Node<T> head;
    int size = 0;

    public void addFirst(T data) {
        AsmaKhourdji_Node<T> newNode = new AsmaKhourdji_Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        AsmaKhourdji_Node<T> newNode = new AsmaKhourdji_Node<>(data);
        AsmaKhourdji_Node<T> temp = head;
        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        size++;
    }

    public void insertAfter(T data, T search) {
        AsmaKhourdji_Node<T> temp = head;
        AsmaKhourdji_Node<T> newNode = new AsmaKhourdji_Node<>(data);
        while (temp != null && !temp.data.equals(search)) {
            temp = temp.next;
        }
        if (temp != null) {
            newNode.next = temp.next;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            temp.next = newNode;
            size++;
        } else if (temp == null && temp.prev.data.equals(search)) {
            addLast(data);
        } else {
            System.out.println(data + " not found");
        }
    }

    public boolean remove(T data, T search) {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        } else {
            if (head.data.equals(data)) {
                head = head.next;
                head.prev = null;
                size--;
                return true;
            } else {
                AsmaKhourdji_Node<T> temp = head.next;
                while (temp != null && !temp.data.equals(search)) {
                    temp = temp.next;
                }
                if (temp != null) {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }
                size--;
                return true;
            }
        }
    }

    public void print() {
        AsmaKhourdji_Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
