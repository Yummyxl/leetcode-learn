package 第51题N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/29
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    /**
     * 思考路径：
     * 1. 定位这是backtrack problem
     * 2. 思考决策树的构建过程
     * 3. 思考回溯的模板
     */
    // 决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new LinkedList<>();

        if (n <= 0) {
            return result;
        }
        char[][] chars = new char[n][n];
        for (int i=0; i<chars.length; i++) {
            Arrays.fill(chars[i], '.');
        }

        backtrack(chars, 0, result);
        return result;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     */
    private void backtrack(char[][] chars, int n, List<List<String>> result) {
        if (n == chars.length) {
            result.add(charToString(chars));
            return;
        }
        int length = chars.length;
        for (int i=0; i<length; i++) {
            if (!isValid(chars, n, i)) {
                continue;
            }
            chars[n][i] = 'Q';
            backtrack(chars, n + 1, result);
            chars[n][i] = '.';
        }
    }

    private boolean isValid(char[][] chars, int m, int n) {
        for (int i=0; i<chars.length; i++) {
            if (chars[m][i] == 'Q' || chars[i][n] == 'Q') {
                return false;
            }
        }
        for (int i=m, j = n; i>=0 && j>=0; i--,j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        for (int i=m, j=n; i>=0 && j<chars.length; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
