import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int answer[] = new int[n];
        ArrayList<int[]> list = new ArrayList<>();
        int ballType[] = new int[200001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, i});
        }
        list.sort((o1, o2) -> o1[1] - o2[1]);
        int j = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left[] = list.get(j);
            int right[] = list.get(i);
            while (left[1] < right[1]) {
                sum += left[1];
                ballType[left[0]] += left[1];
                left = list.get(++j);
            }
            answer[right[2]] = sum - ballType[right[0]];
        }
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}