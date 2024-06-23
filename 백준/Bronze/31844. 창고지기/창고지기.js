const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim();

function solution(input) {
  const a = input.indexOf("@");
  const b = input.indexOf("#");
  const c = input.indexOf("!");

  if ((a < b && b < c) || (c < b && b < a)) return Math.abs(a - c) - 1;
  return -1;
}

console.log(solution(input));