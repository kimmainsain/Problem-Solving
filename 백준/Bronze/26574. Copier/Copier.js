const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim().split("\n").map(Number);

for(let i = 1; i < data[0] + 1; i++) {
console.log(data[i] + " " + data[i])
}
