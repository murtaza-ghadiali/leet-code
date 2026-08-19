class Solution {
    public int longestConsecutive(int[] nums) {
        // An empty array has no consecutive sequence.
        if(nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        // Store the values for constant-time membership checks.
        for(int num : nums) {
            numSet.add(num);
        }

        int longestSub = 1;

        // Start counting only from the first value in each sequence.
        for(int num: numSet) {
            if(numSet.contains(num-1)) {
                continue;
            } else {
                int currentNum = num;
                int currentSub = 1;
                // Extend the sequence while the next value exists.
                while(numSet.contains(currentNum+1)) {
                    currentNum++;
                    currentSub++;
                }
                longestSub = Math.max(longestSub, currentSub);

            }
        }
        return longestSub;



        
    }
}