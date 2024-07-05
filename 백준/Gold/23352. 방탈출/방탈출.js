const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m] = data[0].split(" ").map(Number);
const input = data.slice(1).map((v) => v.split(" ").map(Number));

const dy = [0, 1, 0, -1];
const dx = [1, 0, -1, 0];

let max = -1;
let maxLength = -1;

function bfs(y, x) {
  const qu = [];
  qu.push([y, x, 0]);
  const visited = new Array(n).fill(false).map((_) => new Array(m).fill(false));
  visited[y][x] = true;
  while (qu.length !== 0) {
    const now = qu.shift();
    let flag = false;
    for (let i = 0; i < 4; i++) {
      const nexty = now[0] + dy[i];
      const nextx = now[1] + dx[i];
      if (nexty > n - 1 || nexty < 0 || nextx > m - 1 || nextx < 0) continue;
      if (visited[nexty][nextx]) continue;
      if (input[nexty][nextx] === 0) continue;
      qu.push([nexty, nextx, now[2] + 1]);
      visited[nexty][nextx] = true;
      flag = true;
    }
    if (!flag) {
      if (maxLength < now[2]) {
        maxLength = now[2];
        max = input[now[0]][now[1]] + input[y][x];
      } else if (maxLength === now[2]) {
        max = Math.max(max, input[now[0]][now[1]] + input[y][x]);
      }
    }
  }
}

function solution() {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (input[i][j] === 0) continue;
      bfs(i, j);
    }
  }
  return max;
}

console.log(solution());
