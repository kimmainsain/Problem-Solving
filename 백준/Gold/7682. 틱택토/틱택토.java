import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int dy[] = new int[]{0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 1, 2, 2, 1, 0};
    static int dx[] = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
    static char map[][];

    private static int vali(char c) {
        int count = 0;
        int answer = 0;
        for (int i = 0; i < dy.length - 6; i++) {
            if (map[dy[i]][dx[i]] == c) {
                count++;
            }
            if (i % 3 == 2) {
                if (count == 3) answer++;
                count = 0;
            }
        }
        int sanswer = 0;
        for (int i = dy.length - 6; i < dy.length; i++) {
            if (map[dy[i]][dx[i]] == c) {
                count++;
            }
            if (i % 3 == 2) {
                if (sanswer == 1 && count == 3) {
                    continue;
                }
                if (count == 3) sanswer++;
                count = 0;
            }
        }
        return answer + sanswer;
    }

    private static boolean isVali() {
        if (xVali > 0) {
            if (oVali > 0) return false;
            if (xCount - oCount == 1) return true;
            else return false;
        }
        if (oVali > 0) {
            if (xCount - oCount == 0) return true;
            else return false;
        }
        if (xCount + oCount == 9) return true;
        return false;
    }

    static int xVali, oVali, xCount, oCount;

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;
            map = new char[3][3];
            int idx = 0;
            xCount = 0;
            oCount = 0;
            xVali = 0;
            oVali = 0;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    char c = str.charAt(idx++);
                    if (c == 'O') oCount++;
                    else if (c == 'X') xCount++;
                    map[i][j] = c;
                }
            if (xCount - oCount != 0 && xCount - oCount != 1) {
                sb.append("invalid\n");
                continue;
            }
            xVali = vali('X');
            oVali = vali('O');
            if (isVali()) sb.append("valid\n");
            else sb.append("invalid\n");
        }
        System.out.println(sb);
    }
}