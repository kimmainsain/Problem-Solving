const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

function solution(arr) {
  const map = new Map();
  const answer = [];
  for (let i = 0; i < arr.length; i++) {
    const treeName = arr[i];
    if (map.has(treeName)) map.set(treeName, map.get(treeName) + 1);
    else map.set(treeName, 1);
  }
  map.forEach((value, key) => {
    answer.push([key, ((value / arr.length) * 100).toFixed(4)]);
  });
  answer.sort((a, b) => (a[0] > b[0] ? 1 : -1));
  return answer.map((v) => v.join(" ")).join("\n");
}

console.log(solution(input));
