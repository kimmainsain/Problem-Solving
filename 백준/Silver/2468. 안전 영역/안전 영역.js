const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(data[0]);
const map = data.slice(1).map((v) => v.split(" ").map(Number));

const dy = [0, 1, 0, -1];
const dx = [1, 0, -1, 0];
const water = new Array(n).fill(false).map(() => new Array(n).fill(false));
let max = -1;
let count = 0;

function bfs(y, x, h) {
  const qu = [[y, x]];
  while (qu.length !== 0) {
    const now = qu.shift();
    for (let i = 0; i < 4; i++) {
      const nexty = dy[i] + now[0];
      const nextx = dx[i] + now[1];
      if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
      if (map[nexty][nextx] < h) continue;
      if (water[nexty][nextx]) continue;
      water[nexty][nextx] = true;
      qu.push([nexty, nextx]);
    }
  }
}

function solution() {
  for (let h = 1; h < 101; h++) {
    water.forEach((v) => v.fill(false));
    count = 0;
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (map[i][j] < h) continue;
        if (water[i][j]) continue;
        bfs(i, j, h);
        count++;
      }
    }
    max = Math.max(max, count);
  }
  return max;
}

console.log(solution());
