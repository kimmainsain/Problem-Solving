const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input.slice(1).map(Number);

function solution() {
  let max = arr[0];
  let prev = arr[0];
  let answer = 0;
  for (let i = 1; i < arr.length; i++) {
    const now = arr[i];
    if (now < max) {
      if (prev > now) {
        answer += prev - now;
      }
    } else if (max < now) {
      answer += now - max;
      max = Math.max(max, now);
    }
    prev = now;
    // console.log(`now : ${now}, answer : ${answer}, max : ${max}`);
  }
  return answer;
}

console.log(solution());
