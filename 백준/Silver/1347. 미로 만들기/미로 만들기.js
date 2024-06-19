const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n")[1];

const dy = [1, 0, -1, 0]; // 남 서 북 동
const dx = [0, -1, 0, 1];

const max = 101;

function solution(input) {
  const map = new Array(max).fill("#").map((v) => new Array(max).fill("#"));
  const user = { y: max >> 1, x: max >> 1, dir: 0 };
  const matrix = { minY: max >> 1, minX: max >> 1, maxY: max >> 1, maxX: max >> 1};
  map[max >> 1][max >> 1] = ".";

  for (let i = 0; i < input.length; i++) {
    const value = input[i];
    if (value === "F") {
      const nexty = user.y + dy[user.dir];
      const nextx = user.x + dx[user.dir];
      map[nexty][nextx] = ".";
      user.y = nexty;
      user.x = nextx;
      matrix.minY = Math.min(matrix.minY, user.y);
      matrix.minX = Math.min(matrix.minX, user.x);
      matrix.maxY = Math.max(matrix.maxY, user.y);
      matrix.maxX = Math.max(matrix.maxX, user.x);
    } else if (value === "L") {
      user.dir = (user.dir - 1 + 4) % 4;
    } else if (value === "R") {
      user.dir = (user.dir + 1 + 4) % 4;
    }
  }
  const answer = [];
  for (let i = matrix.minY; i < matrix.maxY + 1; i++) {
    const temp = [];
    for (let j = matrix.minX; j < matrix.maxX + 1; j++) {
      temp.push(map[i][j]);
    }
    answer.push(temp);
  }
  // console.log(`minY : ${matrix.minY} maxY : ${matrix.maxY} minX : ${matrix.minX} maxX : ${matrix.maxX}`);
  return answer.map((v) => v.join("")).join("\n");
}

console.log(solution(input));
