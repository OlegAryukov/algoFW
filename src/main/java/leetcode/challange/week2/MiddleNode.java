package leetcode.challange.week2;

public class MiddleNode {
    Integer countSecond = 0;
    Integer countFirst = 0;
    public  ListNode middleNode(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode first = head;
        ListNode second = first.next;
        while (true){
            second = moveSecondNode(second);
            if(second!=null){
                first = first.next;
                countFirst++;
            } else {
                first = countSecond %2==0 ? first.next : countFirst==countSecond ? first : first.next;
                break;
            }
        }
        return first;
    }

    private  ListNode moveSecondNode(ListNode node){
        if(node.next!=null){
            ListNode next = node.next;
            countSecond++;
            if (next.next!=null){
                countSecond++;
                return next.next;
            } else {
                return null;
            }
        }else {
            return null;
        }
    }

    //correct solution
    public ListNode correctMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        for (int i = 3; i < 6; i++) {
            ListNode nodeNext = new ListNode(i);
            node2.next = nodeNext;
            node2 = node2.next;
        }
        MiddleNode middleNode = new MiddleNode();
        middleNode.middleNode(node);
    }
}
