const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n").slice(1);

console.log(input.map((v) => v.length > 5 && v.length < 10 ? "yes" : "no").join("\n"));