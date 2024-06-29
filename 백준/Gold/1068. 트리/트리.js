const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(data[0]);
const input = data[1].split(" ").map(Number);
const remove = parseInt(data[2]);
let answer = 0;

function dfs(start, list) {
  if (start === remove) return;
  if (list[start].length === 0) {
    answer++;
    return;
  }
  for (let i = 0; i < list[start].length; i++) {
    const v = list[start][i];
    if (v === remove) {
      if (list[start].length === 1) answer++;
    }
    else dfs(v, list);
  }
}

function solution() {
  const list = new Array(n).fill().map(() => []);
  let root = 0;
  for (let i = 0; i < input.length; i++) {
    if (input[i] === -1) {
      root = i;
      continue;
    }
    list[input[i]].push(i);
  }
  dfs(root, list);
  return answer;
}

console.log(solution());
