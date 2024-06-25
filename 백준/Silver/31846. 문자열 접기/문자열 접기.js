const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const str = input[1];
const n = parseInt(input[2]);
const map = input.slice(3).map((v) => v.split(" ").map(Number));

function cal(newString) {
  let max = -1;
  for (let i = 0; i < newString.length - 1; i++) {
    let now = 0;
    for (let j = i; j >= 0; j--) {
      const index = 2 * i - j + 1;
      if (index < 0) continue;
      if (newString[j] === newString[index]) now++;
    }
    max = Math.max(max, now);
  }
  return max;
}

function solution() {
  const answer = [];
  for (let i = 0; i < map.length; i++) {
    const [start, end] = map[i];
    const newString = str.substring(start - 1, end);
    answer.push(cal(newString));
  }
  return answer.join("\n");
}

console.log(solution());
