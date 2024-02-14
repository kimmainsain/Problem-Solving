import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tm = new TreeMap<>();

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				int value = Integer.parseInt(st.nextToken());

				if (s.equals("I")) {
					tm.put(value, tm.getOrDefault(value, 0) + 1);
				} else {
					if (tm.isEmpty()) {
						continue;
					}
					int key = tm.lastKey();
					if (value == -1) {
						key = tm.firstKey();
					}
					int count = tm.get(key);
					if (count == 1) {
						tm.remove(key);
					} else {
						tm.put(key, count - 1);
					}
				}
			}
			if (tm.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
			}
		}
		System.out.println(sb);

	}

}