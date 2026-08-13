import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length;i++) {
            int compatibleNumber = target - nums[i];

            if(map.containsKey(compatibleNumber)) {
                return new int [] {map.get(compatibleNumber), i};
            }

            map.put(nums[i], i);
        }
        return new int[] {};
        
    }
}