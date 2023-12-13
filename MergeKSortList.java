23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.


Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

Solution 
  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //O(N log k), where N is the total number of elements across all k lists, and k is the number of lists. 
    //The space complexity is O(k) due to the priority queue.
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list:lists)
        {
            if(list != null) pq.add(list);
        }
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) pq.add(min.next); 
        }
         return res.next;
    }
}
