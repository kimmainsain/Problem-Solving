
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int m;
	static int k;
	static char map[][];
	static boolean visited[][];
	static int dx[] = new int[] { 1, 0, -1, 0 };
	static int dy[] = new int[] { 0, 1, 0, -1 };
	static int count = 0;

	public static void dfs(int y, int x) {
		if (map[y][x] - '0' == k) {
			if (y == n - 1 && x == 0) {
				count++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			if (nextx > m - 1 || nextx < 0 || nexty > n - 1 || nexty < 0) {
				continue;
			}
			if (visited[nexty][nextx] || map[nexty][nextx] == 'T') {
				continue;
			}
			visited[nexty][nextx] = true;
			map[nexty][nextx] = (char) (map[y][x] + 1);
			dfs(nexty, nextx);
			visited[nexty][nextx] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		map[0][m - 1] = '1';
		visited[0][m - 1] = true;
		dfs(0, m - 1);
		System.out.println(count);
	}
}
