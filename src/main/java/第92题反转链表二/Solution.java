package 第92题反转链表二;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/6
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == 1) {
            return reverseNRecursive(head, n);
        }

        head.next = reverseBetween1(head.next, m-1, n-1);
        return head;
    }

    public ListNode reverseAllRecursive(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode last = reverseAllRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode successor = null;

    public ListNode reverseNRecursive(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseNRecursive(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseAllIterator(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
//        head.next = cur;
        return dummy.next;
    }

    public ListNode reverseNIterator(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;

        while (cur != null && n > 0) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        head.next = cur;
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q;

        while (m > 1 && p != null && p.next != null) {
            p = p.next;
            m--;
            n--;
        }
        if (m > 1) {
            return head;
        }
        q = p.next;
        head = q;
        while (q != null && n > 0) {
            ListNode next = q.next;
            q.next = p.next;
            p.next = q;
            q = next;
            n--;
        }
        head.next = q;

        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}