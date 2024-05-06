import java.io.*;
import java.util.*;

class node {
    int level;
    String name;

    public node(int level, String name) {
        this.level = level;
        this.name = name;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<node>> list;
    static int n, m;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(n);
        loop:
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            for (int j = 0; j < list.size(); j++) {
                int value = list.get(j).get(0).level;
                if (list.get(j).size() == m) continue;
                if (level >= value - 10 && level <= value + 10) {
                    list.get(j).add(new node(level, name));
                    continue loop;
                }
            }
            ArrayList<node> nextList = new ArrayList<>();
            nextList.add(new node(level, name));
            list.add(nextList);
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).sort((o1, o2) -> o1.name.compareTo(o2.name));
            if (list.get(i).size() == m) sb.append("Started!").append("\n");
            else sb.append("Waiting!").append("\n");
            for (int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j).level).append(" ").append(list.get(i).get(j).name).append("\n");
            }
        }
        System.out.println(sb);
    }
}