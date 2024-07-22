const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");

const input = data.slice(1).map((v) => v.split(" ").map(Number));
for (let i = 0; i < input.length; i++) {
  console.log(input[i][0] * (input[i][2] - 1) + input[i][1]);
}
