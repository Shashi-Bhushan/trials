### Bin Packing

Given n items of different weights and bins each of capacity c, assign each item to a bin such that number of total used bins is minimized.

Eg.
 weights 4, 8, 1, 4, 2, 1
 capacity = 10

#### Lower Bound

ceil((sum of weight) / (capacity of bin))

In the example above, minimum number of bins required is ceil(20/10) = 2.

#### Online Algorithms

Items keep coming and you don't know the next item before it arrives.

1. **Next Fit**
Assign the current item in the current bin as long as it fits. If it does not, create a new bin and assign the item there.

Next fit uses atmost 2 * Optimal bins.
Consider a scenario where two bins are used. The sum of items in both bins must be greater than the capacity of one bin. At the same time, the sum must be less than 2 * bin capacity.
Thus, it gives a maximum of 2 * optimal solution as answer.

Can be improved by scanning all the previous bins before creating a new bin.

