import java.util.*;
import java.io.*;

class node {
	int number;
	int dir;
	boolean isShark;

	public node(int number, int dir, boolean isShark) {
		this.number = number;
		this.dir = dir;
		this.isShark = isShark;
	}
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static node map[][];

	static int dy[] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dx[] = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max;

	public static void swap(node fish, int y, int x, node newMap[][]) {
		for (int i = 0; i < 8; i++) {
			int nexty = dy[fish.dir] + y;
			int nextx = dx[fish.dir] + x;
			if (nexty < 0 || nexty > 4 - 1 || nextx < 0 || nextx > 4 - 1) { // 만약 외곽이면
				fish.dir = (fish.dir + 1) % 8; // 반시계회전 및 다시체크
				continue;
			}
			if (newMap[nexty][nextx] != null && newMap[nexty][nextx].isShark) {
				fish.dir = (fish.dir + 1) % 8;
				continue;
			}
			// 스왑 로직 구현
			node temp = newMap[nexty][nextx];
			newMap[nexty][nextx] = new node(fish.number, fish.dir, fish.isShark);
			newMap[y][x] = temp;
			break;
		}
	}

	public static void moveFish(node newMap[][]) {
		int count = 0;
		while (count++ <= 16) {
			loop: for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (newMap[i][j] != null && newMap[i][j].number == count && !newMap[i][j].isShark) {
						swap(newMap[i][j], i, j, newMap);
						break loop;
					}
				}
			}
		}
	}

	public static node findShark(node newMap[][]) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (newMap[i][j] != null && newMap[i][j].isShark) {
					return newMap[i][j];
				}
			}
		}
		return null;
	}

	public static void dfs(int y, int x, node newMap[][]) {
		newMap = deepCopyMap(newMap);
		moveFish(newMap);
		node shark = findShark(newMap);
		max = Math.max(max, shark.number);
		newMap[y][x] = null; // 상어자리는 비우기
		for (int i = 0; i < 4; i++) {
			int nexty = dy[shark.dir] * i + y;
			int nextx = dx[shark.dir] * i + x;
			if (nexty < 0 || nexty > 4 - 1 || nextx < 0 || nextx > 4 - 1) return;
			if (newMap[nexty][nextx] == null) continue;
			node temp = newMap[nexty][nextx];
			newMap[nexty][nextx] = new node(shark.number + temp.number, temp.dir, true);
			dfs(nexty, nextx, newMap);
			newMap[nexty][nextx] = temp;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0, map);
		System.out.println(max);
	}

	public static node[][] deepCopyMap(node original[][]) {
		node copy[][] = new node[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (original[i][j] != null) {
					copy[i][j] = new node(original[i][j].number, original[i][j].dir, original[i][j].isShark);
				}
			}
		}
		return copy;
	}

	public static void input() throws Exception {
		map = new node[4][4];
		int inputCount = 0;
		int yCount = 0;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				if (yCount == 0 && inputCount == 0)
					map[yCount][inputCount++] = new node(number, dir - 1, true);
				else
					map[yCount][inputCount++] = new node(number, dir - 1, false);
			}
			inputCount = 0;
			yCount++;
		}
	}
}
