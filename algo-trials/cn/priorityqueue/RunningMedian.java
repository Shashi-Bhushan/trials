
import java.util.*;
import java.util.PriorityQueue;


/**
 * You are given a stream of N integers. 
 * For every i-th integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
 */
public class RunningMedian {

	public static void findMedian(int arr[])  {
        
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
        // maxHeap
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        
        // minHeap
        PriorityQueue<Integer> upperHalf = new PriorityQueue<>();
        
        int median;
        for (int size = 1; size <= arr.length; size++) {
            if(!lowerHalf.isEmpty() && lowerHalf.peek() > arr[size-1]) { 
                lowerHalf.add(arr[size - 1]); 
                
                if(lowerHalf.size() > upperHalf.size() + 1) {
                    upperHalf.add(lowerHalf.poll()); 
                } 
            } else { 
                upperHalf.add(arr[size - 1]); 
                
                // upper half has 1 element more than lower half
                if(upperHalf.size() - 1 > lowerHalf.size()) { 
                    // remove from upper, add to lower
                    lowerHalf.add(upperHalf.poll()); 
                } 
            }
            
            if(size % 2 == 1) { // odd size, only one elemnt is median
                if(upperHalf.size() > lowerHalf.size()) {
                    median = upperHalf.peek(); 
                } else { 
                    median = lowerHalf.peek(); 
                } 
            } else { 
                median = (lowerHalf.peek() + upperHalf.peek()) / 2; 
            }
            
            System.out.print(median + " ");
        }
        
    }


}
