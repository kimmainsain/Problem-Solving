// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString().trim().split("\n");

function solution() {
  const n = Number(input[0]);
  for (let i = 0; i < n; i++) {
    const [left, right] = input[i + 1].split(",").map(Number);
    console.log(left + right);
  }
}

solution();