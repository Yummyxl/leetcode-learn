package 第67题二进制求和;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/2
 */

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int ca = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            result.append(sum % 2);
            ca = sum / 2;
        }

        result.append(ca == 0 ? "" : "1");
        return result.reverse().toString();
    }

}
