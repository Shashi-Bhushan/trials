## Find top 3 maximum numbers

One way is to sort and Fetch last 3 elements.
Problem here is you are doing extra work of finding all top elements not just the top 1 or 2 or 3. Hence, it's **O(N log(N))**

In order to solve it in one pass, solve it like you would solve the max 1 problem with a little twist.
Similar for min as well
```
    // placeholders for max 3 variables, max1 is top, max2 is second highest and max3 is third highest
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    // min1 is least, min2 is second least
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int num: nums) {
      // if you found a bigger number, shift numbers accordingly
      if (num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max3 = max2;
        max2 = num;
      } else if (num > max3) {
        max3 = num;
      }

      if (num < min1) {
        min2 = min1;
        min1 = num;
      } else if (num < min2) {
        min2 = num;
      }
    }
```

Thing to note here is you check for biggest number first, then second biggest number, then third biggest number etc.
You already know how many top max numbers to search for, Then use this. Otherwise sort and fetch.

Check these problems for practice, [Maximum product 2](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/) and [Maximum product 3](https://leetcode.com/problems/maximum-product-of-three-numbers/)
