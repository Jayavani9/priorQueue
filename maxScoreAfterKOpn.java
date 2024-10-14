//https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/

class Solution {
    public long maxKelements(int[] nums, int k) {
        //Tc: O(nlogn) Sc: O(n) 
        long ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int n: nums)
        {
            pq.add(n);
        }  

        while(k > 0)
        {
            int cur = pq.poll();
            ans += cur;
            pq.add((int)Math.ceil(cur/3.0));
            k--;
        } 
        return ans;
    }
}
