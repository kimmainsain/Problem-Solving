import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        ArrayList<Integer> monster = new ArrayList<>();
        ArrayList<Integer> weapon = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                monster.add(b);
            } else if (a == 2) {
                weapon.add(b);
            }
        }
        Collections.sort(monster);
        Collections.sort(weapon);
        int i = 0;
        int j = 0;
        int answer = 0;
        while (true) {
            if (monster.size() > i && d > monster.get(i)) {
                d += monster.get(i);
                i++;
                answer++;
            } else {
                if (weapon.size() > j) {
                    d *= weapon.get(j);
                    j++;
                    answer++;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}