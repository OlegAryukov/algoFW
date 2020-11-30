package leetcode.explore.recursion.linkList;

public class MergeTwoList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if (l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode first1 = new ListNode(1);
//        ListNode first2 = new ListNode(2);
//        ListNode first3 = new ListNode(4);
//
//        first1.next = first2;
//        first2.next = first3;
//
//        ListNode sec1 = new ListNode(1);
//        ListNode sec2 = new ListNode(3);
//        ListNode sec3 = new ListNode(4);
//
//        sec1.next = sec2;
//        sec2.next =sec3;

//        ListNode listNode = MergeTwoList.mergeTwoLists(first1, sec1);
    }
}
