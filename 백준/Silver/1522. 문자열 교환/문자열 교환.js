const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim();

function solution(input) {
  let countB = 0;
  for (let i = 0; i < input.length; i++) if (input[i] === "b") countB++;
  circle = input + input;
  let min = Infinity;
  for (let i = 0; i < input.length; i++) {
    let ca = 0;
    for (let j = i; j < i + countB; j++) {
      if (circle[j] === "a") ca++;
    }
    min = Math.min(ca, min);
  }
  return min;
}

console.log(solution(input));
