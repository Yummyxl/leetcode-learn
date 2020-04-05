package 第83题删除排序链表中的重复元素;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/5
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}