package top.fuyuaaa.study.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Solution409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterIntegerMap.containsKey(c)) {
                Integer num = characterIntegerMap.get(c);
                if (num == 1) {
                    characterIntegerMap.put(c, 0);
                    maxLength = maxLength + 2;
                } if (num == 0) {
                    characterIntegerMap.put(c , 1);
                }
            } else {
                characterIntegerMap.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            if (entry.getValue() == 1) {
                maxLength++;
                break;
            }
        }
        return maxLength;
    }


    /**
     * 官方题解
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution409 solution409 = new Solution409();
        System.out.println(solution409.longestPalindrome("abccccdd"));
    }
}
