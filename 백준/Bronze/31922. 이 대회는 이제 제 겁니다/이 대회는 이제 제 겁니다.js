const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split(" ").map(Number);

console.log(Math.max(input[0] + input[2], input[1]));