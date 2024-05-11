const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input.shift());
const arr = input.map(Number).sort();

const set = new Set();
let answer = -1;

const solution = () => {
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      set.add(arr[i] + arr[j]);
    }
  }
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      const value = arr[i] - arr[j];
      if (set.has(value)) {
        answer = Math.max(answer, arr[i]);
      }
    }
  }
  console.log(answer);
};

solution();
