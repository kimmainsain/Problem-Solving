import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, end;
	static int v1, v2;
	static boolean flag = false;

	static ArrayList<int[]>[] list;
	static boolean visited[];
	static int dist[];

	public static void main(String[] args) throws IOException {
		int answer = 0;
		input();
		if (flag) {
			System.out.println(-1);
			return;
		}
		dijkstra(1, v1);
		answer += dist[v1];
		dijkstra(v1, v2);
		answer += dist[v2];
		dijkstra(v2, n);
		answer += dist[n];
		int min = answer;
		answer = 0;
		dijkstra(1, v2);
		answer += dist[v2];
		dijkstra(v2, v1);
		answer += dist[v1];
		dijkstra(v1, n);
		answer += dist[n];
		System.out.println(Math.min(answer, min));
	}

	public static void dijkstra(int start, int dest) {
		reset();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { start, 0 });
		dist[start] = 0;
		while (!pq.isEmpty()) {
			int now[] = pq.poll();
			if (list[now[0]] == null) {
				continue;
			}
			if (now[0] == dest) {
				return;
			}
			if (!visited[now[0]]) {
				visited[now[0]] = true;
				for (int i = 0; i < list[now[0]].size(); i++) {
					int next[] = list[now[0]].get(i);
					if (dist[next[0]] > next[1] + now[1]) {
						dist[next[0]] = next[1] + now[1];
						pq.add(new int[] { next[0], dist[next[0]] });
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		reset();
		for (int i = 0; i < end; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (list[a] == null) {
				list[a] = new ArrayList<>();
			}
			if (list[b] == null) {
				list[b] = new ArrayList<>();
			}
			list[a].add(new int[] { b, d });
			list[b].add(new int[] { a, d });
		}
		if (list[n] == null) {
			flag = true;
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
	}

	public static void reset() {
		for (int i = 0; i <= n; i++) {
			dist[i] = 2147483647;
			visited[i] = false;
		}
	}
}