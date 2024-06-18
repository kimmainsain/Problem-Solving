const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

function solution(input) {
  let max = 0;
  let answer = "";
  for (let i = 0; i < input.length; i++) {
    const arr = input[i].split(" ");
    if (max < parseInt(arr[1])) {
      max = parseInt(arr[1]);
      answer = arr[0]
    }
  }
  return answer;
}

console.log(solution(input));
