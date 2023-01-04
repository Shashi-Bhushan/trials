## Amortized Time complexity of Insertion


**Q.** Why is amortized time complexity of addition in Array List i.e. Dynamic Array O(1) ?

**Ans.** Suppose that the load factor of Array List is 1. This means we will double the size when addition of new element will exceed the size of the array.

- The array list will resize when the number of elements reaches a power of two. 
- After n elements inserted, we've resized at sizes 1, 2, 4, ... , n. 
- This also means we've copied over into the newly resized array 1, 2, 4, ... , n elements when doubling  

The sum of these operations will be  
1 + 2 + 4 + 8 + ... + n/4 + n/2 + n  
= n(.. + 1/4 + 1/2 + 1)
= n * 2

### Example

1st increase = 1 element copied  
2nd increase = 2 element copied  
3rd increase = 4 element copied  
4th increase = 8 element copied  
5th increase = 16 element copied  

So, the cumulative cost of each doubling step is  
1 + 2 + 4 + 8 + .... + 2^k  
= 2^(k + 1) - 1 = 31

