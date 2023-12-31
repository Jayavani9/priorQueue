215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 
Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Solution:
//Using a min Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Tc: O(nlogk) and Sc: O(k)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:nums)
        {
            pq.add(n);
            if(pq.size()>k) pq.poll();
        }      
            return pq.peek();
        /*
        //Tc: O(nlogn) Sc: O(1)
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k];
        */
    }
}

//Using a max Heap

PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        //Tc: O(Nlogk) Sc: O(K)
        for(int i : nums)
        {
            pq.add(i);
        }
        for(int i = 0 ; i < k-1 ; i++)
        {
            pq.poll();
        }
        return pq.peek();
