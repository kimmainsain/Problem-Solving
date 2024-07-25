const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n").map(Number);

console.log(parseInt(Math.min(data[0], data[1]) / 2 * 100));