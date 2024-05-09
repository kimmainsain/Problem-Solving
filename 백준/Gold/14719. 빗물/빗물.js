const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m] = input.shift().split(" ").map(Number);
const map = input.shift().split(" ").map(Number);
let answer = 0;

const solve = () => {
  let max = -1;
  const left = map.map((key, index) => {
    max = Math.max(key, max);
    return max;
  });
  max = -1;
  const right = map
    .reverse()
    .map((key, index) => {
      max = Math.max(key, max);
      return max;
    })
    .reverse();
  for (let i = 1; i < m - 1; i++) {
    answer += Math.min(left[i], right[i]) - map[i];
  }
};

solve();
console.log(answer);
