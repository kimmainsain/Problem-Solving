import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        }));
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String temp = "";
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c >= '0' && c <= '9') {
                    temp += c;
                } else {
                    if (!temp.isEmpty()) {
                        temp = temp.replaceAll("^0+", "");
                        if (temp.isEmpty()) {
                            pq.add("0");
                            continue;
                        }
                        pq.add(temp);
                        temp = "";
                    }
                }
            }
            if (!temp.isEmpty()) {
                temp = temp.replaceAll("^0+", "");
                if (temp.isEmpty()) {
                    pq.add("0");
                    continue;
                }
                pq.add(temp);
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}