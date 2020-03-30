package 第22题括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/22
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs("", 0, 0, n, result);
        return result;
    }

    private void dfs(String str, int left, int right, int n, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (left < right) {
            return;
        }


        if (left < n) {
            dfs(str + "(", left + 1, right, n, result);
        }

        if (right < n) {
            dfs(str + ")", left, right + 1, n, result);

        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
