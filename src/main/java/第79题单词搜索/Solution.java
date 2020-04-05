package 第79题单词搜索;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/4
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

public class Solution {

    private boolean[][] marked;
    private int m;
    private int n;
    private int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, int index) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)) {
            marked[i][j] = true;
            for (int k=0; k<4; k++) {
                int newX = direction[k][0] + i;
                int newY = direction[k][1] + j;
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if(backtrack(newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        if (x >=0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

}
