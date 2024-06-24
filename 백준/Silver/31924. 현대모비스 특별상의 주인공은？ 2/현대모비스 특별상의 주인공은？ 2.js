const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const map = input.slice(1).map((v) => v.split(""));

const dy = [-1, -1, -1, 0, 1, 1, 1, 0];
const dx = [-1, 0, 1, 1, 1, 0, -1, -1];

function searchWord(x, y, dir) {
  const target = "MOBIS";
  for (let i = 0; i < target.length; i++) {
    const nexty = y + dy[dir] * i;
    const nextx = x + dx[dir] * i;
    if (nextx < 0 || nexty < 0 || nextx > n - 1 || nexty > n - 1) return false;
    if (map[nextx][nexty] !== target[i]) return false;
  }
  return true;
}

function solution(map) {
  let count = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      for (let k = 0; k < 8; k++) {
        if (searchWord(i, j, k)) count++;
      }
    }
  }
  return count;
}

console.log(solution(map));
