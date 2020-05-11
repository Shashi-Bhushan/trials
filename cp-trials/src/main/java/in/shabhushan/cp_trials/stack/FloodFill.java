package in.shabhushan.cp_trials.stack;

import java.util.Stack;

public class FloodFill {
  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];

    if (color != newColor)
      changeColor(image, sr, sc, color, newColor);

    return image;
  }

  /**
   * Custom Stack Solution
   */
  private static void changeColor(int[][] image, int x, int y, int color, int newColor) {
    Stack<Pair> stack = new Stack<>();

    stack.push(new FloodFill.Pair(x, y));

    while (!stack.isEmpty()) {
      Pair p = stack.pop();

      // change color
      image[p.x][p.y] = newColor;

      // check in all directions
      if (isWithinBounds(image, p.x - 1, p.y) && image[p.x - 1][p.y] == color) {
        stack.push(new FloodFill.Pair(p.x - 1, p.y));
      }

      if (isWithinBounds(image, p.x + 1, p.y) && image[p.x + 1][p.y] == color) {
        stack.push(new FloodFill.Pair(p.x + 1, p.y));
      }

      if (isWithinBounds(image, p.x, p.y - 1) && image[p.x][p.y - 1] == color) {
        stack.push(new FloodFill.Pair(p.x, p.y - 1));
      }

      if (isWithinBounds(image, p.x, p.y + 1) && image[p.x][p.y + 1] == color) {
        stack.push(new FloodFill.Pair(p.x, p.y + 1));
      }
    }


  }


  public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];

    if (color != newColor)
      changeColor2(image, sr, sc, color, newColor);

    return image;
  }

  /**
   * Recursive Stack Solution
   */
  private static void changeColor2(int[][] image, int x, int y, int color, int newColor) {
    // change color at (x, y)
    image[x][y] = newColor;
    System.out.println("Color at " + x + ", " + y + " is " + color);

    // check in all directions
    if (isWithinBounds(image, x - 1, y) && image[x - 1][y] == color) {
      changeColor(image, x -1 , y, color, newColor);
    }

    if (isWithinBounds(image, x + 1, y) && image[x + 1][y] == color) {
      changeColor(image, x + 1 , y, color, newColor);
    }

    if (isWithinBounds(image, x, y - 1) && image[x][y - 1] == color) {
      changeColor(image, x, y - 1, color, newColor);
    }

    if (isWithinBounds(image, x, y + 1) && image[x][y + 1] == color) {
      changeColor(image, x, y + 1, color, newColor);
    }

  }

  private static boolean isWithinBounds(int[][] image, int x, int y) {
    return 0 <= x && x < image.length && 0 <= y && y < image[0].length;
  }

  private static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
