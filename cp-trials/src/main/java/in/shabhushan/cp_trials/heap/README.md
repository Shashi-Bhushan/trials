## Max/Min Heap

```
PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // to store the biggest numbers
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // to store the smallest numbers

minHeap.offer(n); // adds the element to heap
minHeap.remove(); // removes the top most element

minHeap.poll(); // queries the top most element
```


