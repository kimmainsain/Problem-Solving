const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
const arr = input.slice(1).map((value) => value.split(" ").map(Number));

function solution(n, input) {
  let [start, end] = input[0];
  let answer = Math.abs(end - start);

  for (let i = 1; i < input.length; i++) {
    let [nextStart, nextEnd] = input[i];
    answer += Math.abs(nextEnd - nextStart);
    if (nextStart < end) {
      if (nextEnd < end) answer -= Math.abs(nextEnd - nextStart);
      else answer -= Math.abs(end - nextStart);
    }
    [start, end] = [nextStart, Math.max(end, nextEnd)];
  }
  return answer;
}

console.log(solution(n, arr));
