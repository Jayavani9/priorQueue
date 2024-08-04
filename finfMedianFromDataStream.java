//https://leetcode.com/problems/find-median-from-data-stream/description/

//Using 2 PriorityQueue's

class MedianFinder {

    private PriorityQueue<Integer> maxHeap; 
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
         if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
         if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


//TLE Solution 
//Using an Array List
class MedianFinder {
      private List<Integer> arr;

    public MedianFinder() {
         arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
        Collections.sort(arr);
    }
    
    public double findMedian() {
        int n = arr.size();
        if(n%2 != 0) return arr.get(n/2);
        else return (arr.get(n / 2 - 1) + arr.get(n / 2)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
