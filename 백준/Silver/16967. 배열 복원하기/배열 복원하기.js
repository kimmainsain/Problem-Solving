const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const [n, m, y, x] = input[0].split(" ").map(Number);
const board = input.slice(1).map((v) => v.split(" ").map(Number));

for (let i = 0; i < n; i++) {
  let answer = "";
  for (let j = 0; j < m; j++) {
    board[i + y][j + x] -= board[i][j];
    answer += board[i][j] + " ";
  }
  console.log(answer);
}
