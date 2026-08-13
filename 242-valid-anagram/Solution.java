class Solution {
    // Check whether two strings are anagrams by counting characters.
    // If the strings have different lengths, they cannot be anagrams.
    // For each character in s, increment its count; for each character in t, decrement it.
    // If all counts return to zero, the strings contain the same letters in the same quantities.
    public boolean isAnagram(String s, String t) {

        // If the strings are different lengths, they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to count each letter from 'a' to 'z'.
        int[] count = new int[26];

        // Loop through both strings at the same time.
        for (int i = 0; i < s.length(); i++) {
            // Increase the count for the current character in s.
            count[s.charAt(i) - 'a']++;
            // Decrease the count for the current character in t.
            count[t.charAt(i) - 'a']--;
        }

        // Check whether any letter count is not zero.
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams.
        return true;
    }
}