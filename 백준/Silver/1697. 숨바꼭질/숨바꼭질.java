import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int visited[];
	static Queue<Integer> qu;

	public static void bfs() {
		while (!qu.isEmpty()) {
			int now = qu.poll();
			if (now == m) {
				System.out.println(visited[now]);
				return;
			}
//			if (now + 1 > 100000 || now * 2 > 100000 || now - 1 < 0) {
//				continue;
//			}
//			n-1 >= 0 n+1 <= 100000 2*n <= 100000
			if (now + 1 <= 100000 && visited[now + 1] == 0) {
				qu.add(now + 1);
				visited[now + 1] = visited[now] + 1;
			}
			if (now - 1 >= 0 && visited[now - 1] == 0) {
				qu.add(now - 1);
				visited[now - 1] = visited[now] + 1;
			}
			if (2 * now <= 100000 && visited[now * 2] == 0) {
				qu.add(now * 2);
				visited[now * 2] = visited[now] + 1;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		qu = new LinkedList<>();
		qu.add(n);
		visited = new int[100001];
		if (n == m) {
			System.out.println(0);
		} else if (n > m) {
			System.out.println(n - m);
		} else {
			bfs();
		}
	}

}
