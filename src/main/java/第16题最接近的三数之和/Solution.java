package 第16题最接近的三数之和;

import java.util.Arrays;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/21
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        int res = nums[0] + nums[1] + nums[2];
        int length = Math.abs(res - target);
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tem = nums[i] + nums[k] + nums[j];
                if (Math.abs(tem - target) < length) {
                    length = Math.abs(tem - target);
                    res = tem;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && k < nums.length - 1 && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
                if (tem > target) {
                    k--;
                } else if (tem < target) {
                    j++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
