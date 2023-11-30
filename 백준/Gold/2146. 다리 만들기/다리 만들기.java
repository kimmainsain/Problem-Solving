import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int map[][];
	static boolean visited[][];
	static int n, count, min;

	static int dx[] = new int[] { 1, 0, -1, 0 };
	static int dy[] = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		input();
		islandmake();
		find();
		System.out.println(min);
	}

	public static void islandmake() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					islandbfs(i, j);
					count++;
				}
			}
		}
	}

	public static void islandbfs(int y, int x) {
		Queue<int[]> qu = new ArrayDeque<>();
		visited[y][x] = true;
		map[y][x] = count;
		qu.add(new int[] { y, x });
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) {
					continue;
				}
				if (visited[nexty][nextx] || map[nexty][nextx] == 0) {
					continue;
				}
				visited[nexty][nextx] = true;
				map[nexty][nextx] = count;
				qu.add(new int[] { nexty, nextx });
			}
		}
	}

	public static void find() {
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					bridgebfs(i, j);
				}
			}
		}
	}

	public static void bridgebfs(int y, int x) {
		Queue<int[]> qu = new ArrayDeque<>();
		int value = map[y][x];
		boolean visited2[][] = new boolean [n][n];
		visited2[y][x] = true;
		qu.add(new int[] { y, x, 0 });
		while (!qu.isEmpty()) {
			int size = qu.size();
			while (size-- > 0) {
				int now[] = qu.poll();
				for (int i = 0; i < 4; i++) {
					int nexty = now[0] + dy[i];
					int nextx = now[1] + dx[i];
					if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) {
						continue;
					}
					if (visited2[nexty][nextx] || map[nexty][nextx] == value) {
						continue;
					}
					if (map[nexty][nextx] != 0) {
						min = Math.min(min, now[2]);
						continue;
					}
					visited2[nexty][nextx] = true;
					qu.add(new int[] { nexty, nextx, now[2] + 1});
				}
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		count = 1;
		min = 2147483647;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}