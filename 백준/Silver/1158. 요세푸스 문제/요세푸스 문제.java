import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> qu = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			qu.offer(i);
		}
		sb.append("<");
		while (qu.size() != 1) {
			for (int i = 0; i < k - 1; i++) {
				qu.offer(qu.poll());
			}
			sb.append(qu.poll() + ", ");
		}
//		int count = 0;
//		while (qu.size() != 1) {
//			qu.offer(qu.poll());
//			count++;
//			if (count == k - 1) {
//				count = 0;
//				sb.append(qu.poll() + ", ");
//			}
//		}
		sb.append(qu.poll());
		sb.append(">");
		System.out.println(sb);
	}
}