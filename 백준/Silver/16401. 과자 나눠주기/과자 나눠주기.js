const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

function cal(arr, value) {
  let count = 0;
  for (let i = 0; i < arr.length; i++) {
    count += Math.floor(arr[i] / value);
  }
  return count;
}

function solution(arr) {
  let left = 0;
  let right = 1_000_000_001;
  while (left <= right) {
    const mid = (left + right) >> 1;
    const count = cal(arr, mid);
    if (count < n) right = mid - 1;
    else left = mid + 1;
  }
  return left - 1;
}

console.log(solution(arr.sort((a, b) => a - b)));
