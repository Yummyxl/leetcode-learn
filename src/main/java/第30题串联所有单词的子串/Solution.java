package 第30题串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/23
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }

        Map<String, Integer> allow = new HashMap<>();
        int wordCount = words.length;
        int wordLength = words[0].length();

        for (int i=0; i<wordCount; i++) {
            Integer orDefault = allow.getOrDefault(words[i], 0);
            allow.put(words[i], orDefault + 1);
        }

        for (int i=0; i<wordLength; i++) {
            Map<String, Integer> has = new HashMap<>();
            int j = i;
            int num = 0;
            while (j + wordCount * wordLength <= s.length()) {
                while (num < wordCount) {
                    String substring = s.substring(j + num * wordLength, j + (num + 1) * wordLength);
                    if (!allow.containsKey(substring)) {
                        has.clear();
                        j += (num + 1) * wordLength;
                        num = 0;
                        break;
                    }
                    Integer orDefault = has.getOrDefault(substring, 0) + 1;
                    has.put(substring, orDefault);
                    num++;

                    if (has.get(substring) > allow.get(substring)) {
                        // 多了
                        while (has.get(substring) > allow.get(substring)) {
                            String substring1 = s.substring(j, j + wordLength);
                            has.put(substring1, has.get(substring1) - 1);
                            j += wordLength;
                            num--;
                        }
                        break;
                    }
                }

                if (num == wordCount) {
                    result.add(j);
                    String substring1 = s.substring(j, j + wordLength);
                    has.put(substring1, has.get(substring1) - 1);
                    j += wordLength;
                    num--;
                }
            }
        }
        return result;
    }


    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }
        Map<String, Integer> allow = new HashMap<>();
        int wordsSize = words.length;
        int length = s.length();
        int wordLength = words[0].length();

        for (int i=0; i<wordsSize; i++) {
            Integer orDefault = allow.getOrDefault(words[i], 0);
            allow.put(words[i], orDefault + 1);
        }

        for (int i = 0; i < length - wordLength * wordsSize + 1; i++) {
            Map<String, Integer> has = new HashMap<>();
            int cur = 0;
            while (cur < wordsSize) {
                String substring = s.substring(i + cur * wordLength, i + (cur + 1) * wordLength);
                if (allow.containsKey(substring)) {
                    Integer orDefault = has.getOrDefault(substring, 0);
                    has.put(substring, orDefault + 1);
                    if (has.get(substring) > allow.get(substring)) {
                        break;
                    }
                } else {
                    break;
                }
                cur++;
            }
            if (cur == wordsSize) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
}
