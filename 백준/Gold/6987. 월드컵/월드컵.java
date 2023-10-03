import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int me[];
	static int vers[];
	static int win[], lose[], draw[];
	static boolean flag;

	public static void dfs(int depth) {
		if (depth == 15) {
			flag = true;
			return;
		}
		int a = me[depth];
		int b = vers[depth];
		if (win[a] > 0 && lose[b] > 0) {
			win[a]--;
			lose[b]--;
			dfs(depth + 1);
			win[a]++;
			lose[b]++;
		}
		if (draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			dfs(depth + 1);
			draw[a]++;
			draw[b]++;
		}
		if (lose[a] > 0 && win[b] > 0) {
			lose[a]--;
			win[b]--;
			dfs(depth + 1);
			lose[a]++;
			win[b]++;
		}
	}

	public static void main(String[] args) throws IOException {
		int count = 0;
		me = new int[15];
		vers = new int[15];
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				me[count] = i;
				vers[count] = j;
				count++;
			}
		}
		//		System.out.println(Arrays.toString(me));
		//		System.out.println(Arrays.toString(vers));
		for (int tc = 0; tc < 4; tc++) {
			flag = false;
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			int sum = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				int w, d, l;
				w = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				win[i] = w;
				draw[i] = d;
				lose[i] = l;
				sum = sum + w + d + l;
			}
			if (sum != 30) {
				sb.append(0).append(" ");
				continue;
			}
			//			System.out.println(Arrays.toString(win));
			//			System.out.println(Arrays.toString(draw));
			//			System.out.println(Arrays.toString(lose));
			dfs(0);
			if (flag) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);

	}

}
