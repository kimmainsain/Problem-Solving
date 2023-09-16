import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int now = -1;
		int count = 1;
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (now != -1) {
				if (now != t) {
					count++;
				} else {
					list.add(count);
					count = 1;
				}
			}
			now = t;
		}
		list.add(count);
		int max = -2147483648;
		for (int i = 0; i < list.size() - 2; i++) {
			max = Math.max(max, list.get(i) + list.get(i + 1) + list.get(i + 2));
		}
		if (max == -2147483648) {
			max = 0;
			for (int i = 0; i < list.size(); i++) {
				max += list.get(i);
			}
		}
		System.out.println(max);
	}

}