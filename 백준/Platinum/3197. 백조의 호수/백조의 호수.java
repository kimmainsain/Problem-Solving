import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int dx[] = new int[] {1,0,-1,0};
	static int dy[] = new int[] {0,1,0, -1};
	static int n;
	static int m;
	static int birdX;
	static int birdY;
	static char map[][];
	static boolean visited[][];
	static boolean visited_bird[][];
	static Queue<int[]> qu_map;
	static Queue<int[]> qu_map2;
	static Queue<int[]> qu_bird;
	static Queue<int[]> qu_bird2;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		qu_map = new ArrayDeque<>();
		qu_map2 = new ArrayDeque<>();
		qu_bird = new ArrayDeque<>();
		qu_bird2 = new ArrayDeque<>();
		map = new char [n][m];
		visited = new boolean [n][m];
		visited_bird = new boolean [n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = str.charAt(j);
				if (c == '.') {
					qu_map.add(new int [] {i, j}); // 물은 모조리 큐에 넣어버림
					visited[i][j] = true;
				}
				if (c == 'L') {
					birdX = j;
					birdY = i; // 백조 좌표기억
					visited[i][j] = true;
					qu_map.add(new int [] {i, j}); // 백조가 있는 장소 또한 물
				}
				map[i][j] = c;
			}
		}

		qu_bird.add(new int[] {birdY, birdX}); // 백조의 시작 위치를 넣음
		visited_bird[birdY][birdX] = true; // 백조의 자리는 방문 완료
		while(true) {
			if (bfsBird(qu_bird, qu_bird2) == 1) { // 백조의 시작 좌표 큐, 비어있는 큐
				System.out.println(count);
				return;
			}
			count++; // 첫째 날
			bfsMap(qu_map, qu_map2); // 모든 물 좌표 큐, 비어있는 큐
			if (bfsBird(qu_bird2, qu_bird) == 1) { // 백조 주변의 얼음(첫날에 이미 녹았다.)큐, 비어있는 큐
				System.out.println(count);
				return;
			}
			count++;
			bfsMap(qu_map2, qu_map); // 모든 물 좌표 큐, 비어있는 큐
		}
	}

	public static int bfsBird(Queue<int[]> qu_bird, Queue<int[]> qu_bird2) {
		while (!qu_bird.isEmpty()) {
			int now[] = qu_bird.poll();
			int nowx = now[1];
			int nowy = now[0]; // 백조의 시작위치 // 얼음의 좌표
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if (nextx < 0 || nextx > m - 1 || nexty < 0 || nexty > n - 1)
					continue; // 인덱스체크
				if (map[nexty][nextx] == 'X' && visited_bird[nexty][nextx] == false) {
					qu_bird2.add(new int[] {nexty, nextx}); // 얼음을 만났고, 방문 안했으면 비어있는 큐에 넣음
					visited_bird[nexty][nextx] = true; // 방문 완료
				}
				if (map[nexty][nextx] == '.' && visited_bird[nexty][nextx] == false) {
					qu_bird.add(new int[] {nexty, nextx}); 
					// 방문 안한 물을 만나면 기존의 큐에 넣어 bfs계속 진행 // 얼음이 녹아 새로운 길이 생기면 기존의 큐에 넣어 bfs진행
					visited_bird[nexty][nextx] = true; // 방문 완료
				}
				if (map[nexty][nextx] == 'L' && visited_bird[nexty][nextx] == false) {
					return 1; // 백조 만났으면 즉시 종료
				}
			}
		}
		return 0;
	}

	public static void bfsMap(Queue<int[]> qu_map, Queue<int[]> qu_map2) {
		while (!qu_map.isEmpty()) {
			int now[] = qu_map.poll();
			int nowx = now[1];
			int nowy = now[0];
			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				if (nextx < 0 || nextx > m - 1 || nexty < 0 || nexty > n - 1)
					continue;  // 인덱스 체크
				if (visited[nexty][nextx])
					continue; // 방문 체크
				if (map[nexty][nextx] == 'X') {
					map[nexty][nextx] = '.'; // 얼음이면 녹이고
					visited[nexty][nextx] = true; // 방문 체크하고
					qu_map2.add(new int [] {nexty, nextx}); // 비어있는 큐에 넣음
				}
			}
		}
	}
}