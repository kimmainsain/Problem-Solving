const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n")
  .map(Number);

let answer = "";
for (let i = 0; i < data[0]; i++) {
  for (let j = 0; j < data[1]; j++) {
    answer += "*";
  }
  answer += "\n";
}
console.log(answer);
