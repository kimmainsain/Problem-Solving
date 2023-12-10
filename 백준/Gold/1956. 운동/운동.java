import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int map[][];

	public static void main(String[] args) throws IOException {
		input();
		floyd();
	}

	public static void floyd() {
		int inf = 987654321;
		for (int i = 1; i<= n; i++) {
			for (int j = 1; j<= n; j++) {
				if (i != j && map[i][j] == 0) {
					map[i][j] = inf;
				}
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) {
						continue;
					}
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		int min = 2147483647;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j && map[i][j] != inf && map[j][i] != inf) {
					min = Math.min(min, map[i][j] + map[j][i]);
				}
			}
		}
		if (min == 2147483647) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
		}
	}

}