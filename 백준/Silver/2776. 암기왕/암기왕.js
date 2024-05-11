const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const testcase = Number(input.shift());
let answer = "";

const solution = () => {
  for (let i = 0; i < testcase; i++) {
    const n = Number(input.shift());
    const set = new Set();
    input
      .shift()
      .split(" ")
      .map((value) => set.add(Number(value)));
    const m = Number(input.shift());
    input
      .shift()
      .split(" ")
      .map((value) => {
        if (set.has(Number(value))) answer += 1 + "\n";
        else answer += 0 + "\n";
      });
  }
  console.log(answer);
};

solution();
