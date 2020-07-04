package in.shabhushan.cp_trials.dynamic_programming;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/filling-bookcase-shelves/submissions/
 */
class FillingBookShelves {
  /**
   * For each book, we first put it on a new level of the shelf which is the least preferable way to do,
   * in this case the current height will be dp[i - 1] + books[i- 1][1]. Then, we check back previously put books
   * and see if it is possible to get better arrangement(less height) by putting the current book together
   * with the books at previous level of the shelf. If better arrangement is possible, dp[i] will be updated.
   * The inner loop will terminate once accumulated width exceeds the bookshelf's width.
   */
  public int minHeightShelvesDP(int[][] books, int shelfWidth) {
    //return helper(books, shelfWidth, 0);

    int n = books.length;
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + books[i - 1][1];

      int currentWidth = books[i - 1][0];
      int currentHeight = books[i - 1][1];

      for (int j = i - 1; j > 0 && currentWidth + books[j - 1][0] <= shelfWidth; j--) {
        currentHeight = Math.max(currentHeight, books[j - 1][1]);
        currentWidth += books[j - 1][0];

        dp[i] = Math.min(dp[i], currentHeight + dp[j - 1]);
      }
    }

    return dp[n];
  }

  /**
   * Base condition: if there is only one book, than the answer is the height of that book itself
   * Otherwise, try to determine the result for start=0 to end=n-1
   * add the books one by one to the current shelf, provided the shelf_width allows, and keep track of maxHeight of that current shelf
   * call the recursion function to determine the minimum height for i+1 to end and compare it against the answer, keep tracking the minimum height for the overall solution of
   * given start and end like this.
   */
  public int minHeightShelves(int[][] books, int shelf_width) {
    return helper(books, shelf_width, 0);
  }
  
  private int helper(int[][] books, int shelfWidth, int start) {
    if (start == books.length) return 0;

    int currentWidth = 0;
    int currentHeight = 0;
    
    int ret = 1_000_000;
    
    for (int i = start; i < books.length; i++) {
      currentWidth += books[i][0];
      currentHeight = Math.max(currentHeight, books[i][1]);
      
      if (currentWidth > shelfWidth)
        break;
      
      ret = Math.min(ret, helper(books, shelfWidth, i + 1) + currentHeight);
    }
    
    System.out.println("start " + start + " ret " + ret + " " + currentHeight);
    return ret;
  }
}
