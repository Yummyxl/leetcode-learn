package 第32题最长有效括号;

import java.util.Stack;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/25
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    // 动态规划
    public int longestValidParentheses1(String s) {

        if(s == null || s.length() <= 1) {
            return 0;
        }
        int[] result = new int[s.length()];
        int max = 0;

        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    result[i] = (i >= 2 ? result[i - 2] : 0) + 2;
                } else if (i - result[i - 1] - 1 >= 0 && s.charAt(i - result[i - 1] - 1) == '(') {
                    result[i] = (i - result[i - 1] - 2 >= 0 ? result[i - result[i - 1] - 2] : 0) + result[i - 1] + 2;
                }
            }
            max = Math.max(result[i], max);
        }
        return max;
    }

    public int longestValidParentheses2(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()()"));
    }
}