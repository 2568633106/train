package secondary;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(9);
        ListNode m4 = new ListNode(9);
        ListNode m5 = new ListNode(9);
        ListNode m6 = new ListNode(9);
        ListNode m7 = new ListNode(9);
        m1.next=m2;
        m2.next=m3;
        m3.next=m4;
        m4.next=m5;
        m5.next=m6;
        m6.next=m7;
        ListNode listNode = addTwoNumbers(n1, m1);
        System.out.println(1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1=l1,n2=l2;
        while (n1!=null&&n2!=null){
            n1.val=n1.val+n2.val;
            if(n1.val==10){
                n1.val=0;
                continue;
            }
            if(n1.val>10){
                n1.val=n1.val%10;
                 if(n1.next!=null){
                    n1.next.val=n1.next.val+1;
                }else{
                    ListNode newNode = new ListNode(1);
                    n1.next=newNode;
                }
            }
            n1=n1.next;
            n2=n2.next;
        }
        return l1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
