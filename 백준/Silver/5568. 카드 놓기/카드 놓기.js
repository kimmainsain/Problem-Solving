// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString().trim().split("\n").map(Number);

const n = input[0];
const k = input[1];

const dfs = (depth, visited, input, set, num) => {
  if (depth == k) {
    set.add(num);
    return;
  }
  for (let i = 0; i < input.length; i++) {
    if (!visited[i]) {
      visited[i] = true;
      dfs(depth + 1, visited, input, set, num + input[i]);
      visited[i] = false;
    }
  }
};

const solution = (input) => {
  const visited = Array.from({ length: n }, () => false);
  const set = new Set();
  dfs(0, visited, input, set, "");
  console.log(set.size);
};

solution(input.slice(2));