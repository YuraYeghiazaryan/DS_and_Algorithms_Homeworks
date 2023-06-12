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
//            }
//            current.next = newItem;
//            newItem.previous = current;

            tail.next = newItem;
            newItem.previous = tail;
