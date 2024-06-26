//https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1?page=1&company%5B%5D=Amazon&category%5B%5D=Heap&sortBy=

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        //Tc: O(nlogn)  Sc: O(n)
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long cnt = 0;
        for(int i = 0; i < n; i++)
        {
            pq.add(arr[i]);
        }
        
        while(pq.size() > 1)
        {
            long p1 = pq.poll();
            long p2 = pq.poll();
            pq.add(p1+p2);
            cnt += p1+p2;
        }
        return cnt;
    }
}
