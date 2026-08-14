class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Edge case: if the array length equals k, every element is a valid answer.
        if(nums.length == k) {
            return nums;
        }

        // Count how many times each value appears in the array.
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for(int n: nums) {
            count.put(n, count.getOrDefault(n,0)+1);
        }

        // Use a min-heap to keep only the k elements with the highest frequencies.
        // The heap is ordered by frequency, so the least frequent element is at the top.
        Queue<Integer> heap = new PriorityQueue<>(
                (a,b) -> count.get(a) - count.get(b)
        );

        for(int n: count.keySet()) {
            heap.add(n);
            if(heap.size()>k) {
                heap.poll(); // Remove the least frequent element when heap grows beyond k.
            }
        }

        // Extract the k values from the heap and store them in the result array.
        int [] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = heap.poll();
        }
        return ans;

    }
}