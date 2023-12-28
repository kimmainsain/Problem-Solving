import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int knowP;

    static Set<Integer> set;
    static ArrayList<Integer> list[];

    static Set<Integer> stopIndex;

    private static void solve() {
        stopIndex = new HashSet<>();
        boolean flag = false;
        while (true) {
            loop : for (int i = 0; i < m; i++) {
                if (stopIndex.contains(i)) continue;
                for (int j = 0; j < list[i].size(); j++) {
                    int v = list[i].get(j);
                    if (set.contains(v)) {
                        addSet(i);
                        stopIndex.add(i);
                        flag = true;
                        continue loop;
                    }
                }
            }
            if (!flag) break;
            flag = false;
        }
        System.out.println(m - stopIndex.size());
    }

    private static void addSet(int y) {
        for (int i = 0; i < list[y].size(); i++) {
            int v = list[y].get(i);
            set.add(v);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        knowP = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        list = new ArrayList[m];
        for (int i = 0; i < knowP; i++) {
            int v = Integer.parseInt(st.nextToken());
            set.add(v);
        }
        for (int i = 0; i < m; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nn; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
//            System.out.println(list[i]);
        }

    }
}