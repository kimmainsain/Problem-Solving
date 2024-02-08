import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        visited[1] = true;
        for (int i = 2; i * i < n + 1; i++) {
            if (visited[i]) continue;
            for (int j = i * i; j < n + 1; j += i) {
                visited[j] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) list.add(i);
        }
        int answer = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int now = list.get(i);
            if (sum + now == n) {
                answer++;
                sum -= list.get(left);
                left++;
                i--;
            } else if (sum + now < n){ // right 오른쪽
                sum += now;
            } else if (sum + now > n) { // left 오른쪽
                sum -= list.get(left);
                left++;
                i--;
            }
        }
        System.out.println(answer);
    }
}