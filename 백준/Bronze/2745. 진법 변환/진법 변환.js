const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split(" ");
console.log(parseInt(input[0], input[1]));
