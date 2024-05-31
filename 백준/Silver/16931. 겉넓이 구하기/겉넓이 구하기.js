const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((value) => value.split(" ").map(Number));

function Converter(arr) {
  const a = new Array(n + 2).fill(0).map((v) => new Array(m + 2).fill(0));
  for (let i = 1; i < n + 1; i++) {
    for (let j = 1; j < m + 1; j++) {
      a[i][j] = arr[i - 1][j - 1];
    }
  }
  return a;
}

function solution(arr, n, m) {
  let count = 0;
  // 아래에서 위로, 121, 322, 434
  for (let i = 1; i < m + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      const now = arr[j][i];
      const prev = arr[j - 1][i];
      if (now > prev) count += now - prev;
    }
  }
  // 134 223 124
  for (let i = 1; i < n + 1; i++) {
    for (let j = 1; j < m + 1; j++) {
      const now = arr[i][j];
      const prev = arr[i][j - 1];
      if (now > prev) count += now - prev;
    }
  }
  return (count + n * m) << 1;
}
console.log(solution(Converter(arr), n, m));
