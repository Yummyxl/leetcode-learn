package 第17题电话号码的字母组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/21
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    //定义每个数字对应的字符
    String[] numbers = new String[] {"","","abc","def",
            "ghi","jkl","mno","pqrs","tuv","wxyz"};
    StringBuffer sb = new StringBuffer();


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        combine(digits, 0, result);
        return result;
    }

    public void combine(String digits, int n, List<String> result) {
        if (n == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i=0; i<numbers[digits.charAt(n) - '0'].length(); i++) {
            sb.append(numbers[digits.charAt(n) - '0'].charAt(i));
            combine(digits, n+1, result);
            sb.deleteCharAt(n);
        }
    }

    // 广度优先算法
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] numbers = new String[] {"","","abc","def",
                "ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.offer("");
        for (int i=0; i<digits.length(); i++) {
            String temp = numbers[digits.charAt(i) - '0'];
            int size = result.isEmpty() ? temp.length() : result.size() * temp.length();
            while (result.size() < size) {
                String pre = result.size() == 0 ? "" : result.poll();
                for (int j=0; j<temp.length(); j++) {
                    result.offer(pre + temp.charAt(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations1("23"));
    }
}
