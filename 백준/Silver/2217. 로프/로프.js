const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input.shift());
let max = Number.MIN_VALUE;
input.map(Number).sort((a, b) => b - a).forEach((value, index) => {
  max = Math.max(max, value * ++index);
});
console.log(max);
