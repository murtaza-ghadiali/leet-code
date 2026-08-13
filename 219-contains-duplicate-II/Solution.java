class Solution {
    /**
     * Determines if there are two distinct indices i and j in the array such that
     * nums[i] == nums[j] and abs(i - j) <= k.
     * 
     * Approach: Sliding Window with HashSet
     * - Maintain a set of at most k elements
     * - For each element, check if it already exists in the set
     * - If it exists, we found a duplicate within distance k
     * - If the window size exceeds k, remove the leftmost element
     * 
     * @param nums The input array
     * @param k The maximum distance between indices
     * @return true if duplicate exists within distance k, false otherwise
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Use a set to maintain a sliding window of at most k elements
        Set<Integer> set = new HashSet<Integer>();

        // Iterate through each element in the array
        for(int i = 0; i < nums.length; i++) {
            
            // If the current element already exists in the set,
            // we found a duplicate within distance k
            if(set.contains(nums[i])) {
                return true;
            }
            
            // Add the current element to the set
            set.add(nums[i]);

            // If the set size exceeds k, remove the leftmost element
            // to maintain the window size of at most k
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        // No duplicate found within distance k
        return false;
    }
}