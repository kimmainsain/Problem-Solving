import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        loop:
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Map<String, Integer> hm = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String s = st.nextToken();
                if (hm.containsKey(s)) {
                    hm.put(s, hm.get(s) + 1);
                    if (hm.get(s) == 3) {
                        sb.append(0).append("\n");
                        continue loop;
                    }
                } else {
                    hm.put(s, 1);
                }
            }
            ArrayList<String> list = new ArrayList<>();
            for (String mbti : hm.keySet()) {
                for (int j = 0; j < hm.get(mbti); j++) {
                    list.add(mbti);
                }
            }
            int min = 100001;
            for (int j = 0; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    for (int o = k + 1; o < list.size(); o++) {
                        int count = 0;
                        for (int l = 0; l < 4; l++) {
                            if (list.get(j).charAt(l) != list.get(k).charAt(l)) count++;
                        }
                        for (int l = 0; l < 4; l++) {
                            if (list.get(j).charAt(l) != list.get(o).charAt(l)) count++;
                        }
                        for (int l = 0; l < 4; l++) {
                            if (list.get(o).charAt(l) != list.get(k).charAt(l)) count++;
                        }
                        min = Math.min(min, count);
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}