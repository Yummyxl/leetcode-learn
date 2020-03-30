package 第21题合并两个有序链表;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/22
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pre = new ListNode(0);
        ListNode top = pre;
        while (l1 != null && l2 != null) {
            boolean b = l1.val < l2.val;
            ListNode tem = new ListNode(b ? l1.val : l2.val);
            pre.next = tem;
            pre = pre.next;
            if (b) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }

        return top.next;
    }

}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
}
