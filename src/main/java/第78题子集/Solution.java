package 第78题子集;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/4
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            result.add(new LinkedList<>());
            return result;
        }

        Deque<Integer> deque = new LinkedList<>();
        backTrack(nums, 0, result, deque);
        return result;
    }

    public void backTrack(int[] nums, int k, List<List<Integer>> result, Deque<Integer> deque) {
        result.add(new LinkedList<>(deque));
        System.out.println(new LinkedList<>(deque));
        for (int j = k; j<nums.length; j++) {
            deque.addLast(nums[j]);
            backTrack(nums, j + 1, result, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3});
    }
}