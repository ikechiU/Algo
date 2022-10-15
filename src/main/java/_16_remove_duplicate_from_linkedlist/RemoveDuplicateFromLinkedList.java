package _16_remove_duplicate_from_linkedlist;

// TC -> O(n) SC -> O(1)
public class RemoveDuplicateFromLinkedList {
    public static void main(String[] args) {
        removeDuplicate();
    }

    private static void removeDuplicate() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(6);

        list.display();

        var distinctNode = list.head.next;
        var currentNode = list.head;
        while (distinctNode != null) {
            if (currentNode.data != distinctNode.data) {
                currentNode.next = distinctNode;
                currentNode = distinctNode;
            }
            distinctNode = distinctNode.next;
            if (distinctNode == null) {
                currentNode.next = null;
                list.end = currentNode;
            }
        }

        list.display();
    }
}
