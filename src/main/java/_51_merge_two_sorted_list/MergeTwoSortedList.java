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
        var head1 = node1.head;
        var head2 = node2.head;

        if (head1.data < head2.data) {
            merge(head1.next, head2);
        } else {
            merge(head1, head2.next);
        }

        return null;
    }

    private static ListNode merge(ListNode.Node node1, ListNode.Node node2) {
        return null;
    }
}
