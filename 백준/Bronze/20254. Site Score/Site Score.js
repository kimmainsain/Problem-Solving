const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split(" ").map(Number);

console.log(data[0] * 56 + data[1] * 24 + data[2] * 14 + data[3] * 6);