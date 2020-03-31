package 第57题插入区间;

import java.util.LinkedList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/30
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        if (newInterval.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> result = new LinkedList<>();
        int index = 0;
        int n = intervals.length;

        while (index < n && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }

        int[] temp = new int[]{newInterval[0], newInterval[1]};

        while (index < n && temp[1] >= intervals[index][0]) {
            temp[0] = Math.min(intervals[index][0], temp[0]);
            temp[1] = Math.max(intervals[index][1], temp[1]);
            index++;
        }
        result.add(temp);

        while (index < n) {
            result.add(intervals[index]);
            index++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}
