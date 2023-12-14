import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            boolean flag = false;
            boolean error = false;
            while (st.hasMoreTokens()) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!flag) { // 앞에있는거버림
                    if (c == 'R') {
                        flag = true;
                    } else if (c == 'D') {
                        if (dq.isEmpty()) {
                            error = true;
                            break;
                        }
                        dq.poll();
                    }
                } else {
                    if (c == 'R') {
                        flag = false;
                    } else if (c == 'D') {
                        if (dq.isEmpty()) {
                            error = true;
                            break;
                        }
                        dq.pollLast();
                    }
                }
            }
            if (error) sb.append("error\n");
            else {
                if (!flag) {
                    sb.append("[");
                    boolean f = false;
                    while (!dq.isEmpty()) {
                        sb.append(dq.poll()).append(",");
                        f = true;
                    }
                    if (f) sb.deleteCharAt(sb.length() - 1);
                    sb.append("]\n");
                } else {
                    sb.append("[");
                    boolean f = false;
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast()).append(",");
                        f = true;
                    }
                    if (f) sb.deleteCharAt(sb.length() - 1);
                    sb.append("]\n");
                }
            }
        }
        System.out.println(sb);
    }
}
