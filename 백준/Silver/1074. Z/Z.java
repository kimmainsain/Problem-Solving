import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int y;
	static int x;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		n = (int) Math.pow(2, n);
		int answer = 0;
		while (true) {
			if (n == 1) {
				break;
			}
//			System.out.printf("%d %d %d %d", answer, x, y, n);
			if (n / 2 <= y && n / 2 <= x) {
				answer = answer + n * n - n * n / 4;
				y -= n / 2;
				x -= n / 2;
			} else if (n / 2 <= y && n / 2 > x) {
				answer = answer + n * n - n * n / 4 * 2;
				y -= n / 2;
			} else if (n / 2 > y && n / 2 <= x) {
				answer = answer + n * n - n * n / 4 * 3;
				x -= n / 2;
			} else if (n / 2 > y && n / 2 > x) {
				answer = answer + n * n - n * n / 4 * 4;
			}
//			System.out.printf("-> %d %d %d %d\n", answer, x, y, n);
			n = n / 2;

		}
		System.out.println(answer);
	}
}
