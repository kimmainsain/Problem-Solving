import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[21];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")) {
                for (int j = 1; j < 21; j++) visited[j] = true;
                continue;
            } else if (str.equals("empty")) {
                for (int j = 1; j < 21; j++) visited[j] = false;
                continue;
            }
            int value = Integer.parseInt(st.nextToken());
            if (str.equals("add")) {
                visited[value] = true;
            } else if (str.equals("remove")) {
                visited[value] = false;
            } else if (str.equals("check")) {
                if (visited[value]) sb.append("1\n");
                else sb.append("0\n");
            } else if (str.equals("toggle")) {
                if (visited[value]) visited[value] = false;
                else visited[value] = true;
            }
        }
        System.out.println(sb);
    }

}