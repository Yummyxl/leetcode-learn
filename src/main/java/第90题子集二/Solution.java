package 第90题子集二;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/5
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, Deque<Integer> deque, List<List<Integer>> result) {
        result.add(new LinkedList<>(deque));
        for (int i = start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            deque.addLast(nums[i]);
            backtrack(nums, i + 1, deque, result);
            deque.removeLast();
        }
    }
}