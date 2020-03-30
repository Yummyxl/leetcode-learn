package 第34题在排序数组中查找元素的第一个和最后一个位置;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/26
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    // 两次二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        result[0] = find(true, nums, target);
        result[1] = find(false, nums, target);
        return result;
    }

    private int find(boolean isFirst, int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                if (isFirst) {
                    if (mid > 0 && nums[mid] == nums[mid - 1]) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}
