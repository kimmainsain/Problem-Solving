const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m, k] = input.shift().split(" ").map(Number);
const board = new Array(n).fill(false).map(() => new Array(m).fill(false));
const visited = new Array(n).fill(false).map(() => new Array(m).fill(false));

const dy = new Array(0, 1, 0, -1);
const dx = new Array(1, 0, -1, 0);

const qu = [];
let answer = -1;

for (let i = 0; i < k; i++) {
  const [y, x] = input[i].split(" ").map(Number);
  board[y - 1][x - 1] = true;
}

const bfs = (y, x) => {
  qu.push([y, x]);
  visited[y][x] = true;
  let count = 1;
  while (!qu.length == 0) {
    const now = qu.shift();
    for (let i = 0; i < 4; i++) {
      const nexty = now[0] + dy[i];
      const nextx = now[1] + dx[i];
      if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
      if (visited[nexty][nextx]) continue;
      if (!board[nexty][nextx]) continue;
      visited[nexty][nextx] = true;
      qu.push([nexty, nextx]);
      count++;
    }
  }
  answer = Math.max(answer, count);
};

const solve = () => {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (board[i][j] == true && visited[i][j] == false) {
        bfs(i, j);
      }
    }
  }
  console.log(answer);
};

solve();
