import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int input[] = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            input[i] = v;
            if (set.contains(v)) continue;
            set.add(v);
            list.add(v);
        }
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for (int i = 0; i < n; i++) {
            sb.append(map.get(input[i])).append(" ");
        }
        System.out.println(sb);
    }
}