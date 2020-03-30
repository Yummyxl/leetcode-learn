package 第54题螺旋矩阵;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/29
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while (true) {
            for (int i=l; i<=r; i++) {
                result.add(matrix[u][i]);
            }
            if (++u > d) {
                break;
            }
            for (int i=u; i<=d; i++) {
                result.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i=r; i>=l; i--) {
                result.add(matrix[d][i]);
            }
            if (--d < u) {
                break;
            }
            for (int i=d; i>=u; i--) {
                result.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }

        return result;
    }
}
