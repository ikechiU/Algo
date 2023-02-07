package _51_merge_two_sorted_list;

/**
 * @author Ikechi Ucheagwu
 * @created 06/02/2023 - 10:28
 * @project Algo Github
 */

public class MergeTwoSortedList {

    public static void main(String[] args) {
        //[1,2,4]
        ListNode node1 = new ListNode();
        node1.add(1);
        node1.add(2);
        node1.add(4);

        //[1,3,4]
        ListNode node2 = new ListNode();
        node2.add(1);
        node2.add(3);
        node2.add(4);
        
        ListNode result = mergeTwoSortedList(node1, node2);
        result.display(result);
    }

    private static ListNode mergeTwoSortedList(ListNode node1, ListNode node2) {
        ListNode node;

        if (node1.head.data < node2.head.data) {
            node = merge(node1, node2, node1);
        } else {
            node = merge(node1, node2, node2);
        }

        return node;
    }

    private static ListNode merge(ListNode node1, ListNode node2, ListNode node) {

        ListNode.Node tempNode1 = node1.head;
        ListNode.Node tempNode2 = node2.head;

        boolean isSet = false;
        ListNode result = new ListNode();
        ListNode.Node prev = null;

        do {
            if (tempNode1 != null && tempNode1.equals(node.head) && !isSet) {
                result.head = prev = tempNode1;
                isSet = true;
                tempNode1 = tempNode1.next;
            } else if (tempNode2 != null && tempNode2.equals(node.head) && !isSet) {
                result.head = prev = tempNode2;
                isSet = true;
                tempNode2 = tempNode2.next;
            }


            if (tempNode1 != null && tempNode2 != null && tempNode1.data < tempNode2.data && prev != null) {
                prev.next = tempNode1;
                prev = tempNode1;
                tempNode1 = tempNode1.next;
            } else if (tempNode1 != null && tempNode2 != null && prev != null) {
                prev.next = tempNode2;
                prev = tempNode2;
                tempNode2 = tempNode2.next;
            } else {
                if (tempNode1 == null && tempNode2 != null && prev != null) {
                    prev.next = tempNode2;
                    prev = tempNode2;
                    tempNode2 = tempNode2.next;
                }
                if (tempNode2 == null && tempNode1 != null && prev != null) {
                    prev.next = tempNode1;
                    prev = tempNode1;
                    tempNode1 = tempNode1.next;
                }
            }

        } while (tempNode1 != null || tempNode2 != null);



        return result;
    }
}
