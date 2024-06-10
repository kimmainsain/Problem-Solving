const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = Number(input[0]);
const arr = input[1].split(" ").map(Number);
const target = Number(input[2]);

function solution() {
  arr.sort((a, b) => a - b);
  let left = 0;
  let right = arr.length - 1;
  let answer = 0;
  while (left < right) {
    if (arr[left] + arr[right] === target) {
      answer++;
      left++;
    } else if (arr[left] + arr[right] < target) {
      left++;
    } else {
      right--;
    }
  }
  return answer;
}

console.log(solution());
