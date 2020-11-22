package in.shabhushan.algo_trials.clrs.chapter6;

import java.util.*;

public class InplaceHeapSort {

  public static void inplaceHeapSort(int arr[]) {
    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Change in the given input itself.
     * Taking input and printing output is handled automatically.
     */
		/*PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for (int i: arr) {
            queue.offer(i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }*/

    // create min heap from arr
    for (int i = 1; i < arr.length; i++) {
      upHeapify(arr, i);
    }


    for (int i = arr.length - 1; i > 0; i--) {
      swap(arr, i, 0);


      downHeapify(arr, 0, i);
    }
  }

  private static void downHeapify(int[] arr, int index, int length) {
    int parent = index;
    int left = left(index);
    int right = right(index);

    while (left < length) {
      int min = parent;

      if (arr[min] > arr[left]) {
        min = left;
      }

      if (right < length && arr[min] > arr[right]) {
        min = right;
      }

      if (min == parent) {
        // if min element is on parent
        break;
      } else {
        swap(arr, min, parent);

        parent = min;
        left = left(parent);
        right = right(parent);
      }
    }
  }

  private static void upHeapify(int[] arr, int index) {
    while (index != 0 && arr[parent(index)] > arr[index]) {
      swap(arr, parent(index), index);
      index = parent(index);
    }
  }

  private static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  private static int right(int index) {
    return 2 * index + 2;
  }

  private static int left(int index) {
    return 2 * index + 1;
  }

  private static int parent(int index) {
    return (index - 1) / 2;
  }
}
