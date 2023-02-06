package _51_merge_two_sorted_list;

/**
 * @author Ikechi Ucheagwu
 * @created 06/02/2023 - 10:29
 * @project Algo Github
 */


public class ListNode {

    Node head;
    private Node prev;

    static class Node {
        Node next;
        int data;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = prev = node;
        } else {
            prev.next = node;
            prev = node;
        }
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void display(ListNode listNode) {
        Node node = listNode.head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
