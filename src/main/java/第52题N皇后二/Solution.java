package 第52题N皇后二;

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
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public int totalNQueens(int n) {
        int[] res = new int[1];

        if (n <= 0) {
            return res[0];
        }
        char[][] chars = new char[n][n];
        for (int i=0; i<chars.length; i++) {
            Arrays.fill(chars[i], '.');
        }

        backtrack(chars, 0, res);
        return res[0];
    }

    private void backtrack(char[][] chars, int n, int[] res) {
        if (n == chars.length) {
            res[0]++;
            return;
        }
        int length = chars.length;
        for (int i=0; i<length; i++) {
            if (!isValid(chars, n, i)) {
                continue;
            }
            chars[n][i] = 'Q';
            backtrack(chars, n + 1, res);
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
}
