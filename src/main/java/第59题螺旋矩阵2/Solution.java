package 第59题螺旋矩阵2;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/31
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public int[][] generateMatrix(int n) {

        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] result = new int[n][n];

        int u = 0;
        int d = n - 1;
        int l = 0;
        int r = n - 1;

        int index = 1;
        while (true) {
            for (int i=l; i<=r; i++) {
                result[u][i] = index++;
            }
            if (++u > d) {
                break;
            }
            for (int i=u; i<=d; i++) {
                result[i][r] = index++;
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i>= l; i--) {
                result[d][i] = index++;
            }
            if (--d < u) {
                break;
            }
            for (int i=d; i>=u; i--) {
                result[i][l] = index++;
            }
            if (++l > r) {
                break;
            }
        }
        return result;
    }
}
