const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

const input = data.slice(1).map((v) => v.split(" ").map(Number));
let max = -1;
for (let i = 0; i < input.length; i++) {
  let sum = 0;
  const arr = input[i].slice(2).sort((a, b) => b - a);
  const arr2 = input[i].slice(0, 2).sort((a, b) => b - a);
  sum += arr[0];
  sum += arr[1];
  sum += arr2[0];
  max = Math.max(sum, max);
}

console.log(max);
