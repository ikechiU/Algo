package org.example._16_remove_duplicate_from_linkedlist;

public class MyLinkedList<T> {
    private int count;
    public Node head;
    public Node end;

    public class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T item) {
        Node temp = new Node(item);
        if(head == null) {
            head = temp;
            end = head;
        } else {
            end.next = temp;
            end = temp;
        }
        count++;
    }

    public void removeHead() {
        if (head != null) {
            Node temp = head.next;
            if(temp == null) {
                head = null;
                end = null;
            } else
                head = temp;
            count--;
        }
    }

    public void addNewHead(T item) {
        Node temp = new Node(item);
        if (head == null) {
            head = temp;
            end = head;
        } else {
            temp.next = head;
            head = temp;
        }
        count++;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) System.out.print("->");
            else System.out.println("\n");
        }
    }

    public boolean removeItem(T item) {
        Node node = head;
        Node preNode = node;
        while(node != null) {
            if (node.data == item) {
                if (node == head) {
                    if (head == end) end = node.next;
                    head = node.next;
                }
                if (node == end) {
                    end = preNode;
                    preNode.next = null;
                }
                count--;
                return true;
            }
            preNode = node;
            node = node.next;
        }
        return false;
    }

    public int size() {
        return count;
    }
}
