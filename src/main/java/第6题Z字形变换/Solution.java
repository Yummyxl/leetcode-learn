package 第6题Z字形变换;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/20
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

public class Solution {

    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        int dire = 1; // 转换方向
        int index = 0; // 放入哪个stringbuilder中

        StringBuilder[] tems = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            tems[i] = new StringBuilder();
        }

        for (int i=0; i<s.length(); i++) {
            tems[index].append(s.charAt(i));
            index += dire;
            if (index == 0 || index == numRows -1) {
                dire = -dire;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder tem : tems) {
            result.append(tem);
        }
        return result.toString();
    }

}
