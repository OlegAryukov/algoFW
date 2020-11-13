package leetcode.problems.easy;

public class DeleteDuplicatesFromLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headForReturne = head;
        ListNode curr = head;
        ListNode next = curr;
        while (curr.next!=null){
            if(curr.next.val == curr.val){
                curr = curr.next;
                continue;
            }
            next = curr.next;
            curr = curr.next;
        }
        next.next = null;
        return headForReturne;
    }
}
