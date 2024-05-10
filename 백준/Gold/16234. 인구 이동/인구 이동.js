const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, left, right] = input.shift().split(" ").map(Number);
const board = input.map((key) => key.split(" ").map(Number));
const visited = new Array(n).fill(false).map(() => new Array(n).fill(false));

const dy = new Array(0, 1, 0, -1);
const dx = new Array(1, 0, -1, 0);
let flag = false;

const 범위체크 = (value) => {
  if (value < left || value > right) return false;
  return true;
};

const 범위체크2 = (nexty, nextx) => {
  if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) return false;
  return true;
};

const bfs = (y, x) => {
  const qu = [{ y: y, x: x }];
  const qu2 = [{ y: y, x: x }];
  visited[y][x] = true;
  let count = 1;
  let sum = board[y][x];
  while (!qu.length == 0) {
    const now = qu.shift();
    for (let i = 0; i < 4; i++) {
      const nexty = now.y + dy[i];
      const nextx = now.x + dx[i];
      if (!범위체크2(nexty, nextx)) continue;
      if (!범위체크(Math.abs(board[now.y][now.x] - board[nexty][nextx])))
        continue;
      if (visited[nexty][nextx]) continue;
      qu.push({ y: nexty, x: nextx });
      qu2.push({ y: nexty, x: nextx });
      visited[nexty][nextx] = true;
      count++;
      sum += board[nexty][nextx];
    }
  }
  if (qu2.length === 1) return;
  flag = true;
  const nextValue = parseInt(sum / count);
  qu2.forEach((key) => {
    board[key.y][key.x] = nextValue;
  });
};

const solution = () => {
  let answer = 0;
  while (true) {
    flag = false;
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (visited[i][j]) continue;
        bfs(i, j);
      }
    }
    if (!flag) break;
    answer++;
    visited.forEach((key) => key.fill(false));
  }
  console.log(answer);
};

solution();
