const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input[1].split(" ").map(Number);

function solution(n, input) {
  let descCount = 0;
  let ascCount = 0;
  const ascInput = input.map((v) => v);
  const descInput = input.map((v) => v);
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      if (descInput[i] < descInput[j]) {
        [descInput[i], descInput[j]] = [descInput[j], descInput[i]];
        descCount++;
      }
      if (ascInput[i] > ascInput[j]) {
        [ascInput[i], ascInput[j]] = [ascInput[j], ascInput[i]];
        ascCount++;
      }
    }
  }
  return Math.min(descCount + 1, ascCount);
}

console.log(solution(n, arr));
