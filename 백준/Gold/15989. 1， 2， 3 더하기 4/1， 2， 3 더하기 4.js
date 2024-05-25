const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input.slice(1).map(Number);

function solution(n, input) {
  const arr = new Array(10).fill(0);
  [arr[1], arr[2], arr[3]] = [1, 2, 3];
  let count = 6;
  for (let i = 4; i < 10001; i++) {
    const nextCount = parseInt(count / 2);
    arr[i] = arr[i - 3] + nextCount;
    count++;
  }
  return input.map((value) => arr[value]).join("\n");
}

console.log(solution(n, arr));
