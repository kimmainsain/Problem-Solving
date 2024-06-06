const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [m, n] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((v) => v.split("").map(Number));
const dy = [0, 1, 0, -1];
const dx = [1, 0, -1, 0];

function solution() {
  const qu = [];
  qu.push({ y: 0, x: 0, count: 0 });
  let min = Infinity;
  const visited = new Array(n).fill(false).map((_) => new Array(m).fill(false));
  while (qu.length !== 0) {
    const now = qu.shift();
    if (now.y === n - 1 && now.x === m - 1) min = Math.min(min, now.count);
    for (let i = 0; i < 4; i++) {
      const nexty = now.y + dy[i];
      const nextx = now.x + dx[i];
      if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
      if (visited[nexty][nextx]) continue;
      if (arr[nexty][nextx] === 1) qu.push({ y: nexty, x: nextx, count: now.count + 1 });
      if (arr[nexty][nextx] === 0) qu.unshift({ y: nexty, x: nextx, count: now.count });
      visited[nexty][nextx] = true;
    }
  }
  return min;
}

console.log(solution());
