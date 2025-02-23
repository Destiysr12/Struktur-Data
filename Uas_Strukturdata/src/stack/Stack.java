package stack;
import java.util.Iterator;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {return current !=null;}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remeve() {throw new UnsupportedOperationException();}

    }
    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty() {return first == null;}
    public int size() {
        return N;
    }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        N++;
        return item;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        Stack<String> s = new Stack<>();
        System.out.print("Masukkan Nama Buku (X) : ");
        while (true) {
            name = scanner.nextLine();
            if(name.equals("X")) {
                break;
            }
            s.push(name);
        }
        for (String names : s) {
            System.out.println(names);
        }
        s.pop();
        System.out.println("=======================");
        for (String names : s) {
            System.out.println(names);
        }
    }
}

