import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int [n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int boygirl = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int keepstart = start;
			if (boygirl == 1) {
				while (start <= n) {
					arr[start] = arr[start] == 1 ? 0 : 1;
					start += keepstart;
				}
			} else {
				int left = start - 1;
				int right = start + 1;
				if (left < 1 || right > n) {
					arr[start] = arr[start] == 1 ? 0 : 1;
					continue;
				}
				while (true) {
					if (left < 1 || right > n) {
						break;
					}
					if (arr[left] != arr[right]) {
						break;
					}
					left--;
					right++;
				}
				while (true) {
					left++;
					right--;
					if (left == right) {
						arr[start] = arr[start] == 1 ? 0 : 1;
						break;
					}
					arr[left] = arr[left] == 1 ? 0 : 1;
					arr[right] = arr[right] == 1 ? 0 : 1;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}