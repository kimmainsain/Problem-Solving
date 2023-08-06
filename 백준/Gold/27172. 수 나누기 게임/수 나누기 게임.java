import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		boolean input[] = new boolean [1000001];
		int score[] = new int [1000001];
		
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			list.add(value);
			input[value] = true;
		}
		
		for (int i = 0; i < n; i++) {
			int value = list.get(i);
			for (int j = value * 2; j < 1000001; j += value) {
				if (input[j]) {
					score[j]--;
					score[value]++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			sb.append(score[list.get(i)]).append(" ");
		}
		System.out.println(sb);
	}
}