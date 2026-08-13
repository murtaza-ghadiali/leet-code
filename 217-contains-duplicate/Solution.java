import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Use a HashSet to remember all numbers we have seen so far.
        // A set does not allow duplicates, so checking membership is efficient.
        Set<Integer> seenNumbers = new HashSet<>();

        // Traverse the array once.
        for (int num : nums) {
            // If this number has already been seen, it is a duplicate.
            if (seenNumbers.contains(num)) {
                return true;
            }

            // Otherwise, store it in the set and continue.
            seenNumbers.add(num);
        }

        // If no duplicate is found after checking all elements, return false.
        return false;
    }
}