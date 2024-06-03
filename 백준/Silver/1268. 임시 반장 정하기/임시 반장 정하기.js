const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input.slice(1).map((value) => value.split(" ").map(Number));

function solution(arr, n) {
  const answer = new Array(n).fill(0).map((v) => new Array(n).fill(0));
  for (let i = 0; i < 5; i++) {
    for (let j = 0; j < n; j++) {
      for (let k = j + 1; k < n; k++) {
        if (arr[j][i] === arr[k][i]) {
          answer[j][k] = 1;
          answer[k][j] = 1;
        }
      }
    }
  }
  let max = -1;
  let index = -1;
  for (let i = 0; i < n; i++) {
    let count = 0;
    for (let j = 0; j < n; j++) {
      count += answer[i][j];
    }
    if (max < count) {
      index = i;
      max = count;
    }
  }
  return index + 1;
}
console.log(solution(arr, n));
