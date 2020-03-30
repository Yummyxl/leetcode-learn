package 第4题寻找两个有序数组的中位数;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/20
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 解题思路是 转为找第k小的数
 * 因为两个数组有序，所以找到两个数组的二分之k小的数，那个数小删除那个数组的这二分之k小的数，可以保证第k小的数肯定不在这里，
 * 然后继续找两个数组的第（k - k/2）小数
 */

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 == 0) {
            // 长度是偶数 需要找到中间的两个值
            return ((double)getIndexK(nums1, 0, nums2, 0, sum / 2)
                    + (double)getIndexK(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
        } else {
            // 长度是奇数 需要找到中间的一个值
            return (double)getIndexK(nums1, 0, nums2, 0, (sum + 1) / 2);
        }
    }

    public int getIndexK(int[] nums1, int left1, int[] nums2, int left2, int k) {
        // 数组已经删除完了
        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        // 这里是校验剩余数组够不够删除，比如说第4（k）小，需要删除2（k / 2）个，但是删除的是从left所在位置算起，就是
        // 说需要删除的最后一个元素下标是 left + 2（k / 2）- 1，需要校验在不在数组范围内，如果不在就不能删除，直接删除另外一个数组
        int num1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int num2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (num1 <= num2) {
            // 这里left是最新的有效的索引下表，所以要直接加上 k / 2
            return getIndexK(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        } else {
            // 这里left是最新的有效的索引下表，所以要直接加上 k / 2
            return getIndexK(nums1, left1, nums2, left2 + k / 2, k - k / 2);
        }
    }
}
