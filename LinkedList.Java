package linkedList;
// Double Linked List
public class LinkedList<T> {
    private  int objCounter = 0;
    private Item<T> head;
    private Item<T> tail;

    private static class Item<T> {
        private final T value;
        private Item<T> next;
        private Item<T> previous;

        Item(T value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

    }

    public LinkedList(){
        head = null;
        tail = null;
    }

    public void add(T value) {
        Item<T> newItem = new Item<>(value);

        if (objCounter == 0) {
            head = newItem;
        } else {
//            Item<T> current = head;
//            while (current.next != null) {
//                current = current.next;
//            newItem.previous = current;

            tail.next = newItem;
            newItem.previous = tail;


        }
        tail = newItem;

        objCounter++;
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.value.equals(data)){
            head = head.next;
            objCounter--;
            return;
        }

        if (tail.value.equals(data)) {
            tail = tail.previous;
            tail.next = null;
            objCounter--;
            return;
        }

        Item<T> current = head;
        while (current != null && !current.value.equals(data)) {
            current = current.next;
        }
        if(current != null) {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            objCounter--;
        }
    }
    public int length() {
        return objCounter;
    }
    public void printList() {
        Item<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }



}

