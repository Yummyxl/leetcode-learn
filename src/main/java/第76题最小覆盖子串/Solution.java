package 第76题最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/3
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    public String minWindow(String s, String t) {

        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }

        int m = s.length();
        int n = t.length();

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> has = new HashMap<>();

        for (int i=0; i<n; i++) {
            char c = t.charAt(i);
            Integer orDefault = needs.getOrDefault(c, 0);
            needs.put(c, orDefault + 1);
        }

        int start = 0;
        int end = 0;

        int targetMatch = needs.size();
        int match = 0;

        int size = s.length() + 1;
        int[] result = new int[2];

        while (end < m) {
            char c = s.charAt(end);
            if (needs.containsKey(c)) {
                Integer orDefault = has.getOrDefault(c, 0);
                has.put(c, orDefault + 1);
                if (has.get(c).equals(needs.get(c))) {
                    match++;
                }
            }
            end++;

            while (match == targetMatch) {
                if (end - start < size) {
                    result[0] = start;
                    result[1] = end;
                    size = end - start;
                }
                char c1 = s.charAt(start);
                if (has.containsKey(c1)) {
                    Integer integer = has.get(c1);
                    has.put(c1, integer - 1);
                    if (has.get(c1) < needs.get(c1)) {
                        match--;
                    }
                }
                start++;
            }
        }

        return s.substring(result[0], result[1]);
    }
}
