package leetcode.explore.recursion;

public class RecursionSwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head.next.next!=null){
            swapPairs(head.next);
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
