import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        char c = ' ';
        int count[] = new int[4];
        String check = "wolf";
        for (int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            if (c == ' ') c = value;
            else if (c == 'f' && value == 'w') {
                if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) ;
                else {
                    System.out.println(0);
                    return;
                }
                for (int j = 0; j < 4; j++) count[j] = 0;
                c = value;
            } else if (c == 'w' && value == 'o') c = value;
            else if (c == 'o' && value == 'l') c = value;
            else if (c == 'l' && value == 'f') c = value;
            else if (c == value) ;
            else {
                System.out.println(0);
                return;
            }
            int idx = check.indexOf(value);
            count[idx]++;
        }
        if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) System.out.println(1);
        else System.out.println(0);
    }
}