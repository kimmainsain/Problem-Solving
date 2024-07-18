const path = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const data = require("fs").readFileSync(path).toString().trim();

console.log(Number(data[0]) === 0 ? "YONSEI" : "Leading the Way to the Future");
