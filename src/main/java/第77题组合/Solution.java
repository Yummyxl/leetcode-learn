package 第77题组合;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/3
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        combine(n, 1,  k, result, deque);
        return result;
    }

    public void combine(int n, int start,  int k, List<List<Integer>> result, Deque<Integer> deque) {


        if (deque.size() == k) {
            result.add(new ArrayList<>(deque));
            System.out.println(deque);
            return;
        }

        for (int i = start; i <= n; i++) {
            deque.addLast(i);
            combine(n, i + 1,  k, result, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution().combine(5, 2);
    }
}
