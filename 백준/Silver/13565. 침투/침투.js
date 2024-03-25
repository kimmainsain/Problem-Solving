// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString().trim().split("\n");

const [n, m] = input.shift().split(" ").map(Number);
const map = input.map((row) => row.split("").map((num) => Number(num)));
const visited = new Array(n).fill(false).map(() => new Array(m).fill(false));

const dy = new Array(0, 1, 0, -1);
const dx = new Array(1, 0, -1, 0);

const solution = () => {
  let qu = [];
  for (let i = 0; i < m; i++) {
    if (map[0][i] == 0) {
      qu.push([0, i]);
      visited[0][i] = true;
    }
  }
  while (qu.length !== 0) {
    const now = qu.shift();
    if (now[0] == n - 1) return true;
    for (let i = 0; i < 4; i++) {
      const nexty = now[0] + dy[i];
      const nextx = now[1] + dx[i];
      if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
      if (visited[nexty][nextx]) continue;
      if (map[nexty][nextx] === 1) continue;
      visited[nexty][nextx] = true;
      qu.push([nexty, nextx]);
    }
  }
  return false;
};

console.log(solution() == true ? "YES" : "NO");