import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, m;
	static int node[];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		node = new int [n + 1];
		set();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					union(i, j);
				}
			}
		}
		st= new StringTokenizer(br.readLine());
		int arr[] = new int [m];
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int v = check(arr[0]);
		for (int i = 1; i < m; i++) {
			if (v != check(arr[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static int check(int a) {
		int y = find(a);
		return y;
	}
	
	public static void union(int a, int b) {
		int y = find(a);
		int x = find(b);
		if (x < y) {
			node[y] = x;
		} else {
			node[x] = y;
		}
	}
	
	public static int find(int value) {
		if (node[value] == value) {
			return value;
		}
		return node[value] = find(node[value]);
	}
	
	public static void set() {
		for (int i = 1; i <= n; i++) {
			node[i] = i;
		}
	}
	
}