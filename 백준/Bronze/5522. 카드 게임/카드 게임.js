const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n").map(Number);

console.log(data.reduce((acc, cur) => acc+cur));