import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int sq = 1;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			dq.add(i);
		}
		while (dq.size() >= k) {
			dq.addLast(dq.pollFirst());
			for (int i = 1; i < k; i++) {
				dq.poll();
			}
		}
		System.out.println(dq.poll());
	}

}