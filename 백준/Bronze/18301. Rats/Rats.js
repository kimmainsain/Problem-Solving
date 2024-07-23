const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split(" ").map(Number);

console.log(parseInt((data[0] + 1) * (data[1] + 1) / (data[2] + 1)) - 1);