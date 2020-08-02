public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    public static ListNode buildListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode s = new ListNode(arr[i]);
            s.next = null;
            p.next = s;
            p = s;
        }
        return dummy.next;

    }
    public static void travel(ListNode head) {
        ListNode p = head;
        int i = 10;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
            if(i-- < 0) {
                break;
            }
        }
    }
}
