import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][m];
		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int wolf = 0;
		int sheep = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != '#' && visited[i][j] == false) {
					visited[i][j] = true;
					Queue<int[]> qu = new ArrayDeque<>();
					int wolfcnt = 0;
					int sheepcnt = 0;
					if (map[i][j] == 'o') {
						sheepcnt++;
					}
					if (map[i][j] == 'v') {
						wolfcnt++;
					}
					qu.add(new int[] { i, j });
					while (qu.size() > 0) {
						int now[] = qu.poll();
						int nowy = now[0];
						int nowx = now[1];
						for (int k = 0; k < 4; k++) {
							int nexty = nowy + dy[k];
							int nextx = nowx + dx[k];
							if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
								continue;
							}
							if (map[nexty][nextx] != '#' && visited[nexty][nextx] == false) {
								qu.add(new int[] { nexty, nextx });
							}
							if (visited[nexty][nextx] == true) {
								continue;
							}
							if (map[nexty][nextx] == 'o') {
								sheepcnt++;
							}
							if (map[nexty][nextx] == 'v') {
								wolfcnt++;
							}
							visited[nexty][nextx] = true;
						}

					}
					if (wolfcnt >= sheepcnt) {
						wolf += wolfcnt;
					} else {
						sheep += sheepcnt;
					}
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}

}