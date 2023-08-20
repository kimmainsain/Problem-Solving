import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		System.out.println(sum - (long)((long)n * (long)(n - 1) / 2));
	}
}