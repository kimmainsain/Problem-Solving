import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Character> qu = new LinkedList<>();
		String str = br.readLine();
		int now_acgt[] = new int[4];
		int ans_acgt[] = new int[4];
		for (int i = 0; i < m; i++) {
			char c = str.charAt(i);
			if (c == 'A') {
				now_acgt[0]++;
			} else if (c == 'C') {
				now_acgt[1]++;
			} else if (c == 'G') {
				now_acgt[2]++;
			} else if (c == 'T') {
				now_acgt[3]++;
			}
			qu.add(c);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			ans_acgt[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		while (m <= n) {
			if (now_acgt[0] >= ans_acgt[0] && now_acgt[1] >= ans_acgt[1] && now_acgt[2] >= ans_acgt[2]
					&& now_acgt[3] >= ans_acgt[3]) {
				count++;
			}
			if (m == n) {
				break;
			}
			char check = qu.poll();
			char check2 = str.charAt(m);
			qu.add(check2);
			if (check == 'A') {
				now_acgt[0]--;
			} else if (check == 'C') {
				now_acgt[1]--;
			} else if (check == 'G') {
				now_acgt[2]--;
			} else if (check == 'T') {
				now_acgt[3]--;
			}
			if (check2 == 'A') {
				now_acgt[0]++;
			} else if (check2 == 'C') {
				now_acgt[1]++;
			} else if (check2 == 'G') {
				now_acgt[2]++;
			} else if (check2 == 'T') {
				now_acgt[3]++;
			}
			m++;
		}
		System.out.println(count);
	}

}
