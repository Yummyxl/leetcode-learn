package 第46题全排列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/29
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 还有一种方法看 全排列二
 *
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        getResult(nums, 0, result, new ArrayDeque<>());
        return result;
    }

    // 递归回溯
    public void getResult(int[] nums, int begin, List<List<Integer>> result, Deque<Integer> deque) {
        if (begin == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }

        for (int i=begin; i<nums.length; i++) {
            deque.addLast(nums[i]);
            swap(nums, begin, i);
            getResult(nums, begin + 1, result, deque);
            swap(nums, begin, i);
            deque.removeLast();
        }
    }

    public void swap(int[] nums, int a, int b) {
        if (a != b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    public static void main(String[] args) {
        new Solution().permute(new int[]{1,2,3});
    }
}
