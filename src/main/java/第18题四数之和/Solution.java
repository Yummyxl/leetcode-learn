package 第18题四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/21
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j<nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> tem = new ArrayList<>();
                        tem.add(nums[i]);
                        tem.add(nums[j]);
                        tem.add(nums[k]);
                        tem.add(nums[l]);
                        result.add(tem);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                        while (k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else {
                        k++;
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
    }

}
