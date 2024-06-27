const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = parseInt(require("fs").readFileSync(path).toString().trim());

console.log(8 + parseInt(Math.log2(input)) + 2);
