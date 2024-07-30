const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n");
const n = Number(data.splice(0, 1));
for (let i = 0; i < n; i++) {
  console.log(data[i].split(" ").map(Number).reduce((a, b) => a + b));
}