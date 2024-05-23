const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input[1].split(" ").map(Number);
const money = parseInt(input[2]);

function solution(n, input, money) {
  let answer = 0;
  for (let i = 0; i < n; i++) {
    const value = input[i];
    if (value * (n - i) >= money) {
      //
      answer = parseInt(money / (n - i));
      return answer;
    }
    money = money - value;
    answer = value;
  }
  return answer;
}

console.log(
  solution(
    n,
    arr.sort((a, b) => a - b),
    money
  )
);
