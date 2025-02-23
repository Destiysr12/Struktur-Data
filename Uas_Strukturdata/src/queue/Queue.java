package queue;
import java.util.Iterator;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {return first == null ;}
    public int size() {return N;}
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue kosong!");
        }
        Item item = first.item;
        first = first.next;
        N++;
        if (isEmpty()) last = null;
        return item;
    }
    public Iterator<Item> iterator() {return new ListIterator();}
    private class ListIterator implements  Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {return current !=null;}
        public Item next() {
            if (!hasNext()) throw new RuntimeException("Tidak ada elemen lagi");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        Queue<String> queue = new Queue<>();

        System.out.print("Masukkan Nama (X) : ");
        while (true) {
            name = scanner.nextLine();
            if (name.equals("X")) {
                break;
            }
            queue.enqueue(name);
        }
        for (String names : queue) {
            System.out.println(names);
        }
        queue.dequeue();
        System.out.println("===========================");
        for (String names : queue) {
            System.out.println(names);
        }
    }
}