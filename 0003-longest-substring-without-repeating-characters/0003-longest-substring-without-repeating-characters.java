import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If we've seen the character, move the left pointer
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Update the last seen position of the character
            map.put(currentChar, right);
            
            // Calculate max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}