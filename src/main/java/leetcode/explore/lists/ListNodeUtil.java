package leetcode.explore.lists;

public class ListNodeUtil {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k != 1 && checkPossible(head, k)) {
            int stepsCount = 0;
            ListNode nextElement = null;
            if (head.next != null) {
                nextElement = head.next;
            }
            head.next = null;
            ListNode previosElement = head;
            ListNode tmpElement = null;

            while (stepsCount != k) {
                stepsCount++;
                if (stepsCount != k) {
                    tmpElement = nextElement.next;
                    if (stepsCount == 1) {
                        nextElement.next = previosElement;
                        previosElement = nextElement;
                        previosElement.next = head;
                    } else {
                        nextElement.next = previosElement;
                        previosElement = nextElement;
                    }
                    nextElement = tmpElement;
                } else {
                    head.next = nextElement;
                    break;
                }

            }
            if (checkPossible(nextElement, k)) {
                ListNode starAdd = previosElement;
                for (int i = 0; i < k - 1; i++) {
                    starAdd = starAdd.next;
                }
                starAdd.next = reverseKGroup(nextElement, k);
            } else {
                ListNode starAdd = previosElement;
                for (int i = 0; i < k - 1; i++) {
                    starAdd = starAdd.next;
                }
                starAdd.next = nextElement;
            }
            return previosElement;
        } else {
            return head;
        }
    }

    private boolean checkPossible(ListNode head, int k) {
        if(head==null){
            return false;
        }
        int steps = 0;
        while (head.next != null) {
            steps++;
            if (steps == k-1) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        ListNodeUtil lnu = new ListNodeUtil();
        ListNode res = lnu.reverseKGroup(a, 7);
        System.out.println(res.val);
        do {
            res = res.next;
            System.out.println(res.val);

        } while (res.next != null);

    }
}
