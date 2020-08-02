import org.w3c.dom.ls.LSInput;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * reverse the given linked list
     *
     * @param head ListNode类 the head of the linked list
     * @param n    int整型 the N
     * @return ListNode类
     */
    public ListNode reverseLinkedList(ListNode head, int n) {
        if (head == null || head.next == null || n < 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode end = start;
        ListNode next = null;
        while (end != null) {
            for (int i = 0; i < n - 1; i++) {
                end = end.next;
                if (end == null) {
                    pre.next = start;
                    return dummy.next;
                }
            }
            next = end.next;
            end.next = null;
            pre.next = reverse(start);
            pre = start;
            end = start = next;

        }
        return dummy.next;

    }


    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7,8};
//        ListNode listNode = ListNode.buildListNode(arr);
//        //   ListNode node = new Solution().reverse(listNode);
//        ListNode node = new Solution().reverseLinkedList(listNode, 3);
//        ListNode.travel(node);
//    }

}