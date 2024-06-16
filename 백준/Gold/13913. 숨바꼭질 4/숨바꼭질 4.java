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
	static int visited[] = new int[100001];
	static int answer[] = new int[100001];

	public static void bfs() {
		Queue<Integer> qu = new ArrayDeque<>();
		qu.add(n);
		while (!qu.isEmpty()) {
			int now = qu.poll();
			if (now == m) {
				return;
			}
			if (now + 1 <= 100000 && visited[now + 1] == 0) {
				visited[now + 1] = visited[now] + 1;
				answer[now + 1] = now;
				qu.add(now + 1);
			}
			if (now - 1 >= 0 && visited[now - 1] == 0) {
				qu.add(now - 1);
				visited[now - 1] = visited[now] + 1;
				answer[now - 1] = now;
			}
			if (2 * now <= 100000 && visited[now * 2] == 0) {
				qu.add(now * 2);
				visited[now * 2] = visited[now] + 1;
				answer[now * 2] = now;
			}
			if (visited[m] != 0) {
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(visited[m]);
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int idx = m;
		while (idx != n) {
			dq.add(idx);
			idx = answer[idx];
		}
		dq.add(idx);
		while (!dq.isEmpty()) {
			sb.append(dq.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
