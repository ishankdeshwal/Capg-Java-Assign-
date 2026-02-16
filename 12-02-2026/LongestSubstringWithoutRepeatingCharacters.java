package Capgg;
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        while (end < n) {
            char ch = s.charAt(end);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                end++;
            } else {
                char startChar = s.charAt(start);
                map.remove(startChar);
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}

