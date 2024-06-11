const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split(" ").map((v) => BigInt(v));
console.log(String(input[0] + input[1]));