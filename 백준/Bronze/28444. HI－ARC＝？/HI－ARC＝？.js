const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split(" ").map(Number);

console.log(data[0] * data[1] - data[2] * data[3] * data[4]);