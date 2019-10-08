public class AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

     */
    public static void main(String[] args) {

        ListNode l1 = newListNode(2,4,3);
        ListNode l2 = newListNode(5,6,4);

        ListNode current = l1;
        while(current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
        current = l2;
        while(current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        current = result;
        while(current != null) {
            System.out.print(current);
            current = current.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int n1 = c1!=null ? c1.val : 0;
        int n2 = c2!=null ? c2.val : 0;
        int c = 0;
        c += (n1 + n2);
        boolean asc = c>=10;
        if (asc) {
            result = new ListNode(c-10);
            c = 1;
        } else {
            result = new ListNode(c);
            c = 0;
        }

        ListNode resultCurrent = result;
        c1 = c1.next;
        c2 = c2.next;
        while(c1!=null || c2!=null || c!=0) {
            if (c1!=null) {
                n1 = c1.val;
                c1 = c1.next;
            } else {
                n1 = 0;
            }
            if (c2!=null) {
                n2 = c2.val;
                c2 = c2.next;
            } else {
                n2 = 0;
            }
            c += (n1 + n2);
            if (c>=10) {
                resultCurrent.next = new ListNode(c-10);
                c = 1;
            } else {
                resultCurrent.next = new ListNode(c);
                c = 0;
            }
            resultCurrent = resultCurrent.next;
        }
        return result;
    }

    private static ListNode newListNode(int ...inputs) {
        ListNode newListNode = new ListNode(inputs[0]);
        ListNode current = newListNode;
        for (int i=1; i<inputs.length; i++) {
            current.next = new ListNode(inputs[i]);
            current = current.next;
        }
        return newListNode;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        System.out.println("new ListNode " + x);
        val = x;
    }

    @Override
    public String toString() {
        return " =" + this.val;
    }
}
