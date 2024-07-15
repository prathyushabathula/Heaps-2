//Time Complexity : O(n) + n log k
//Space Complexity : O(1)
//Did you face any problem while running this code on leetcode : No
//Did this problem run successfully on leetcode : Yes
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()) {
            pq.add(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int idx = 0;
        while(!pq.isEmpty()) {
            int ele = pq.poll();
            res[idx++] = ele;
        }
        return res;
    }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did you face any problem while running this code on leetcode : No
//Did this problem run successfully on leetcode : Yes

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int min = nums.length;
        int max = 0;
        HashMap<Integer, List<Integer>> bucketsMap = new HashMap<>();
        for(int key : map.keySet()) {
            int freq = map.get(key);
            bucketsMap.putIfAbsent(freq, new ArrayList<>());
            bucketsMap.get(freq).add(key);
            min = Math.min(min, freq);
            max = Math.max(max, freq);
        }

        int idx = 0;
        for(int i = max; i >= min && idx < k; i--) {
            if(!bucketsMap.containsKey(i)) continue;
            List<Integer> li = bucketsMap.get(i);
            for(int j = 0; j < li.size(); j++) {
                res[idx++] = li.get(j);
            }
            
        }
        return res;
    }
}