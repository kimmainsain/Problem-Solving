// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString().trim().split("\n");
const answer = [];

function solution() {
  const n = Number(input[0]);
  for (let i = 0; i < n; i++) {
    const [left, right] = input[i + 1].split(",").map(Number);
    answer.push(left + right);
  }
  console.log(answer.join("\n"));
}

solution();