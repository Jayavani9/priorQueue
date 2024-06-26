// https://www.geeksforgeeks.org/problems/k-largest-elements4206/1?page=1&company%5B%5D=Amazon&category%5B%5D=Heap&sortBy=


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        //Tc: O(nlogn) Sc: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int[] ans = new int[k];
        for(int i = 0; i < arr.length; i++)
        {
            pq.add(arr[i]);
        }
        
        for(int i = 0; i < k; i++)
        {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
