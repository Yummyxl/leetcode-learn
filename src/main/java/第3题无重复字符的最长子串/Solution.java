package 第3题无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/20
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int size = 0;

        // 滑动窗口的其实位置
        int start;
        int end;

        Map<Character, Integer> index = new HashMap<>();

        for (start=0, end=0; end < s.length(); end++) {
            if (index.containsKey(s.charAt(end))) {
                start = Math.max(start, index.get(s.charAt(end)));
            }
            size = Math.max(size, end - start);
            index.put(s.charAt(end), end + 1); //下一个无重复的位置
        }

        return size;
    }
}
