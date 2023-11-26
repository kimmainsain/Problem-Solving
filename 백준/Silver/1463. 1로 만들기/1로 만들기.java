import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long n = Long.parseLong(br.readLine());
		Map<Long, Boolean> hm = new HashMap<>();
		Queue<long[]> qu = new ArrayDeque<>();
		qu.add(new long[] { n, 0 });
		while (!qu.isEmpty()) {
			long now[] = qu.poll();
			if (now[0] == 1) {
				System.out.println(now[1]);
				break;
			}
			if (now[0] % 3 == 0 && !hm.containsKey(now[0] / 3)) {
				qu.add(new long[] { now[0] / 3, now[1] + 1 });
				hm.put(now[0] / 3, true);
			}
			if (now[0] % 2 == 0 && !hm.containsKey(now[0] / 2)) {
				qu.add(new long[] { now[0] / 2, now[1] + 1 });
				hm.put(now[0] / 2, true);
			}
			if (!hm.containsKey(now[0] - 1)) {
				qu.add(new long[] { now[0] - 1, now[1] + 1 });
				hm.put(now[0] - 1, true);
			}
		}
	}
}