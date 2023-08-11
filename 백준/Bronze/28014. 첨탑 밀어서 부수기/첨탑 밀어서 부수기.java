import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int count = 1;
		for (int i = 0; i < n - 1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (s > temp) {
				s = temp;
			} else {
				count++;
				s = temp;
			}
		}
		System.out.println(count);
	}
}
