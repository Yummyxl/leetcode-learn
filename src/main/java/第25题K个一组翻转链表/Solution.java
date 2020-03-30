package 第25题K个一组翻转链表;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/22
 */

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        for (int i=0; i<k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 反转k个
        ListNode newHead = reverse(head, tail);

        // 开始下一个k反转
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != tail) {
            ListNode first = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = first;
        }
        return dummy.next;
    }

    // 反转链表的前k个节点
    public ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;

        while (k > 0) {
            k--;
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }

        head.next = cur;
        return dummy.next;
    }

}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}