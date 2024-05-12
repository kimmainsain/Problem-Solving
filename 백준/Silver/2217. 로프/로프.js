const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input.shift());
const arr = input.map(Number).sort((a, b) => b - a);

let max = Number.MIN_VALUE;
let index = 1;
while(arr.length !== 0) {
  max = Math.max(max, arr.shift() * index++);
}
console.log(max);
