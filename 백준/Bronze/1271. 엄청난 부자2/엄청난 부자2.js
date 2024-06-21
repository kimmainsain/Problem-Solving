const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split(" ").map(BigInt);

console.log(input[0] / input[1] + "\n" + input[0] % input[1])