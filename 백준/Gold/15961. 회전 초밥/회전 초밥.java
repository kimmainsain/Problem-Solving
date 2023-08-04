import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, d, k, c;
	static int sushi[];
	static int max;
	static int visited[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[n + k - 1];
		visited = new int[d + 1];
		max = -2147483648;
		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int j = 0;
		for (int i = n; i < n + k - 1; i++) {
			sushi[i] = sushi[j++];
		}
		int count = 1;
		visited[c]++;
		for (int i = 0; i < k; i++) {
			if (visited[sushi[i]] == 0) {
				count++;
			}
			visited[sushi[i]]++;
		}
		max = count;
		for (int i = k; i < n + k - 1; i++) {
			visited[sushi[i - k]]--;
			if (visited[sushi[i - k]] == 0) {
				count--;
			}
			if (visited[sushi[i]] == 0) {
				count++;
			}
			visited[sushi[i]]++;
			max = Math.max(count, max);
		}
		System.out.println(max);
	}
}