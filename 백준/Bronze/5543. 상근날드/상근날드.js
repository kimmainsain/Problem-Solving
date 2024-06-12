const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

console.log(Math.min(...input.slice(0, 3)) + Math.min(...input.slice(-2)) - 50);
