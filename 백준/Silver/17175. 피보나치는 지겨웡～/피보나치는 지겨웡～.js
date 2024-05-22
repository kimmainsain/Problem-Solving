const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

function solution(n) {
  const answer = new Array(51);
  answer[0] = 1;
  answer[1] = 1;
  for (let i = 2; i < n + 1; i++) {
    answer[i] = (answer[i - 1] + answer[i - 2] + 1) % 1_000_000_007;
  }
  console.log(answer[n]);
}

solution(parseInt(input[0]));

// +2 +4 +6 +10 +16 +26 +32
