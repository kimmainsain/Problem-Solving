// const FS = require("fs").readFileSync("input.txt");
const FS = require("fs").readFileSync("/dev/stdin");
const input = FS.toString();

const answer = [];

function solution() {
  const n = Number(input);
  for (let i = 1; i < n + 1; i++) {
    let str = "";
    str += "*".repeat(i);
    str += " ".repeat((n - i) * 2);
    str += "*".repeat(i);
    answer.push(str);
  }
  for (let i = n - 1; i > 0; i--) {
    let str = "";
    str += "*".repeat(i);
    str += " ".repeat((n - i) * 2);
    str += "*".repeat(i);
    answer.push(str)
  }
}

solution();

console.log(answer.join("\n"));