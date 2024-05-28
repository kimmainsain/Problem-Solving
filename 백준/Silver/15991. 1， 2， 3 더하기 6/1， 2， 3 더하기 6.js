const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input.slice(1).map(Number);

function solution(n, input) {
  const dp = new Array(50001);
  [dp[0], dp[1], dp[2]] = [1, 2, 3];
  for (let i = 3; i < 50001; i++) dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
  return input.map((v) => dp[v >> 1]).join("\n");
}

console.log(solution(n, arr));
