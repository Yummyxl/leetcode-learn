package 第19题删除链表的倒数第N个节点;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/22
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode pre = top;
        ListNode next = top;
        while (n != 0) {
            pre = pre.next;
            n--;
        }
        if (pre == null) {
            return top.next;
        }

        while (pre != null && pre.next != null) {
            pre = pre.next;
            next = next.next;
        }
        System.out.println(next.next);
        if (next.next != null) {
            next.next = next.next.next;
        }
        return top.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode top = new ListNode(1);
        System.out.println(new Solution().removeNthFromEnd1(top, 1));
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
