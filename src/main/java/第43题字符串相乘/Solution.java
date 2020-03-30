package 第43题字符串相乘;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/28
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public String multiply(String num1, String num2) {

        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int i1 = num1.charAt(i) - '0';
                int i2 = num2.charAt(j) - '0';
                result[i + j + 1] += i1 * i2;
            }
        }

        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        StringBuilder re = new StringBuilder();
        boolean flag = true;
        for (int i=0; i<result.length; i++) {
            if (flag && result[i] == 0) {
                continue;
            } else {
                flag = false;
                re.append(result[i]);
            }
        }
        return re.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("99", "99"));
    }
}
