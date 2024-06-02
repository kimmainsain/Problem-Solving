const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((value) => value.split("").map(Number));

const dy = [1, 0, -1, 0];
const dx = [0, 1, 0, -1];

function getVirus(arr, visited, y, x) {
  const keep = [];
  const qu = [];
  qu.push([y, x]);
  visited[y][x] = true;
  keep.push({ y: y, x: x, speed: arr[y][x] });
  while (qu.length !== 0) {
    const now = qu.pop();
    for (let i = 0; i < 4; i++) {
      const nexty = now[0] + dy[i];
      const nextx = now[1] + dx[i];
      if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
      if (arr[nexty][nextx] === 0) continue;
      if (visited[nexty][nextx] === true) continue;
      keep.push({ y: nexty, x: nextx, speed: arr[nexty][nextx] });
      visited[nexty][nextx] = true;
      qu.push([nexty, nextx]);
    }
  }
  return keep;
}

function widen(virus, arr) {
  while (virus.length !== 0) {
    const now = virus.shift();
    for (let nexty = now.y - now.speed; nexty < now.y + now.speed + 1; nexty++) {
      for (let nextx = now.x - now.speed; nextx < now.x + now.speed + 1; nextx++) {
        if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
        if (arr[now.y][now.x] <= arr[nexty][nextx]) continue;
        arr[nexty][nextx] = Math.max(now.speed, arr[nexty][nextx]);
      }
    }
  }
}

function solution(arr, n, m) {
  const virus = [];
  let count = 0;
  while (true) {
    const visited = new Array(n).fill(false).map((_) => new Array(m).fill(false));
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < m; j++) {
        if (arr[i][j] === 0 || visited[i][j] === true) continue;
        virus.push(getVirus(arr, visited, i, j, true));
      }
    }
    if (virus.length <= 1) break;
    while (virus.length !== 0) {
      const curVirus = virus.pop();
      widen(curVirus, arr);
    }
    count++;
  }
  return count;
}
console.log(solution(arr, n, m));
