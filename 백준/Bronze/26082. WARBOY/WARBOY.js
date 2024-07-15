const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split(" ").map(Number);

console.log(3 * data[1] / data[0] * data[2]);