import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static StringTokenizer st;

  static int n, m, d;
  static int map[][];
  static int map2[][];
  static int archor[];
  static boolean visited[];
  static int answer = 0;
  static int count;
  static int max;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    archor = new int[3];
    visited = new boolean[m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    combination(0, 0);
    System.out.println(answer);
  }
 // instead per function, use combination
  private static void combination (int depth, int start) {
    if (depth == 3) {
      map2 = new int[n][m];
      clone_map();
      shot();
      return;
    }
    for (int i = start; i < m; i++) {
      archor[depth] = i;
      combination(depth + 1, i + 1);
    }
  }

  private static void clone_map() {
    for (int i = 0; i < n; i++) {
      map2[i] = map[i].clone();
    }
  }

  private static void shot() {
    count = 0;
    for (int i = 0; i < n; i++) {
        shoting();
        map_down();
    }
    answer = Math.max(count, answer);
  }

  private static void shoting() {
    Queue<int[]> qu = new ArrayDeque<>();
    for (int i = 0; i < 3; i++) {
      max = Integer.MAX_VALUE;
      int x = n;
      int y = archor[i];
      int target_x = -1;
      int target_y = -1;
      for (int j = n - 1; j >= 0; j--) {
        for (int k = 0; k < m; k++) {
          if (map2[j][k] == 1) {
            int distance = Math.abs(x - j) + Math.abs(y - k);
            if (distance <= d && distance < max) {
              max = distance;
              target_x = j;
              target_y = k;
            } else if (distance <= d && distance == max) {
              if (target_y > k) {
                target_x = j;
                target_y = k;
              }
            }
          }
        }
      }
      if (target_x != -1 && target_y != -1) {
        qu.add(new int [] {target_x, target_y});
      }
    }
    while (!qu.isEmpty()) {
      int now[] = qu.poll();
      int x = now[0];
      int y = now[1];
      if (map2[x][y] == 1) {
        count++;
        map2[x][y] = 0;
      }
    }
  }
  

  private static void map_down() {
    for (int i = n - 1; i > 0; i--) {
      map2[i] = map2[i - 1].clone();
    }
    Arrays.fill(map2[0], 0);
  }
}