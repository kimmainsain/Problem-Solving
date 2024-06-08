const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = require("fs").readFileSync(path).toString().trim().split("\n");

const n = parseInt(input[0]);
input.slice(1).map((v, i) => console.log(`${i + 1}. ${v}`));
