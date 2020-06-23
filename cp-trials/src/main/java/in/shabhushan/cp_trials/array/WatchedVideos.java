package in.shabhushan.cp_trials.array;

import java.util.*;

class WatchedVideos {
  public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
    Queue<Integer> queue = new LinkedList<>();

    int depth = 1;
    boolean[] visited = new boolean[friends.length];
    visited[id] = true;

    for(int friend : friends[id]){
        visited[friend] = true;
        queue.add(friend);
    }

    while(depth < level){
      int len = queue.size();

      for(int i = 0; i < len; i++){
          int friendId = queue.remove();
          for(int friend : friends[friendId]){
              if(!visited[friend]){
                  visited[friend] = true;
                  queue.add(friend);
              }
          }
      }
      depth++;
    }

    Map<String, Integer> videos = new HashMap<>();

    while (!queue.isEmpty()) {
      int friend = queue.remove();

      for (String video: watchedVideos.get(friend)) {
        videos.put(video, videos.getOrDefault(video, 0) + 1);
      }
    }

    List<String> ans = new ArrayList<>(videos.keySet());

    Collections.sort(ans, (a, b) -> {
      int x = videos.get(a);
      int y = videos.get(b);

      if (x != y)
        return x - y;
      else
        return a.compareTo(b);
    });

    return ans;
  }
}
