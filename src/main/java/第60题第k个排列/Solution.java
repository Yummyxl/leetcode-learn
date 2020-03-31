package 第60题第k个排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/31
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder(n);
        int[] jiecheng = new int[n];
        List<Integer> nums = new ArrayList<>();
        jiecheng[0] = 1;
        nums.add(1);
        for (int i=1; i<n; i++) {
            jiecheng[i] = i * jiecheng[i - 1];
            nums.add(i+1);
        }
        k--;
        for (int i=n-1; i>=0; i--) {
            int a = k / jiecheng[i];
            k -= a * jiecheng[i];
            result.append(nums.get(a));
            nums.remove(a);
        }
        return result.toString();
    }
}
