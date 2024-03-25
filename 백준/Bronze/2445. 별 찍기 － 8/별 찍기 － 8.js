// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString();

const answer = [];
let str = "";

function solution() {
  const n = Number(input);
  for (let i = 1; i < n + 1; i++) {
    str += "*".repeat(i);
    str += " ".repeat((n - i) * 2);
    str += "*".repeat(i) + "\n";
  }
  for (let i = n - 1; i > 0; i--) {
    str += "*".repeat(i);
    str += " ".repeat((n - i) * 2);
    str += "*".repeat(i) + "\n";
  }
}

solution();

console.log(str);