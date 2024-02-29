import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		if (gcd(a,b) != 1) {
			System.out.println("No");
			return;
		}
		sb.append("Yes").append("\n");
		int c = 1;
		for (int i = 0; i < n; i++) {
			sb.append(a + " ");
			a += b;
			sb.append(a + "\n");
			a += b;
		}
		System.out.println(sb);
	}

	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
