package 第5题最长回文子串;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/20
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */

public class Solution {

    // 马拉车算法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String tem = "$#";
        for (int i=0; i<s.length(); i++) {
            tem = tem + s.charAt(i) + "#";
        }

        int mi = 0; // 到右边最大位置对应到中心位置
        int right = 0; // 到右边最大位置

        int maxLength = 0; // 最大半径
        int maxPoint = 0; // 最大半径中心位置

        int[] length = new int[tem.length()];

        for (int i=1; i<tem.length(); i++) {
            length[i] = right > i ? Math.min(length[2 * mi - i], right - i) : 1;
            while ((i + length[i]) < tem.length() && (i - length[i]) >=0 && tem.charAt(i + length[i]) == tem.charAt(i - length[i])) {
                length[i]++;
            }
            if (i + length[i] > right) {
                mi = i;
                right = i + length[i];
            }
            if (length[i] > maxLength) {
                maxLength = length[i];
                maxPoint = i;
            }
        }
        int start = (maxPoint - maxLength) / 2;
        int end = start + maxLength - 1;
        return s.substring(start, end);
    }


    // 解题思路就是 [n, m) 是不是取决于 [n-1, m-1) 和 s.charAt(n) == s.charAt(m-1)
    public String longestPalindrome0(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String max = "";
        boolean[][] result = new boolean[n+1][n+1];

        for (int j=0; j<n+1; j++) {
            for (int i=j; i>=0; i--) {
                if (i == j || (i + 1 == j)) {
                    result[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j-1) && result[i+1][j-1]) {
                    result[i][j] = true;
                }

                if (i < j && result[i][j] && (j - i) > max.length()) {
                    max = s.substring(i, j);
                }
            }
        }
        return max;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String max = "";
        for(int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                String sub = s.substring(i, j+1);
                if (sub.equals(new StringBuilder(sub).reverse().toString()) && j + 1 - i > max.length()) {
                    max = sub;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abcdcbaaaa"));
    }

}
