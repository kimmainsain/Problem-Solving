import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int max = -1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            max = Math.max(Math.abs(value), max);
            if (value > 0) left.add(value);
            else right.add(-value);
        }
        Collections.sort(left);
        Collections.sort(right);
        for (int i = left.size() - 1; i >= 0; i--) {
            answer += left.get(i) * 2;
            for (int j = 0; j < m - 1; j++) i--;
        }
        for (int i = right.size() - 1; i >= 0; i--) {
            answer += right.get(i) * 2;
            for (int j = 0; j < m - 1; j++) i--;
        }
        System.out.println(answer - max);
    }
}